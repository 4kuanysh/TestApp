package com.example.testapp.api

import com.example.testapp.uimodels.Rate
import retrofit2.http.GET
import io.reactivex.Observable

interface Api {
    @GET("latest")
    fun getLatest(): Observable<Rate>
}