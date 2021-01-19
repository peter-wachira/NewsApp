package com.droid.newsapp.ui.ui

import androidx.lifecycle.ViewModel
import com.droid.newsapp.ui.repository.NewsRepository

class NewsViewModel(
val newsRepository : NewsRepository
) : ViewModel() {

}