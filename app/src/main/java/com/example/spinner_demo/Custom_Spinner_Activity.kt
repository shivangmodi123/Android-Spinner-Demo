package com.example.spinner_demo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_custom_spinner.*

class Custom_Spinner_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_spinner)

        setupSimpleSpinner()

        setupCustomSpinner()

//        setupCustomSpinner3()
    }

//    private fun setupCustomSpinner3() {
//        val adapter = Spinner3CountryAdapter(this, Spinner3Country.list2!!)
//        spinner3.adapter = adapter
//    }

    private fun setupCustomSpinner() {
        val adapter = CountryArrayAdapter(this, Countries.list!!)
        customSpinner.adapter = adapter
        customSpinner2.adapter = adapter
    }

    private fun setupSimpleSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        simpleSpinner.adapter = adapter

        simpleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                p3: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(
                    this@Custom_Spinner_Activity,
                    "$selectedItem Selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
}