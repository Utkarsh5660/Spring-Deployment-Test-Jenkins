package com.fridaydeploys.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myController")
public class myController {

    @PostMapping("/testMethod")
    public String testMethod() {
        return "success";
    }
}
