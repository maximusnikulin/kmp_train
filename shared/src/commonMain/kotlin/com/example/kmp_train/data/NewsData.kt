package com.example.kmp_train

data class Source(
    val id: String,
    val name: String,
)

data class NewsItem(
    val source: Source? = null,
    val author: String,
    val title: String,
    val description: String,
    val url: String? = null,
    val publishedAt: String? = null,
    val content: String,
    val urlToImage: String? = null
)

data class NewsItemsList(
    val totalResults: Int,
    val articles: List<NewsItem>
)