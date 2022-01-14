package com.example.demo.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Length(max = 6, message = "用户名长度不能大于6")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String passWord;
    private String contact;
    private String name;
    private String createTime;
    private List<String> dataList;
    @Min(value = 1, message = "num不能为0")
    private Integer num;

}
