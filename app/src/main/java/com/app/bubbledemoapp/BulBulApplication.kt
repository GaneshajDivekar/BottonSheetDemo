package com.app.bubbledemoapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin


class BulBulApplication : Application() {

    init {
        bulBulApplication = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@BulBulApplication)
            androidFileProperties()
        }
        injectFeature()
    }

    companion object {
        lateinit var bulBulApplication: BulBulApplication
            private set

        val applicationContext: Context
            get() {
                return bulBulApplication.applicationContext
            }
    }

    fun hasNetwork(): Boolean {
        return isNetworkAvailable()
    }

    private fun isNetworkAvailable(): Boolean {
        var isConnected = false
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}