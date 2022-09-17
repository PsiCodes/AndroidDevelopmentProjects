package com.rigel.NewzTEST

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adpter(private val dataSet: ArrayList<ModalNews?>, private val c: Context?) :
    RecyclerView.Adapter<adpter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val NewsHeading:TextView
      val Content:TextView
      val Author :TextView
      val photoofnews:ImageView
        init {
          NewsHeading=view.findViewById(R.id.newsheading)
            Content=view.findViewById(R.id.contentofnews)
            Author=view.findViewById(R.id.authorname)
            photoofnews=view.findViewById(R.id.newsImage)


        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.singlenews, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.Content.text=dataSet.get(position)?.description
        viewHolder.Content.setOnClickListener{
            val i:Intent=Intent(c,web::class.java)
            val a:String?=dataSet.get(position)?.url
            i.putExtra("url",a)
            c?.startActivity(i)
        }
        viewHolder.NewsHeading.text=dataSet.get(position)?.title
        viewHolder.Author.text=dataSet.get(position)?.author
        Picasso.get().load(dataSet.get(position)?.urlToImage).into(viewHolder.photoofnews)

    }


    override fun getItemCount() = dataSet.size

}
