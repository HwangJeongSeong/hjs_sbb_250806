package com.mysite.hjs_sbb_250806;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("hello")
    @ResponseBody
    public String showHello() {
        return "Hello World";
    }
}
