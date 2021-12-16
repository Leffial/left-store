package com.khulaifialkatsiri.left_store


import com.google.gson.annotations.SerializedName

data class BeritaResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("deskripsi")
    val deskripsi: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("penulis")
    val penulis: String,
    @SerializedName("tanggal")
    val tanggal: String,
    @SerializedName("sumber")
    val sumber: String
)