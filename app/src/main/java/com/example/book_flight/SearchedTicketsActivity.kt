package com.example.book_flight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book_flight.databinding.ActivitySearchedTicketsBinding

class SearchedTicketsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchedTicketsBinding

    lateinit var ticketList: ArrayList<TicketDataClass>
    lateinit var ticketAdapter: TicketAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySearchedTicketsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initalizeDumpData()


    }//onCreate


    //Creation of Dumpy Data function.
    fun initalizeDumpData(){

        binding.recycylerViewTicket.setHasFixedSize(true)
        binding.recycylerViewTicket.layoutManager = LinearLayoutManager(this)

        ticketList = ArrayList()

        ticketList.add(TicketDataClass(R.drawable.thy_logo,"Turkish Airlines",
            "AYT","09:45",
            "BGG","12:00",
            "2hrs 15mins",998))

        ticketList.add(TicketDataClass(R.drawable.pgsus_logo,"Pegasus Airlines",
            "AYT","15:00",
            "BGG","17:30",
            "2hrs 30mins",1260))

        ticketList.add(TicketDataClass(R.drawable.andl_jet_logo,"Anadolu Jet",
            "AYT","19:20",
            "BGG","21:30",
            "2hrs 10mins",1127))

        ticketList.add(TicketDataClass(R.drawable.thy_logo,"Turkish Airlines",
            "AYT","19:20",
            "BGG","21:55",
            "2hrs 35mins",3060))

        ticketList.add(TicketDataClass(R.drawable.thy_logo,"Turkish Airlines",
            "AYT","20:20",
            "BGG","22:25",
            "2hrs 05mins",2460))

        ticketList.add(TicketDataClass(R.drawable.pgsus_logo,"Pegasus Airlines",
            "AYT","22:35",
            "BGG","23:55",
            "1hrs 20mins",5660))

        ticketAdapter = TicketAdapter(ticketList)
        binding.recycylerViewTicket.adapter = ticketAdapter
    }


}