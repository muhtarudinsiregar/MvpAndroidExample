package com.example.ardin.learningmvpandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainMVP.View {
    override fun setNameOnText(name: String) {
        textView.text = name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainPresenter by lazy { MainPresenter(this) }

        button.setOnClickListener {
            this@MainActivity.runOnUiThread(java.lang.Runnable {
                presenter.displayFactInTextView()
            })

        }

    }
}
