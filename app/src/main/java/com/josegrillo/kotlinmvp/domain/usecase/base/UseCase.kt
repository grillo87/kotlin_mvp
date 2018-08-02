package com.josegrillo.kotlinmvp.domain.usecase.base

import android.icu.lang.UCharacter.GraphemeClusterBreak.T


abstract class UseCase<T> {

    abstract fun execute(): T

}