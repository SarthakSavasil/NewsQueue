package com.sarthaksavasil.newsqueue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getNews()
    }
   private fun getNews()
    {
        val news = NewsService.newsInstance.getHeadLines("in",1)

        news.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("sarthak", "fsd" )
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()

                if (news != null) {
                    Log.e("sarthak", news.toString() )

                    adapter = NewsAdapter(this@MainActivity, news.articles)

                    newsRecyclerView.adapter = adapter
                    newsRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

        })

    }
}