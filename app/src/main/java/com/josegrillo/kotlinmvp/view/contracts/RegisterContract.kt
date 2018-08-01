package com.josegrillo.kotlinmvp.view.contracts

class RegisterContract {

    interface View : BaseContract.View {
    }

    interface Presenter : BaseContract.Presenter<View> {
    }

}