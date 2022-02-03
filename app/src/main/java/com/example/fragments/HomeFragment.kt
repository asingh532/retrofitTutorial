package com.example.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapters.BookRecyclerAdapter
import com.example.kotlinapp.R
import com.example.models.AuthorModel
import com.example.models.BooksInfo
import com.example.networkservice.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment: Fragment(R.layout.fragment_home){

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getAuthorDetails()
    }

    private fun initRecyclerView() {
        recyclerView = activity?.findViewById(R.id.bookList) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)

    }

    private fun getAuthorDetails() {
        val call =ApiService.apiProvider.getAuthorDetail("2298")
        call.enqueue(object:Callback<AuthorModel>{
            override fun onResponse(call: Call<AuthorModel>, response: Response<AuthorModel>) {
                val result = response.body()
                if(result != null){

                    adapter = BookRecyclerAdapter(result.books)
                    recyclerView.adapter = adapter


                }
            }

            override fun onFailure(call: Call<AuthorModel>, t: Throwable) {
                Log.d("HomeScreen", "onFailure: ",t)
            }
        })
    }
}