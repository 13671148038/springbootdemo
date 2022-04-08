package com.example.demo.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/", configuration = FeignConfiguration.class, name = "demo")
public interface DemoFeign {


    @GetMapping("helloWord/{formId}")
    String get(@PathVariable("formId") String formId);

}
