package com.ruchanokal.haberler

import com.ruchanokal.haberler.model.Example
import com.ruchanokal.haberler.model.News
import io.reactivex.Observable
import retrofit2.http.GET

interface APIinterface {

    @GET("haberler?category=manset&count=35&offset=0&deviceType=1&userId=61ed99e0c09a8664")
    fun getData() : Observable<Example>

}