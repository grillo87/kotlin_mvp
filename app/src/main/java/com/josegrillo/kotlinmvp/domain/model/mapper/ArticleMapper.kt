package com.josegrillo.kotlinmvp.domain.model.mapper

import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.domain.model.api.response.Article
import com.josegrillo.kotlinmvp.domain.model.api.response.User

class ArticleMapper {

    companion object {

        fun articlesApiToViewModel(articles: List<Article>): ArrayList<ArticleView> {

            val articlesResponse = ArrayList<ArticleView>()
            articles.forEach { articlesResponse.add(articleApiToViewModel(it)) }

            return articlesResponse

        }


        fun articleApiToViewModel(article: Article): ArticleView {

            val articleResponse = ArticleView(article.title, article.area, article.imageUrl, article.content)
            return articleResponse

        }


        fun articleApiToDatabase(article: Article): com.josegrillo.kotlinmvp.domain.model.database.Article {

            val articleResponse = com.josegrillo.kotlinmvp.domain.model.database.Article(null, article.title, article.area, article.imageUrl, article.content)
            return articleResponse

        }


        fun articleDatabaseToViewModel(article: com.josegrillo.kotlinmvp.domain.model.database.Article): ArticleView {

            val articleView = ArticleView(article.title, article.area, article.imageUrl, article.content)
            return articleView

        }


    }

}