package com.example.testapp.ui.screens

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.example.testapp.R

import com.example.testapp.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {



    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        Log.d("aaabbb", viewModel.rates.value.toString())
        val rate = viewModel.rates.value

        binding.rates = rate
        binding.viewModel = viewModel
        binding.executePendingBindings()

  }


}
