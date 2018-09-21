package com.hc.lease.workflow.service.api;


import com.hc.lease.workflow.vo.ActDeploymentVO;
import com.hc.lease.workflow.vo.ActModelNodeInfoVo;
import com.hc.lease.workflow.vo.ActModelPageQuery;
import com.hc.lease.workflow.vo.ActModelResourceDTO;
import com.hc.lease.workflow.vo.ActModelVO;
import com.hc.lease.workflow.vo.CreateModelDTO;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;

/**
 * Created by LJ on 2018/3/22
 */
public interface ActRepositoryService {

    List<ActModelVO> findAllModels();

    PageInfo<ActModelVO> pageFindModels(ActModelPageQuery actModelPageQuery);

    ActModelVO getModel(String modelId);

    byte[] getModelEditorSource(String modelId);

    void addModelEditorSource(String modelId, byte[] bytes);

    ActModelVO createModel(CreateModelDTO createModelVo) throws Exception;

    void addModelEditorSourceExtra(String modelId, byte[] bytes);

    void deleteModel(String modelId);

    ActModelResourceDTO getModelBpmnPng(String modelId) throws IOException;

    ActModelResourceDTO getModelBpmnXML(String modelId) throws IOException;

    List<ActModelNodeInfoVo> getActModelNodes(String processDefinitionId);

    /**
     * 模型部署流程
     *
     * @param modelId 模型ID
     */
    ActDeploymentVO modelDeploy(String modelId);

}
