package com.t9vg.SpringBootHelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianfusheng
 * @e-mail linuxmorebetter@gmail.com
 * @date 2019/7/26
 */
@RestController
@RequestMapping("/demo")
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello World!";
    }

}
