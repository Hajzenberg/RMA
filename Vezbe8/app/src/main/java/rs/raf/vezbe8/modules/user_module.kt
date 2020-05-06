package rs.raf.vezbe8.modules

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import rs.raf.vezbe8.data.datasources.JsonUserDataSource
import rs.raf.vezbe8.data.datasources.SharedPreferenceUserDataSource
import rs.raf.vezbe8.data.datasources.UserDataSource
import rs.raf.vezbe8.data.repositories.UserRepository
import rs.raf.vezbe8.data.repositories.UserRepositoryImpl
import rs.raf.vezbe8.presentation.viewmodels.UserViewModel

val userModule = module {

    viewModel { UserViewModel(userRepository = get()) }

    single<UserRepository> { UserRepositoryImpl(userDataSource = get(named("json"))) }

    single<UserDataSource>(named("shared")) { SharedPreferenceUserDataSource(sharedPreferences = get()) }

    single<UserDataSource>(named("json")) { JsonUserDataSource(context = androidApplication(), moshi = get()) }

}