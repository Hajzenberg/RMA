package rs.raf.vezbe5.application

import android.app.Application
import timber.log.Timber

class Vezbe5Application : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}