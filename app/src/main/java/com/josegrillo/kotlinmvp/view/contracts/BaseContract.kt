package com.josegrillo.kotlinmvp.view.contracts

class BaseContract {

    val LOG_TAG = this.javaClass.canonicalName

    interface View {

    }

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

}