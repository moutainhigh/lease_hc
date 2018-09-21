package com.hc.lease.workflow.act.rest.editor.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.hc.lease.workflow.act.rest.servlet.ActRestSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tijs Rademakers
 */
@RestController
public class StencilsetRestResourceController extends ActRestSupport {

    @Resource
    private ActStencilsetRestResource actStencilsetRestResource;

    @ResponseBody
    @RequestMapping(value = "/act/service/editor/stencilset", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public JsonNode getStencilset() {
        return super.readTree(actStencilsetRestResource.getStencilset());
    }
}
