package com.example.book_flight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.book_flight.databinding.ActivityPassengerInputinfoBinding

class PassengerInputinfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityPassengerInputinfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        binding = ActivityPassengerInputinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickCardItem() //enables the click the card item.

        binding.buttonContinue.setOnClickListener {
            val intent = Intent(this, CheckOutActivity::class.java)
            startActivity(intent)
        }

    }//onCreate

    fun clickCardItem(){

        val ticket1 = intent.getParcelableExtra<TicketDataClass>("tickett")

        if (ticket1 != null){
            binding.cardTicketSummaryCheckout.textViewAirline.text = ticket1.airlineName
            binding.cardTicketSummaryCheckout.imageViewAirline.setImageResource(ticket1.airlineImage)

            binding.cardTicketSummaryCheckout.TextViewDepTime.text = ticket1.departureTime
            binding.cardTicketSummaryCheckout.textViewArrTime.text = ticket1.arrivalTime

            binding.cardTicketSummaryCheckout.textViewTotalAmountSummary.text = ticket1.totalAmount.toString()


        }

    }

}//class