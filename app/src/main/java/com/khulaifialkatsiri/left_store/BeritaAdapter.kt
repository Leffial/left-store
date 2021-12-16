package com.khulaifialkatsiri.left_store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*

class BeritaAdapter (private val list: ArrayList<BeritaResponse>): RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>(){
    inner class BeritaViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind(beritaResponse: BeritaResponse){
            with(itemView){
                val text = "${beritaResponse.title}\n" +
                        "${beritaResponse.deskripsi}\n" +
                        "${beritaResponse.tanggal}"
                val new = "${beritaResponse.penulis}"
                tv_new.text = new
                tvText.text = text

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_news, parent, false)
        return BeritaViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.bind(list[position])
    }
}