package com.example.forestrysafe.model

import com.google.gson.annotations.SerializedName;

data class Feeder(
    val id: Int,
    val completed: Boolean,
    val status: Boolean,
    val type: String,
    val forestry: Int

)