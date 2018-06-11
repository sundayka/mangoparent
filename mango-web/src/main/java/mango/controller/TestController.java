package mango.controller;

import mango.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test/query")
    @ResponseBody
    public String queryNow(){
        return testService.queryNow();
    }
}
