package com.josegrillo.kotlinmvp.domain.model.api.response

data class Article(var idServer: Int? = null,
                   var title: String? = null,
                   var area: String? = null,
                   var imageUrl: String? = null,
                   var content: String? = null)