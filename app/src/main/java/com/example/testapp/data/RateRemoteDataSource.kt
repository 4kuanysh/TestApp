package com.example.testapp.data


import com.example.testapp.api.Service
import com.example.testapp.uimodels.Rate
import io.reactivex.Observable

class RateRemoteDataSource {

    fun getRates() : Observable<Rate> {
        val rates : Observable<Rate> = Service.rateApi.getLatest()

        return rates
    }
}
