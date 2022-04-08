package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {


    @NotNull(message = "id不能为空")
    @Pattern(regexp = "1|26", message = "id类型不对")
    private String id;
    @NotBlank(message = "用户名不能为空")
    @Size(max = 5, message = "用户名长度不能大于5")
    private String userName;
    private String passWord;
    private String contact;
    private String name;
    private String createTime;
    private List<String> dataList;
    private Integer num;

}
