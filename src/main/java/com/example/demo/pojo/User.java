package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {

    private String userName;
    private String passWord;
    private String contact;
    private String name;
    private String createTime;
    private List<String> dataList;
    private Integer num;

}
