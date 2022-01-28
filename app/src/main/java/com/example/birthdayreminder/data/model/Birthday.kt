package com.example.birthdayreminder.data.model

import java.util.*

data class Birthday(
    var name: String,
    val DOB: Date,
    val notifyDate: Date,
    val notifyTime: Long
    )