package com.senai.carteirinhadigital.app

import android.app.Application
import com.senai.carteirinhadigital.app.di.AppContainer
import com.senai.carteirinhadigital.app.di.DefaultAppContainer
import kotlin.getValue

class CarteirinhaApplication : Application() {
    val container: AppContainer by lazy {
        DefaultAppContainer()
    }
}