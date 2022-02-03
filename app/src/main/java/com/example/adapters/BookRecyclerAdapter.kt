package com.example.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinapp.R
import com.example.models.BooksInfo

class BookRecyclerAdapter(var bookList:List<BooksInfo>) :RecyclerView.Adapter<BookRecyclerAdapter.BookViewHolder>(){
    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item_view,parent,false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        Glide.with(context)
            .applyDefaultRequestOptions(requestOptions)
            .load(Uri.parse(bookList[position].image))
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    inner class BookViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var imageView = itemView.findViewById<ImageView>(R.id.bookImageView)
    }
}