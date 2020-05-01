package rs.raf.vezbe8.modules

import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val coreModule = module {

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(androidApplication().packageName, Context.MODE_PRIVATE)
    }

    single<Moshi> { Moshi.Builder().build() }

}