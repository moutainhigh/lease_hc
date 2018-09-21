package com.hc.lease.workflow.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class ActIndexController {

    @RequestMapping(value = "/workflow/index")
    public String index() {
        return "/index";
    }

}
