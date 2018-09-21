package com.hc.lease.workflow.act.rest.editor.model;

import com.hc.lease.common.core.annotation.UrlParam;
import com.hc.lease.workflow.vo.ActModelSaveDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ModelSaveRestResourceController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ActModelSaveRestResource actModelSaveRestResource;

    @RequestMapping(value = "/act/service/model/{modelId}/save", method = RequestMethod.POST)
    public void saveModel(@PathVariable String modelId, @UrlParam ActModelSaveDTO actModelSaveDTO, HttpServletRequest httpRequest) {
        logger.info("==========actModelSaveDTO==----=======" + actModelSaveDTO.toString());
        actModelSaveDTO.setModelId(modelId);
        actModelSaveRestResource.saveModel(actModelSaveDTO);
    }
}
