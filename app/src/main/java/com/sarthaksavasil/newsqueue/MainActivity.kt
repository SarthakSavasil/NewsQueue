package com.sarthaksavasil.newsqueue

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.littlemango.stacklayoutmanager.StackLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    private var articles = mutableListOf<Articles>()

    var pageNo = 1
    var totalR = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter = NewsAdapter(this@MainActivity, articles)

        newsRecyclerView.adapter = adapter
       // newsRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


        val layoutManager = StackLayoutManager(StackLayoutManager.ScrollOrientation.RIGHT_TO_LEFT)
        layoutManager.setPagerMode(true)
        layoutManager.setPagerFlingVelocity(3000)

        layoutManager.setItemChangedListener(object : StackLayoutManager.ItemChangedListener {
            override fun onItemChanged(position: Int) {

                if(totalR > layoutManager.itemCount && layoutManager.getFirstVisibleItemPosition() >=layoutManager.itemCount-5)
                {

                    pageNo++
                    getNews()
                }
            }
        })

        newsRecyclerView.layoutManager = layoutManager
        getNews()
    }
   private fun getNews()
    {
        val news = NewsService.newsInstance.getHeadLines("in",pageNo)

        news.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("sarthak", "fsd" )
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()

                if (news != null) {
                    Log.e("sarthak", news.toString() )
                    totalR = news.totalResults
                    articles.addAll(news.articles)
                    adapter.notifyDataSetChanged()
                }
            }

        })

    }
}