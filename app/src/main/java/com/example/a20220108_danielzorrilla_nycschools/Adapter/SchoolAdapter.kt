package com.example.a20220108_danielzorrilla_nycschools.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220108_danielzorrilla_nycschools.Model.School
import com.example.a20220108_danielzorrilla_nycschools.R

class SchoolAdapter(private val schools: List<School>, private val schoolInterface: SchoolInterface):
    RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>() {

    class SchoolViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.school_card_name)
        var schoolCardLayout: ConstraintLayout = itemView.findViewById(R.id.school_card_layout)
    }

    interface SchoolInterface{
        fun viewSAT(school: School)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.school_card, parent, false)
        return SchoolViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school_name = schools[position].name
        val sat_reading_score = schools[position].sat_critical_reading_score
        val sat_math_score = schools[position].sat_math_score
        val sat_writing_score = schools[position].sat_writing_score
        val currentSchool = School(school_name, sat_reading_score, sat_math_score, sat_writing_score)

        holder.name.text = schools[position].name
        holder.schoolCardLayout.setOnClickListener {
            schoolInterface.viewSAT(currentSchool)
        }
    }

    override fun getItemCount(): Int {
        return schools.size
    }

}