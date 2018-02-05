package com.example.ardin.learningmvpandroid

import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

/**
 * Created by ardin on 02/02/18.
 */
class MainInteractor(val presenter: MainMVP.Presenter) : MainMVP.Interactor {
    fun getFactRandomFromServer() {
        val URL = "http://numbersapi.com/random/year?json"
        val client = OkHttpClient()

        val request = Request.Builder().url(URL).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                presenter.setNameOnText("Error")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()

                val numberFact = gson.fromJson(body, NumberFact::class.java)
                presenter.setNameOnText(numberFact.text)
            }

        })
    }
}