package com.example.testapp.ui.screens

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import com.example.testapp.data.RateRepository
import com.example.testapp.uimodels.Rate
import com.example.testapp.utility.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(var rateRepository: RateRepository): ViewModel() {

    val isLoading = ObservableField<Boolean>(false)

    var rates = MutableLiveData<Rate.Rates>()

    private val compositeDisposable = CompositeDisposable()



    fun loadRates(){
        isLoading.set(true)

        compositeDisposable += rateRepository
            .getRates()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :
                DisposableObserver<Rate>() {

                override fun onComplete() {
                    isLoading.set(false)
                }

                override fun onNext(data: Rate) {
                    Log.d("aaa", data.rates.toString())
                    rates.value = data.rates
                }

                override fun onError(e: Throwable) {
                }

            })
    }

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }

}