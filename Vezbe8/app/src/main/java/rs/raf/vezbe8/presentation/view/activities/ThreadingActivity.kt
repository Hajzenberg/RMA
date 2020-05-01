package rs.raf.vezbe8.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_threading.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.vezbe8.R
import rs.raf.vezbe8.presentation.contracts.ThreadContract
import rs.raf.vezbe8.presentation.viewmodels.ThreadViewModel
import timber.log.Timber

class ThreadingActivity : AppCompatActivity(R.layout.activity_threading) {

    private val threadViewModel: ThreadContract.ViewModel by viewModel<ThreadViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
        initUi()
    }

    private fun initObservers() {
        threadViewModel.data.observe(this, Observer {
            dataTv.text = it
        })
    }

    private fun initUi() {
        startBtn.setOnClickListener {
            //loopWithoutThreads()
            //startThreads()
            //updateTextViewFromBackgroundThread()
            //updateTextViewFromBackgroundThread2()
            //updateLiveDataFromBackgroundThread()
            //rxSimple()
            //rxFromCallable()
            //rxEmitter()
        }
    }

    private fun loopWithoutThreads() {
        Timber.e("Loop 1")
        for (i in 1..1000) {
            Timber.e("Thread ${Thread.currentThread().name}")
        }
        Timber.e("Loop 2")
        for (i in 1..1000) {
            Timber.e("Thread ${Thread.currentThread().name}")
        }

    }

    private fun startThreads() {
        Thread(
            Runnable {
                for (i in 1..1000) {
                    Timber.e("Thread ${Thread.currentThread().name}")
                }
            }
        ).start()
        Thread(
            Runnable {
                for (i in 1..1000) {
                    Timber.e("Thread ${Thread.currentThread().name}")
                }
            }
        ).start()
    }

    private fun updateTextViewFromBackgroundThread() {
        Thread(
            Runnable {
                dataTv.text = "Hello from thread ${Thread.currentThread().name}, or no?"
            }
        ).start()
    }

    private fun updateTextViewFromBackgroundThread2() {
        Thread(
            Runnable {
                runOnUiThread {
                    dataTv.text = "Hello from thread ${Thread.currentThread().name}, yep!"
                }
            }
        ).start()
    }

    private fun updateLiveDataFromBackgroundThread() {
        Thread(
            Runnable {
                threadViewModel.updateData("Hello from background thread")
            }
        ).start()
    }

    private fun rxSimple() {
        Observable
            .just("Hello")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("Message $it")
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Complete")
                }
            )
    }

    private fun rxFromCallable() {
        Observable
            .fromCallable {
                Timber.e("From callable")
                "Hello from callable"
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("Message $it")
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Complete")
                }
            )
    }

    private fun rxEmitter() {
        Observable
            .create<String> {
                it.onNext("From emitter")
                it.onNext("Another message from emitter")
                //it.onError(Throwable("Error happened in emitter"))
                it.onComplete()
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("Message $it")
                },
                {
                    Timber.e("On error")
                    Timber.e(it)
                },
                {
                    Timber.e("Complete")
                }
            )
    }

}