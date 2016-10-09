package com.example.cristian.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button llamada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llamada = (Button)findViewById(R.id.button);


        llamada.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                try{
                    JSONObject varjson = new JSONObject();
                    varjson.put("fun","tuto");

                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.4.180.88")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
                    apis service = retrofit.create(apis.class);
                    Call<ServerResponseJSON> call = service.result(varjson);
                    call.enqueue(new Callback<ServerResponseJSON>() {
                        public void onResponse(Call<ServerResponseJSON> call, Response<ServerResponseJSON> response) {

                            Log.d("TEST JSON", response.body().getRespuesta().get(0).getIDtutorial());
                        }

                        @Override
                        public void onFailure(Call<ServerResponseJSON> call, Throwable t) {

                        }
                    });

                   // Toast.makeText(MainActivity.this,"resultado: " + service.result(varjson),Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Log.v("peta esto",e.getMessage());
                }

            }
        });

    }

}
