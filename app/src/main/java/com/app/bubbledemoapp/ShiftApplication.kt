package com.app.bubbledemoapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin


class ShiftApplication : Application() {

    init {
        shiftApplication = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@ShiftApplication)
            androidFileProperties()
        }
        injectFeature()
    }

    companion object {
        lateinit var shiftApplication: ShiftApplication
            private set

        val applicationContext: Context
            get() {
                return shiftApplication.applicationContext
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