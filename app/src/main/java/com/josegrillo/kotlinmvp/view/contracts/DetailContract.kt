package com.josegrillo.kotlinmvp.view.contracts

class DetailContract {

    interface View : BaseContract.View {
    }

    interface Presenter : BaseContract.Presenter<View> {
    }

}