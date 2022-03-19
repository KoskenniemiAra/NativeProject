package com.example.nativeproject

import android.icu.text.CaseMap
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NewsViewModel: ViewModel() {
    var news = mutableStateListOf<NewsItem>()

    init {
        Firebase.firestore
            .collection("News")
            .get()
            .addOnSuccessListener {
                it.forEach { item ->
                    var newNewsItem = NewsItem(item.get("title").toString(),
                                                item.get("summary").toString(),
                                                item.get("contents").toString())
                    news.add(newNewsItem)
                }
            }
    }

    fun addnews( title: String, summary: String, contents: String){
        val newNews = NewsItem(title, summary, contents)
        val newsToStore = hashMapOf(
            "title" to title,
            "summary" to summary,
            "contents" to contents
        )
        Firebase.firestore
            .collection("News")
            .add(newsToStore)
        news.add(newNews)
    }
}