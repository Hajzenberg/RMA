package rs.raf.vezbe4.application

import android.app.Application
import timber.log.Timber

class Vezbe4Application : Application() {

    // onCreate() aplikacije ce biti pozvan odmah po pokretanju aplikacije,
    // pre nego sto se pokrene bilo koji activity
    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    // Biblioteka Timber zahteva inicijalizaciju prilikom pokretanja aplikacije.
    // Ne zahtevaju sve biblioteke ovakvu inicijalizaciju
    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}