package rs.raf.vezbe8.data.datasources.rx

import android.content.Context
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import rs.raf.vezbe8.data.entities.UserData
import java.io.IOException

class RxJsonUserDataSource(
    private val context: Context,
    private val moshi: Moshi
    ) : RxUserDataSource {

    override fun getUserData(): Observable<UserData> {
        return Observable.create {
            val userJson = getJsonDataFromAsset()
            val jsonAdapter = moshi.adapter(UserData::class.java)
            val userData: UserData = jsonAdapter.fromJson(userJson)!! //Nije dobra praksa
            it.onNext(userData)
            it.onComplete()
        }
    }

    private fun getJsonDataFromAsset(): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("user.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}