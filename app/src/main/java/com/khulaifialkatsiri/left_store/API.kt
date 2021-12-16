package com.khulaifialkatsiri.left_store

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("berita")
    fun getBerita(): Call<ArrayList<BeritaResponse>>
}