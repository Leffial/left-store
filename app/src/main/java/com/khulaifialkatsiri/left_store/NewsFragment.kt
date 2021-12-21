package com.khulaifialkatsiri.left_store

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsFragment : Fragment() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: BeritaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView = view.findViewById(R.id.rvBerita)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        getApiList(retrofit)
    }

    private fun getApiList(retrofit: Retrofit) {
        val apiService = retrofit.create<API>(API::class.java)
        val apiList = apiService.getBerita()
        apiList.enqueue(object : Callback<ArrayList<BeritaResponse>> {
            override fun onResponse(
                call: Call<ArrayList<BeritaResponse>>,
                response: Response<ArrayList<BeritaResponse>>
            ) {
                if (response.isSuccessful) {
                    mAdapter = BeritaAdapter(response.body())
                    val mLayoutManager = LinearLayoutManager(activity)
                    mRecyclerView.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
                    mRecyclerView.adapter = mAdapter
                    mRecyclerView.layoutManager = mLayoutManager
                } else {
                    Log.e(TAG, "onResponse: Successfull")
                }
            }
            override fun onFailure(call: Call<ArrayList<BeritaResponse>>, t: Throwable) {
                Log.e(TAG, "onFailure: Error")
            }
        })
    }

    companion object {
        const val BASE_URL = "https://localshoeapinodejs.herokuapp.com/v1/"
        private const val TAG = "NewsFragment"
    }

}