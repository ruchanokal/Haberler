package com.ruchanokal.haberler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruchanokal.haberler.APIinterface
import com.ruchanokal.haberler.adapter.NewsAdapter
import com.ruchanokal.haberler.databinding.FragmentAnaBinding
import com.ruchanokal.haberler.model.Example
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class AnaFragment : Fragment() {

    private var binding: FragmentAnaBinding? = null

    private val BASE_URL = "http://app.haberler.com/services/haberlercom/2.11/service.asmx/"
    private var example1 : Example? = null
    private var compositeDisposable : CompositeDisposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnaBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        compositeDisposable = CompositeDisposable()

        //http://app.haberler.com/services/haberlercom/2.11/service.asmx/haberler?category=manset&count=35&offset=0&deviceType=1&userId=61ed99e0c09a8664

        loadData()

    }

    private fun loadData() {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(APIinterface::class.java)

        compositeDisposable?.add(retrofit.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::gettingNews))

    }

    private fun gettingNews(example: Example ){


            example1 = example

            example1?.let {

            val liste = example.news

            binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
            val newsAdapter = context?.let { it1 -> NewsAdapter(liste, it1,example1!!) }
            binding?.recyclerView?.adapter = newsAdapter

            binding?.progressBarAna?.visibility = View.GONE

            }


    }


}