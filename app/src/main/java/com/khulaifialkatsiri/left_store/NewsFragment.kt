package com.khulaifialkatsiri.left_store

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.item_news.*




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val list = ArrayList<BeritaResponse>()
    private lateinit var recyclerView: RecyclerView
    //private var view: View? = null
    private lateinit var newArrayList: ArrayList<BeritaResponse>
    //private var adapter: RecyclerView.Adapter<BeritaAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news, container, false)
        //return view
        //val view = inflater.inflate(R.layout.fragment_news, container, false)

        // Add the following lines to create RecyclerView

        // Add the following lines to create RecyclerView
//        recyclerView = view.findViewById<RecyclerView>(R.id.rvBerita)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.setLayoutManager(LinearLayoutManager(view.context))


        //return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
//        val rv = view.findViewById(R.id.rvBerita) as RecyclerView
//        rv.apply {
//            layoutManager = LinearLayoutManager(context)
//            //adapter = BeritaAdapter()
//            setHasFixedSize(true)
//        }
        recyclerView = view.findViewById(R.id.rvBerita)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(getActivity())
//
        RetrofitClient.instance.getBerita().enqueue(object: Callback<ArrayList<BeritaResponse>> {
            override fun onResponse(
                call: Call<ArrayList<BeritaResponse>>,
                response: Response<ArrayList<BeritaResponse>>
            ) {
                val responseCode = response.code().toString()
                //tvResponseCode.text = responseCode
                response.body()?.let { list.addAll(it)}
                val adapter = BeritaAdapter(list)
                rvBerita.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<BeritaResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}