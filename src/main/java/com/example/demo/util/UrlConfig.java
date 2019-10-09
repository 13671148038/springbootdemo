package com.example.demo.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhushaopeng
 * @Date 2019/10/9
 **/
@ConfigurationProperties(prefix = "my")
@Component
public class UrlConfig {

    private String zsp;

    private String lisi;

    private List<String> servers = new ArrayList<String>();

    public String getZsp() {
        return zsp;
    }

    public void setZsp(String zsp) {
        this.zsp = zsp;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public String getLisi() {
        return lisi;
    }

    public void setLisi(String lisi) {
        this.lisi = lisi;
    }
}
