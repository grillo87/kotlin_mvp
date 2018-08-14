package com.josegrillo.kotlinmvp.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.josegrillo.kotlinmvp.domain.model.ArticleView
import com.josegrillo.kotlinmvp.utils.GlideApp
import com.josegrillo.kotlinmvp.view.contracts.ListContract
import kotlinx.android.synthetic.main.elements_list_viewholder.view.*

class ArticleViewHolder(val view: View, val onTouchArticle: ListContract.View) : RecyclerView.ViewHolder(view) {

    fun bind(articleView: ArticleView) {

        view.elementListTitleTextview.text = articleView.title
        view.elementListAreaTextview.text = articleView.area
        view.elementListParentContainer.setOnClickListener {
            onTouchArticle.onTouchArticle(it, adapterPosition)
        }

        GlideApp.with(view).load(articleView.imageUrl)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(view.elementListImageview)

    }

}