package com.example.nativeproject

import android.icu.text.CaseMap
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NewsViewModel: ViewModel() {
    var news = mutableStateListOf<NewsItem>()

    fun addnews( title: String, summary: String, contents: String){
        val newNews = NewsItem(title, summary, contents)
        news.add(newNews)
    }
}