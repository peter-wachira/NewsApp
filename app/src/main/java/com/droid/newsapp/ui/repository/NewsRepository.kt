package com.droid.newsapp.ui.repository

import com.droid.newsapp.ui.api.RetrofitInstance
import com.droid.newsapp.ui.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
){
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery : String, pageNumber: Int)= RetrofitInstance.api.searchForNews(searchQuery,pageNumber)
}