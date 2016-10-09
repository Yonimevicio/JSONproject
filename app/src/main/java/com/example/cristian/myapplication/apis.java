package com.example.cristian.myapplication;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Cristian on 08/10/2016.
 */

public interface apis {
    @FormUrlEncoded
    @POST("/mamaAway/consultas.php")
    Call<ServerResponseJSON> result(@Field("JSON_ENVIAR") JSONObject JSON_ENVIAR);
}
