package com.induction.secduletask;


import com.induction.Repository.StudentRepository;
import com.induction.Baranidharan.TestDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;


public class Secduler {

    @Autowired
    private StudentRepository ss;
    private TestDb s;


    @Component
    public class Scheduler {
        @Scheduled(fixedDelay = 10000)
        public void run() {
            System.out.print("Current time is :: " + Calendar.getInstance().getTime());
        }
    }
}



