package ru.pscher.android.iprobonustestapp

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import ru.pscher.android.iprobonuspresentation.IProBonusPresentation
import ru.pscher.android.iprobonuspresentation.IProBonusPresentationConfig
import timber.log.Timber

class IProBonusApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        //Инициализируем модуль/библиотеку IProBonusPresentation
        IProBonusPresentation.init(this, IProBonusPresentationConfig(
            BuildConfig.API_BASE_URL,
            BuildConfig.API_ACCESS_KEY,
            BuildConfig.API_CLIENT_ID,
            BuildConfig.API_DEVICE_ID
        ))
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}