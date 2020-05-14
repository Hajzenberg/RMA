package rs.raf.vezbe10.presentation.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.vezbe10.R
import rs.raf.vezbe10.data.local.models.CourseEntity
import rs.raf.vezbe10.data.local.models.StudentEntity
import rs.raf.vezbe10.presentation.contract.MainContract
import rs.raf.vezbe10.presentation.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        //mainViewModel.getAllStudents()
//        val list = mutableListOf<StudentEntity>(
//            StudentEntity(
//                0,
//                "mika",
//                "beograd",
//                "ulica",
//                "37"
//            ),
//            StudentEntity(
//                0,
//                "laza",
//                "beograd",
//                "ulica",
//                "37"
//            )
//        )
//        mainViewModel.insertStudents(
//            list
//        )
//        mainViewModel.getAllStudentsWithNameAndCity()
//        mainViewModel.insertCourse(CourseEntity(0, "DAA", 1))
//        mainViewModel.insertCourse(CourseEntity(0, "DAA", 2))

        mainViewModel.getAllStudentsWithClasses()
    }
}
