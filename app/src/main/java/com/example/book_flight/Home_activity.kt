package com.example.book_flight

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.book_flight.databinding.ActivityHomeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Home_activity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val abc = arrayOf("a","b","c")
        val seatclass = resources.getStringArray(R.array.seatclass)
        val number_of_passengers = resources.getStringArray(R.array.passengers)

        val arrayAdapter_seat = ArrayAdapter(this, R.layout.list_item, R.id.textview_seatclasslist,seatclass)
        binding.autoCompleteTextViewSeatclass.setAdapter(arrayAdapter_seat)

        val arrayAdapter_passengers = ArrayAdapter(this, R.layout.list_item, R.id.textview_passengerlist,number_of_passengers)
        binding.autoCompleteTextViewPassengers.setAdapter(arrayAdapter_passengers)


        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable(myCalendar)
        }

        binding.btnDatePicker.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }



    }//oncreate

    fun updateLable(myCalendar: Calendar){
        val myFormat = "dd-MM-yyyy"
        val simpleDateFormat = SimpleDateFormat(myFormat, Locale.ENGLISH)

        binding.tvDatePicker.setText(simpleDateFormat.format(myCalendar.time))

    }

}//class