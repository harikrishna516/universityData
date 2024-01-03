package com.sample.model

data class UniversityModelItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val web_pages: List<String>
)