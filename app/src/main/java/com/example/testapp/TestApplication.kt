package com.example.testapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TestApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}