package com.josegrillo.kotlinmvp.view.contracts

class SplashContract {

    interface View: BaseContract.View {
        fun defineAnimations()
        fun startAnimations()
        fun startSplashTimer()
    }

    interface Presenter: BaseContract.Presenter<View> {

        fun initializeViewElements()

    }

}