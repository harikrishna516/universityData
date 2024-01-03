package com.sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.model.UniversityModel
import com.sample.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UniversityViewModel : ViewModel(){
    val universityData = MutableLiveData<UniversityModel>()

    fun getUniversityList(){
        GlobalScope.launch(Dispatchers.IO) {
            val universityModel = ApiService.create().getUniversities()
            universityData.postValue(universityModel)
        }
    }
}