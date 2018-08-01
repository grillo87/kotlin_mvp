package com.josegrillo.kotlinmvp.view.contracts

class LoginContract {

    interface View : BaseContract.View {
    }

    interface Presenter : BaseContract.Presenter<View> {
    }

}