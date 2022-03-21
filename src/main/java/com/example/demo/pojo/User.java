package com.example.demo.pojo;

import com.example.demo.validationgroupkind.Update;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {


    @NotNull(message = "id不能为空", groups = Update.class)
    @Min(value = 1, message = "id不能为0", groups = Update.class)
    private Integer id;
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
