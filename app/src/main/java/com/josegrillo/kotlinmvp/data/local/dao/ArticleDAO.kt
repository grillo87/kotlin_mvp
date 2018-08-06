package com.josegrillo.kotlinmvp.data.local.dao

import android.arch.persistence.room.*
import com.josegrillo.kotlinmvp.domain.model.database.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<Article>)

    @Query("SELECT * FROM articles")
    fun loadArticles(): List<Article>

    @Query("DELETE FROM articles")
    fun deleteArticles()

}