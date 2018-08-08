package com.josegrillo.kotlinmvp.data.local.configuration

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.josegrillo.kotlinmvp.data.local.dao.ArticleDAO
import com.josegrillo.kotlinmvp.data.local.dao.UserDAO
import com.josegrillo.kotlinmvp.domain.model.database.Article
import com.josegrillo.kotlinmvp.domain.model.database.User

@Database(entities = [(Article::class), (User::class)], version = 5)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticleDAO

    abstract fun usersDao(): UserDAO

}