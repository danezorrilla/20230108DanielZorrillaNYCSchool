package com.example.a20220108_danielzorrilla_nycschools.Network

import com.example.a20220108_danielzorrilla_nycschools.Model.School
import retrofit2.Call
import retrofit2.http.GET

interface SchoolAPI {

    @GET("f9bf-2cp4.json")
    fun getSchoolList(): Call<List<School>>
}