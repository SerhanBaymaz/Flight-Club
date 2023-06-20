package com.example.book_flight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book_flight.databinding.ActivityPassengerInputinfoBinding
import com.google.android.material.textfield.TextInputEditText

class PassengerInputinfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityPassengerInputinfoBinding

    lateinit var passengerInputList: ArrayList<PassengerInputDataClass>
    lateinit var passengerInputAdapter: PassengerInputAdapter

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        binding = ActivityPassengerInputinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initalizeDumpyData()
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

    //Creation of Dumpy Data function.
    fun initalizeDumpyData(){

        binding.recycylerViewInputPassengers.setHasFixedSize(true)
        binding.recycylerViewInputPassengers.layoutManager = LinearLayoutManager(this)

        passengerInputList = ArrayList()

        passengerInputList.add(PassengerInputDataClass(
            "1.person",
            name = TextInputEditText(this).apply { setText("") },
            surname = TextInputEditText(this).apply { setText("") },
            birthday = TextInputEditText(this).apply { setText("1") },
            identityNo = TextInputEditText(this).apply { setText("") },
            gender = RadioGroup(this).apply { check(R.id.radioButton_woman) }
        ))

        passengerInputList.add(PassengerInputDataClass(
            "2.person",
            name = TextInputEditText(this).apply { setText("") },
            surname = TextInputEditText(this).apply { setText("") },
            birthday = TextInputEditText(this).apply { setText("1") },
            identityNo = TextInputEditText(this).apply { setText("") },
            gender = RadioGroup(this).apply { check(R.id.radioButton_woman) }
        ))

        passengerInputList.add(PassengerInputDataClass(
            "3.person",
            name = TextInputEditText(this).apply { setText("") },
            surname = TextInputEditText(this).apply { setText("") },
            birthday = TextInputEditText(this).apply { setText("1") },
            identityNo = TextInputEditText(this).apply { setText("") },
            gender = RadioGroup(this).apply { check(R.id.radioButton_woman) }
        ))

        passengerInputList.add(PassengerInputDataClass(
            "4.person",
            name = TextInputEditText(this).apply { setText("") },
            surname = TextInputEditText(this).apply { setText("") },
            birthday = TextInputEditText(this).apply { setText("1") },
            identityNo = TextInputEditText(this).apply { setText("") },
            gender = RadioGroup(this).apply { check(R.id.radioButton_woman) }
        ))


        passengerInputAdapter = PassengerInputAdapter(passengerInputList)
        binding.recycylerViewInputPassengers.adapter = passengerInputAdapter

    }

}//class