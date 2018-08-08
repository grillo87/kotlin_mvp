package com.josegrillo.kotlinmvp.view.contracts

class SplashContract {

    interface View : BaseContract.View {
        fun defineAnimations()
        fun startAnimations()
        fun startSplashTimer()
        fun navigateToLogin()
        fun navigateToList()
    }

    interface Presenter : BaseContract.Presenter<View> {

        fun initializeViewElements()
        fun navigateNextView(isEmpty: Boolean)
        fun checkUserSession()

    }

}