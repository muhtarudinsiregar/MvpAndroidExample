package com.example.ardin.learningmvpandroid

import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by ardin on 02/02/18.
 */
interface NumberGetter {
    @GET("random/year?json")
    fun getResult(): Call<NumberFact>
}
