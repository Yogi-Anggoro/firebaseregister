package com.example.firebaseapk1.fitur.register

import com.example.firebaseapk1.base.BasePresenter
import com.example.firebaseapk1.base.BaseView
import com.example.firebaseapk1.model.User

interface RegisterContract {

    interface View : BaseView<Presenter> {
        fun onError(message: String)
        fun onSucces(message: String)
        fun onProcess(message: Boolean)

    }
    interface Presenter : BasePresenter{
        fun register(user: User)
    }
}