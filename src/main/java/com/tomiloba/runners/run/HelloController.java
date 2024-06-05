package com.tomiloba.runners.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project runners
 * @Author <h3 style="color: green; padding: 0px;"> Tomiloba</h3>
 * @since 6/4/2024
 */

@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("")
    public String HelloController(){
        return "Hello";
    }
}
