
package com.hc.lease.workflow.act.rest.diagram.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.hc.lease.workflow.act.rest.servlet.ActRestSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProcessInstanceHighlightsResourceController extends ActRestSupport {

    @Resource
    private ActProcessInstanceHighlightsResource actProcessInstanceHighlightsResource;

    @ResponseBody
    @RequestMapping(value = "/act/service/process-instance/{processInstanceId}/highlights", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public JsonNode getHighlighted(@PathVariable String processInstanceId) {
        return super.readTree(actProcessInstanceHighlightsResource.getHighlighted(processInstanceId));
    }

}
