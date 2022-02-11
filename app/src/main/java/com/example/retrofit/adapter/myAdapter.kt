package com.example.retrofit.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*

class myAdapter: RecyclerView.Adapter<myAdapter.myViewHolder>(){
    private var myList = emptyList<Post>()

    inner class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.itemView.apply {
            userId_txt.text = myList[position].userId.toString()
            id_txt.text = myList[position].id.toString()
            title_txt.text = myList[position].title
            body_txt.text = myList[position].body

        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }



    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }

}