package com.my2.service;


import com.nec.process.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessResolver {

    @Autowired
    private Process process;

    public void runProcess(){
//        Process p = new Process();
        try {
            process.sleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
