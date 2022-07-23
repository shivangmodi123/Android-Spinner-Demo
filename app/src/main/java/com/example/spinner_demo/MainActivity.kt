package com.example.spinner_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languages = resources.getStringArray(R.array.Languages)

        if (spinner1 != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter

            spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.select_language) + " " +
                                "" + languages[p2], Toast.LENGTH_SHORT
                    ).show()
                }

                @SuppressLint("SetTextI18n")
                override fun onNothingSelected(p0: AdapterView<*>?) {
//                    textTV1.text = "please select an option"
                }
            }
        }
    }
}