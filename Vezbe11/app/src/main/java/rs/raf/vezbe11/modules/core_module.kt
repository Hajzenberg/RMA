package rs.raf.vezbe11.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rs.raf.vezbe11.BuildConfig
import rs.raf.vezbe11.data.datasources.local.MovieDataBase
import java.util.*
import java.util.concurrent.TimeUnit

val coreModule = module {

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(androidApplication().packageName, Context.MODE_PRIVATE)
    }

    single { Room.databaseBuilder(androidContext(), MovieDataBase::class.java, "MovieDb")
        .fallbackToDestructiveMigration()
        .build() }

    single { createRetrofit(moshi = get(), httpClient = get()) }

    single { createMoshi() }

    single { createOkHttpClient() }
}

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()
}

fun createRetrofit(moshi: Moshi,
                   httpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://ghibliapi.herokuapp.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .client(httpClient)
        .build()
}

fun createOkHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.readTimeout(60, TimeUnit.SECONDS)
    httpClient.connectTimeout(60, TimeUnit.SECONDS)
    httpClient.writeTimeout(60, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
        httpClient.addNetworkInterceptor(StethoInterceptor())
    }

    return httpClient.build()
}

// Metoda koja kreira servis
inline fun <reified T> create(retrofit: Retrofit): T  {
    return retrofit.create<T>(T::class.java)
}

