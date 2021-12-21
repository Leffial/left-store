package com.khulaifialkatsiri.left_store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeritaAdapter(private val mNameList: List<BeritaResponse>?) : RecyclerView.Adapter<BeritaAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var mBeritaImage: ImageView = itemView.findViewById(R.id.ivBeritaImage)
        var mBeritaName: TextView = itemView.findViewById(R.id.tvText)
        var mBeritaDescription: TextView = itemView.findViewById(R.id.tv_new)
        var mBeritaTanggal: TextView = itemView.findViewById(R.id.tv_tanggal)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mBeritaName.text = mNameList?.get(position)?.title ?: ""
        holder.mBeritaDescription.text = mNameList?.get(position)?.deskripsi ?: ""
        holder.mBeritaTanggal.text = mNameList?.get(position)?.tanggal ?: ""
    }

    override fun getItemCount(): Int {
        return mNameList?.size ?: 0
    }
}