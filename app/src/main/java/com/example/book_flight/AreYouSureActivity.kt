package com.example.book_flight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book_flight.databinding.ActivityAreYouSureBinding
import com.example.book_flight.databinding.ActivityHomeBinding

class AreYouSureActivity : AppCompatActivity() {

    lateinit var binding: ActivityAreYouSureBinding

    lateinit var passengerList: ArrayList<PassengerDataClass>
    lateinit var passengerAdapter: PassengerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityAreYouSureBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initalizeDumpData()


    }//onCreate method


    //Creation of Dumpy Data function.
    fun initalizeDumpData(){

        binding.recycylerViewPassengers.setHasFixedSize(true)
        binding.recycylerViewPassengers.layoutManager = LinearLayoutManager(this)

        passengerList = ArrayList()

        passengerList.add(PassengerDataClass("1.Person","Zeynep","Bozgan","12345678913"))
        passengerList.add(PassengerDataClass("2.Person","Fadile","Çoban","12345678914"))
        passengerList.add(PassengerDataClass("3.Person","Ahmet","Kuyuldar","12345678915"))
        passengerList.add(PassengerDataClass("4.Person","Serhan","Baymaz","12345678912"))


        passengerAdapter = PassengerAdapter(passengerList)
        binding.recycylerViewPassengers.adapter = passengerAdapter



    }

}//AreYouSure class