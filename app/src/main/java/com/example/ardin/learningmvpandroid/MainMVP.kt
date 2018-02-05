package com.example.ardin.learningmvpandroid

/**
 * Created by ardin on 02/02/18.
 */
class MainMVP {
    interface View {
        fun setNameOnText(name: String)
    }

    interface Presenter {
        fun displayFactInTextView()
        fun setNameOnText(name: String?)
    }

    interface Interactor {
        fun getFactRandomFromServer()
    }
}