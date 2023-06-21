package com.example.book_flight.fragments

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.book_flight.R
import com.example.book_flight.SearchedTicketsActivity
import com.example.book_flight.databinding.ActivityHomeBinding
import com.example.book_flight.databinding.FragmentHomeBinding
import com.example.book_flight.signInActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)


        //val abc = arrayOf("a","b","c")
        val seatclass = resources.getStringArray(R.array.seatclass)
        val number_of_passengers = resources.getStringArray(R.array.passengers)

        val arrayAdapter_seat =
            activity?.let {
                ArrayAdapter(
                    it,
                    R.layout.list_item,
                    R.id.textview_seatclasslist,
                    seatclass
                )
            }
        binding.autoCompleteTextViewSeatclass.setAdapter(arrayAdapter_seat)

        val arrayAdapter_passengers = activity?.let {
            ArrayAdapter(
                it,
                R.layout.list_item,
                R.id.textview_passengerlist,
                number_of_passengers
            )
        }
        binding.autoCompleteTextViewPassengers.setAdapter(arrayAdapter_passengers)


        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }

        binding.btnDatePicker.setOnClickListener {
            activity?.let { it1 ->
                DatePickerDialog(
                    it1, datePicker, myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        binding.buttonSearchfltHome.setOnClickListener {
            val intent = Intent(activity, SearchedTicketsActivity::class.java)
            startActivity(intent)
        }


    }//onview method


    fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val simpleDateFormat = SimpleDateFormat(myFormat, Locale.ENGLISH)

        binding.tvDatePicker.setText(simpleDateFormat.format(myCalendar.time))

    }


}