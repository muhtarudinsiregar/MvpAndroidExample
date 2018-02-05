package com.example.ardin.learningmvpandroid

/**
 * Created by ardin on 02/02/18.
 */
class MainPresenter(var view: MainMVP.View) : MainMVP.Presenter {
    val interactor = MainInteractor(this)
    override fun setNameOnText(name: String) {
        view.setNameOnText(name)
    }


    override fun displayFactInTextView() {
        interactor.getFactRandomFromServer()
    }

}