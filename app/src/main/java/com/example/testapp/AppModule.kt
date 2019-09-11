package com.example.testapp

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule{

    @Provides
    fun providesContext(application: TestApplication): Context {
        return application.applicationContext
    }
}