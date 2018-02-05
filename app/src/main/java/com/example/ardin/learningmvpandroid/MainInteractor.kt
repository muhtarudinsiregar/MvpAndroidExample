package com.example.ardin.learningmvpandroid

import android.util.Log
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




/**
 * Created by ardin on 02/02/18.
 */
class MainInteractor(val presenter: MainMVP.Presenter) : MainMVP.Interactor {
    override fun getFactRandomFromServer() {
        //http://numbersapi.com/random/year?json
        val gson = GsonBuilder()
                .create()

        val builder = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor())
        val client = builder.build()


        val retrofit = Retrofit.Builder()
                .baseUrl("http://numbersapi.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()

        val numberGetter = retrofit.create(NumberGetter::class.java)
        val call = numberGetter.getResult()

        call.enqueue(object : Callback<NumberFact> {
            override fun onFailure(call: Call<NumberFact>?, t: Throwable?) {
                presenter.setNameOnText("Error")
                Log.d("LOG", t.toString())
            }

            override fun onResponse(call: Call<NumberFact>?, response: Response<NumberFact>?) {
                Log.d("LOG", response.toString())
                val number = response?.body()
                val fact = number?.text
                presenter.setNameOnText(fact)
            }

        })

    }
}