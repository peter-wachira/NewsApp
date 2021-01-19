package com.droid.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.droid.newsapp.R
import com.droid.newsapp.ui.ui.NewsActivity
import com.droid.newsapp.ui.ui.NewsViewModel

class SearchNewsFragment  : Fragment(R.layout.fragment_search_news){

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
    }

}