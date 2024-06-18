package com.example.learnretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.learnretrofit.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(PostService::class.java)

        val responseLiveData : LiveData<Response<Posts>> = liveData {
            val resposnse = retrofitService.getPosts()
            emit(resposnse)
        }

        responseLiveData.observe(this, Observer {
            val postList = it.body()?.listIterator()
            if(postList != null){
                while (postList.hasNext()){
                    val postItem = postList.next()
                    val postBody = "Body : ${postItem.body} \n"
                    binding.tvText.append(postBody)
                }
            }
        })
    }
}