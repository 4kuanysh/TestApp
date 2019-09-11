package com.example.testapp.data

import com.example.testapp.uimodels.Rate
import io.reactivex.Observable
import javax.inject.Inject

class RateRepository @Inject constructor() {

    val remoteDataSource = RateRemoteDataSource()

    fun getRates() : Observable<Rate> {
        return remoteDataSource.getRates()
    }


}
