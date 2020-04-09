package rs.raf.vezbe7.application

import android.app.Application
import timber.log.Timber

class Vezbe7Application : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}