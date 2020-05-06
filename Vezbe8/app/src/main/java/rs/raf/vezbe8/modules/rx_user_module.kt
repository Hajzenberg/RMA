package rs.raf.vezbe8.modules

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import rs.raf.vezbe8.data.datasources.rx.RxJsonUserDataSource
import rs.raf.vezbe8.data.datasources.rx.RxSharedPreferenceUserDataSource
import rs.raf.vezbe8.data.datasources.rx.RxUserDataSource
import rs.raf.vezbe8.data.repositories.rx.RxUserRepository
import rs.raf.vezbe8.data.repositories.rx.RxUserRepositoryImpl
import rs.raf.vezbe8.presentation.viewmodels.RxUserViewModel

val rxUserModule = module {

    viewModel { RxUserViewModel(userRepository = get()) }

    single<RxUserRepository> { RxUserRepositoryImpl(userDataSource = get(named("shared"))) }

    single<RxUserDataSource>(named("shared")) { RxSharedPreferenceUserDataSource(sharedPreferences = get()) }

    single<RxUserDataSource>(named("json")) { RxJsonUserDataSource(context = androidApplication(), moshi = get()) }

}