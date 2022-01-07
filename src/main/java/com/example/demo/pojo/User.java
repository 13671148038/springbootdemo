package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String passWord;
    private String contact;
    private String name;
    private String createTime;
    private List<String> dataList;
    private Integer num;

}
