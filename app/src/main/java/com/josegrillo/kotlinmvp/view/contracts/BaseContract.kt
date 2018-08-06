package com.josegrillo.kotlinmvp.view.contracts

class BaseContract {

    interface View {

    }

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

}