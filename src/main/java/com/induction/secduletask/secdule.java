package com.induction.secduletask;


import com.induction.Baranidharan.StudentRepository;
import com.induction.Baranidharan.testdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class secdule{

    @Autowired
    private StudentRepository ss;
    private  testdb s;


    @Component
    public class Scheduler {
        @Scheduled(fixedDelay = 10000)
        public void run() {
            System.out.print("Current time is :: " + Calendar.getInstance().getTime());
        }
    }
}



