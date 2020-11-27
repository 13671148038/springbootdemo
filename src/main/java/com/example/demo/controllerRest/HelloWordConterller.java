package com.example.demo.controllerRest;

import com.example.demo.aspect.controller.ControllerLog;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MyPC on 2018/7/13.
 */
@Slf4j
@RestController
public class HelloWordConterller {

    @Autowired
    private UserService userService;

    @RequestMapping("helloWord")
    public String HelloWord() {
        return "HelloWord啊对二砂";
    }

    @RequestMapping("getUser")
    @ControllerLog
    public Object getuUser(HttpServletRequest request) {
        log.info("上档次上档次是单词都是");
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "ddd");
        Object list = userService.getPageDate(map);
        return list;
    }

    @RequestMapping("fileUpload")
    public String fileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, String name) throws IOException {
        String realPath = request.getServletContext().getRealPath("/sadcsdc.jpg");
        file.transferTo(new File(realPath));
        System.out.println("successsadcsdcsdc" + name);
        return "successsa啥都吃三大从dcsdcsdc" + name;
    }

    @GetMapping("ajaxTest")
    public String ajaxTest(String name) {
        String userNmae = userService.getUserName(name);
        return userNmae;
    }

    @GetMapping("b")
    public Boolean b(String name) {
        String aa = "aaa";
        log.info("|||||:{}", aa == name);
        return aa == name;
    }

    @RequestMapping("aa")
    public String aa() {
        userService.update1();
        return "aa";
    }

    @RequestMapping("bb")
    public String bb() {
        userService.update2();
        return "bb";
    }
}
