package com.droid.newsapp.ui.models


import com.droid.newsapp.ui.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)