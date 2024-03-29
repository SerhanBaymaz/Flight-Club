package com.example.book_flight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book_flight.databinding.ActivityCancelFlightBinding

class CancelFlightActivity : AppCompatActivity() {

    lateinit var binding: ActivityCancelFlightBinding

    lateinit var passengerList: ArrayList<PassengerDataClass>
    lateinit var passengerAdapter: PassengerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityCancelFlightBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initalizeDumpData()
        clickCardItem()



    }//onCreate method


    //Creation of Dumpy Data function.
    fun initalizeDumpData(){

        binding.recycylerViewCancelPassengers.setHasFixedSize(true)
        binding.recycylerViewCancelPassengers.layoutManager = LinearLayoutManager(this)

        passengerList = ArrayList()

        passengerList.add(PassengerDataClass("1.Person","Zeynep","Bozgan","12345678913"))
        passengerList.add(PassengerDataClass("2.Person","Fadile","Çoban","12345678914"))
        passengerList.add(PassengerDataClass("3.Person","Ahmet","Kuyuldar","12345678915"))
        passengerList.add(PassengerDataClass("4.Person","Serhan","Baymaz","12345678912"))


        passengerAdapter = PassengerAdapter(passengerList)
        binding.recycylerViewCancelPassengers.adapter = passengerAdapter



    }

    fun clickCardItem(){

        //enable the click the card item.
        val ticket1 = intent.getParcelableExtra<TicketDataClass>("tickettt")

        if (ticket1 != null){
            binding.cardTicketSummaryCancelactivity.textViewAirline.text = ticket1.airlineName
            binding.cardTicketSummaryCancelactivity.imageViewAirline.setImageResource(ticket1.airlineImage)

            binding.cardTicketSummaryCancelactivity.TextViewDepTime.text = ticket1.departureTime
            binding.cardTicketSummaryCancelactivity.textViewArrTime.text = ticket1.arrivalTime

            binding.cardTicketSummaryCancelactivity.textViewTotalAmountSummary.text = ticket1.totalAmount.toString()


        }

    }
}//class