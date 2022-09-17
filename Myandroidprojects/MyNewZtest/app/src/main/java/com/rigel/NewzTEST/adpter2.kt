package com.rigel.NewzTEST

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso


class adpter2(private val dataSet: ArrayList<ModalNews>) :
    RecyclerView.Adapter<adpter2.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
          val topnewsImg:ImageView
          val topNewsContent:TextView

        init {
        topnewsImg=view.findViewById(R.id.topnewsimg)
            topNewsContent=view.findViewById(R.id.topnewsContent)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.topnewz, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.topNewsContent.text= dataSet[position].title
        Picasso.get().load(dataSet[position].url).into(viewHolder.topnewsImg)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size


}
