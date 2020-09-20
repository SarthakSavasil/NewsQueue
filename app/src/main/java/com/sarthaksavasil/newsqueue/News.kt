package com.sarthaksavasil.newsqueue

data class News (

    val status : String,
    val totalResults : Int,
    val articles : List<Articles>
)