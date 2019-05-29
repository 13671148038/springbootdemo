package com.example.demo.controllerRest;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MyPC on 2018/7/13.
 */
@RestController
public class HelloWordConterller {

    @Autowired
    private UserService userService;

    @RequestMapping("helloWord")
    public String HelloWord(){
        return "HelloWord啊对二砂";
    }

    @RequestMapping("getUser")
    public Object getuUser(HttpServletRequest request) {
        List<User> list = userService.getPageDate();
        return list;
    }

    @RequestMapping("fileUpload")
    public String fileUpload( HttpServletRequest request,@RequestParam("file") MultipartFile file,String name) throws IOException {
        String realPath = request.getServletContext().getRealPath("/sadcsdc.jpg");
        file.transferTo(new File(realPath));
        System.out.println("successsadcsdcsdc"+name);
        return "successsa啥都吃三大从dcsdcsdc"+name;
    }

    @RequestMapping("ajaxTest")
    public String ajaxTest(){
        String userNmae = userService.getUserName();
        return userNmae;
    }
}
