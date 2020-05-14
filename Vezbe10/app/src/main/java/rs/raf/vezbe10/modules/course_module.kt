package rs.raf.vezbe10.modules

import org.koin.dsl.module
import rs.raf.vezbe10.data.local.db.StudentDatabase
import rs.raf.vezbe10.data.local.repository.CourseRepository
import rs.raf.vezbe10.data.local.repository.CourseRepositoryImpl

val courseModule = module {

    single<CourseRepository> { CourseRepositoryImpl(get()) }

    single { get<StudentDatabase>().getCourseDao() }

}

