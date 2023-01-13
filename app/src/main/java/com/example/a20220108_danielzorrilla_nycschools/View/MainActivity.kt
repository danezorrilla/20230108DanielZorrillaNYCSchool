package com.example.a20220108_danielzorrilla_nycschools.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220108_danielzorrilla_nycschools.Adapter.SchoolAdapter
import com.example.a20220108_danielzorrilla_nycschools.Model.School
import com.example.a20220108_danielzorrilla_nycschools.R
import com.example.a20220108_danielzorrilla_nycschools.ViewModel.SchoolViewModel

class MainActivity : AppCompatActivity(), SchoolAdapter.SchoolInterface {

    private lateinit var schoolViewModel: SchoolViewModel
    private lateinit var schoolObserver: Observer<List<School>>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.NYC_School_List)

        schoolViewModel = ViewModelProvider(this)[SchoolViewModel::class.java]
        schoolObserver = Observer { schools -> displaySchoolList(schools) }
        schoolObserver.let {
            schoolViewModel.getSchoolListResponse().observe(this, it)
        }
    }

    private fun displaySchoolList(schools: List<School>){
        for (i in schools.indices){
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = SchoolAdapter(schools, this)
        }
    }

    override fun viewSAT(school: School) {
        val name = school.name
        val reading_score = school.sat_critical_reading_score
        val math_score = school.sat_math_score
        val writing_score = school.sat_writing_score
        val intent = Intent(this, SchoolSAT::class.java)
        val bundle = Bundle()

        bundle.putString("name", name)
        bundle.putString("reading_score", reading_score)
        bundle.putString("math_score", math_score)
        bundle.putString("writing_score", writing_score)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}