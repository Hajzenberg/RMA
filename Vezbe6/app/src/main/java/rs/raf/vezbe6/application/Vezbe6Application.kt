package rs.raf.vezbe6.application

import android.app.Application
import timber.log.Timber

class Vezbe6Application : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}