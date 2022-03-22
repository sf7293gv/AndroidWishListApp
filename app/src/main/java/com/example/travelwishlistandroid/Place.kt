package com.example.travelwishlistandroid

import java.text.SimpleDateFormat
import java.util.*

class Place(val name: String, val reason: String, val dateAdded: Date = Date()) {

    fun formattedDate(): String {
        return SimpleDateFormat("EEE, d, MMM, yyyy", Locale.getDefault()).format(dateAdded)
    }

}

