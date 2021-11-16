package com.induction.secduletask;

import com.induction.DataModel.RetroFitTestApi;
import com.induction.Repository.TestApiInterface;
import com.induction.RetrofitClass.Retrofitcallback;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
@ResponseBody
public class Schedulers {
    //@Autowired
    private RetroFitTestApi retroFitTestApi;

    @Autowired
    private TestApiInterface testApiInterface;

    @Autowired
    public Retrofitcallback retrofitcallback;


    static  int a = 0;


    @SneakyThrows
    @Scheduled(cron = "*/10 * * * * *")

    @ResponseBody
    public void run() throws IOException {

       // System.out.println("hello");
        a++;

        Call<RetroFitTestApi> retrofitCall = retrofitcallback.getUser(a);

        Response<RetroFitTestApi> response = retrofitCall.execute();

         var d = response.body().getId();
        System.out.println (response.body().getId());
        System.out.println (response.body().getTitle());
        System.out.println (response.body().getUserid());
        System.out.println (response.body().getCompleted());






                  //datasave
//                  retroFitTestApi.setUserid(response.body().getId());
//                  retroFitTestApi.setTitle(response.body().getTitle());
//                  retroFitTestApi.setUserid(response.body().getUserid());
//                  retroFitTestApi.setCompleted(response.body().getCompleted());
//                  testApiInterface.save(retroFitTestApi);

    }

}
