package rs.raf.vezbe12.application

import android.app.Application
import timber.log.Timber

class Vezbe12Application : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}