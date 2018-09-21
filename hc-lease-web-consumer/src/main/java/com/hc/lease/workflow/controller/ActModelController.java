package com.hc.lease.workflow.controller;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.conf.FormPostParam;
import com.hc.lease.workflow.service.api.ActRepositoryService;
import com.hc.lease.workflow.util.Page;
import com.hc.lease.workflow.vo.ActModelPageQuery;
import com.hc.lease.workflow.vo.ActModelResourceDTO;
import com.hc.lease.workflow.vo.ActModelVO;
import com.hc.lease.workflow.vo.CreateModelDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 流程模型控制器
 *
 * @author henryyan
 */
@Slf4j
@Controller
@RequestMapping(value = "/workflow/model")
public class ActModelController {

    @Resource
    private ActRepositoryService actRepositoryService;

    /**
     * 模型列表
     */
    @RequestMapping(value = "list")
    public String modelList(@FormPostParam ActModelPageQuery actModelPageQuery, Model model) {
        PageInfo<ActModelVO> pageInfo = actRepositoryService.pageFindModels(actModelPageQuery);
        Page<ActModelVO> page = new Page<>(actModelPageQuery.getPageNum(), actModelPageQuery.getPageSize(), pageInfo.getTotal(), pageInfo.getList());
        model.addAttribute("queryParam", actModelPageQuery);
        model.addAttribute("page", page);
        return "/modules/act/actModelList";
    }

    /**
     * 创建模型视图
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create() {
        return "/modules/act/actModelCreate";
    }

    /**
     * 创建模型
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public void create(@FormPostParam CreateModelDTO createModelDTO, HttpServletRequest request, HttpServletResponse response) {
        try {
            ActModelVO model = actRepositoryService.createModel(createModelDTO);
            response.sendRedirect(request.getContextPath() + "/act/process-editor/modeler.jsp?modelId=" + model.getActModelId());
        } catch (Exception e) {
            log.error("创建模型失败：", e);
        }
    }

    /**
     * 查询模型图片
     */
    @RequestMapping(value = "showModelPicture")
    public void showModelPicture(HttpServletResponse response, String modelId) throws IOException {
        ActModelResourceDTO modelBpmnPng = actRepositoryService.getModelBpmnPng(modelId);
        OutputStream out = response.getOutputStream();
        IOUtils.write(modelBpmnPng.getContentByte(), out);
    }

    /**
     * 根据Model部署流程
     */
    @RequestMapping(value = "deploy/{modelId}")
    public String deploy(@PathVariable("modelId") String modelId, RedirectAttributes redirectAttributes) {
        actRepositoryService.modelDeploy(modelId);
        return "redirect:/workflow/model/list";
    }

    /**
     * 导出model定义 bar
     *
     * @param modelId 模型ID
     */
    @RequestMapping(value = "export")
    public void export(@RequestParam("modelId") String modelId, HttpServletResponse response) {
        try {
            ActModelResourceDTO modelBpmnPng = actRepositoryService.getModelBpmnPng(modelId);
            ActModelResourceDTO modelBpmnXML = actRepositoryService.getModelBpmnXML(modelId);
            File tempFile = File.createTempFile(modelBpmnPng.getName(), ".bar");
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            ZipOutputStream zipOut = new ZipOutputStream(fileOutputStream);
            zipOut.putNextEntry(new ZipEntry(modelBpmnPng.getName() + modelBpmnPng.getSuffix()));
            IOUtils.write(modelBpmnPng.getContentByte(), zipOut);
            zipOut.putNextEntry(new ZipEntry(modelBpmnXML.getName() + modelBpmnXML.getSuffix()));
            IOUtils.write(modelBpmnXML.getContentByte(), zipOut);
            zipOut.close(); // 关闭输出流
            response.setHeader("Content-Disposition", "attachment; filename=" + modelBpmnPng.getName() + ".bar");
            IOUtils.copy(new FileInputStream(tempFile), response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            log.error("导出model定义bar文件失败：modelId={}", modelId, e);
        }
    }

    @RequestMapping(value = "delete/{modelId}")
    public String delete(@PathVariable("modelId") String modelId) {
        actRepositoryService.deleteModel(modelId);
        return "redirect:/workflow/model/list";
    }

}
