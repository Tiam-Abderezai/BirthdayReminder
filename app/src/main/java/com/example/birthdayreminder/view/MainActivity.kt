package com.example.birthdayreminder.view

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birthdayreminder.R
import java.util.*

class MainActivity : AppCompatActivity() {

    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dpd = DatePickerDialog(this, { view, year, monthOfYear, dayOfMonth ->

            // Display Selected date in textbox
//            lblDate.setText("" + dayOfMonth + " " + MONTHS[monthOfYear] + ", " + year)

        }, year, month, day)

        dpd.show()
    }
}