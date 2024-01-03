package com.sample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.databinding.ActivityMainBinding
import com.sample.viewmodel.UniversityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var universityModel: UniversityViewModel
    private lateinit var universityAdapter: UniversityAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        universityModel = ViewModelProvider(this)[UniversityViewModel::class.java]
        universityModel.universityData.observe(this) {
           universityAdapter.updateList(it.toList())
        }
        universityModel.getUniversityList()
        universityAdapter = UniversityAdapter(emptyList())
        binding.universityRv.layoutManager = LinearLayoutManager(this)
        binding.universityRv.adapter = universityAdapter
        val dividerItemDecoration = CustomDivider(this, LinearLayoutManager.VERTICAL)
        binding.universityRv.addItemDecoration(dividerItemDecoration)
    }
}