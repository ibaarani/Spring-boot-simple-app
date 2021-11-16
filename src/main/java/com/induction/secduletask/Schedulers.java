package com.induction.secduletask;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Schedulers {
    @Autowired


    @Scheduled(cron = "*/10 * * * * *")
    public void run() {






                //datasave

                //r.setId();
                //r.setTitle();
                //r.setUserid();
                //r.setCompleted();
                //studentRepository.save(r);

    }

}
