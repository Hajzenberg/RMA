package rs.raf.vezbe5.extensions

import android.app.Activity
import android.content.Intent

fun Activity.createIntent(cls: Class<out Any>) : Intent {
    return Intent(this, cls)
}