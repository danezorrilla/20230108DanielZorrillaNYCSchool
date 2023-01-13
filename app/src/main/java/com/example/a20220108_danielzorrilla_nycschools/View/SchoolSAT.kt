package com.example.a20220108_danielzorrilla_nycschools.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.a20220108_danielzorrilla_nycschools.R

class SchoolSAT : AppCompatActivity() {

    private lateinit var schoolName: TextView
    private lateinit var schoolRead: TextView
    private lateinit var schoolMath: TextView
    private lateinit var schoolWrite: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_sat)

        val bundle = intent.extras

        schoolName = findViewById(R.id.school_sat_name)
        schoolName.text = bundle?.getString("name")

        schoolRead = findViewById(R.id.school_sat_read_avg)
        schoolRead.text = "SAT Reading Score: " + bundle?.getString("reading_score")

        schoolMath = findViewById(R.id.school_sat_math_avg)
        schoolMath.text = "SAT Math Score: " + bundle?.getString("math_score")

        schoolWrite = findViewById(R.id.school_sat_write_avg)
        schoolWrite.text = "SAT Writing Score: " + bundle?.getString("writing_score")
    }
}