package com.example.demo.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by MyPC on 2018/7/13.
 */
@Service
//@EnableScheduling
public class TaskService {

    //@Scheduled(fixedRate = 5000)
    public void Task(){
        System.out.println("sddddddddddddddddddddddddddddd");

    }
}
