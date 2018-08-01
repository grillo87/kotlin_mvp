package com.josegrillo.kotlinmvp.view.contracts

class ListContract {

    interface View : BaseContract.View {
    }

    interface Presenter : BaseContract.Presenter<View> {
    }

}