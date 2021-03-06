package com.droid.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.droid.newsapp.R
import com.droid.newsapp.ui.models.Article
import kotlinx.android.synthetic.main.item_article_preview.view.*

class NewsAdapter(

): RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){

    inner class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    private  val differCallback = object: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return  oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_article_preview,
                        parent
                )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvSource.text = article.source.name
            tvTitle.text = article.description
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt

            setOnItemClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    private  var onItemClickListener:((Article)->Unit)?= null

    fun setOnItemClickListener(listener: (Article)-> Unit){
        onItemClickListener = listener
    }


}