package com.example.ardin.learningmvpandroid

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by ardin on 05/02/18.
 */
class App : Application() {
    override  fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}