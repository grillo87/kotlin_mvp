package com.josegrillo.kotlinmvp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.josegrillo.kotlinmvp.R
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.view.contracts.ListContract
import com.josegrillo.kotlinmvp.view.viewholder.ArticleViewHolder

class ArticlesRecyclerViewAdapter(val articles: ArrayList<ArticleView>, val onTouchArticle: ListContract.View) : RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder = ArticleViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.elements_list_viewholder, parent, false), onTouchArticle)

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.let {
            it.bind(articles.get(position))
        }
    }
}