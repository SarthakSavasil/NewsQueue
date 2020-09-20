package com.sarthaksavasil.newsqueue

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY

const val URL = "https://newsapi.org/v2/"
const val API_KEY = "2503dc9710c348c9b5386acfa83ab1a8"
interface NewsInterface {

    @GET("top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country : String,@Query("page")  page : Int) : Call<News>

    //http://newsapi.org/v2/top-headlines?apiKey=2503dc9710c348c9b5386acfa83ab1a8&country=in&page=1
}

 object NewsService{
    val newsInstance : NewsInterface
     init {
         val retrofit = Retrofit.Builder()
             .baseUrl(URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
         newsInstance = retrofit.create(NewsInterface :: class.java)



     }
 }