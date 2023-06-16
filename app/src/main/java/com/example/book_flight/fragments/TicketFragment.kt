package com.example.book_flight.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book_flight.CancelFlightActivity
import com.example.book_flight.R
import com.example.book_flight.TicketAdapter
import com.example.book_flight.TicketDataClass
import com.example.book_flight.databinding.FragmentProfileBinding
import com.example.book_flight.databinding.FragmentTicketBinding


class TicketFragment : Fragment(R.layout.fragment_ticket) {

    lateinit var binding: FragmentTicketBinding

    lateinit var ticketList: ArrayList<TicketDataClass>
    lateinit var ticketAdapter: TicketAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentTicketBinding.bind(view)



        initalizeDumpyData()

    }//onView method

    //Creation of Dumpy Data function.
    fun initalizeDumpyData(){

        binding.recycylerViewTicketCancellation.setHasFixedSize(true)
        binding.recycylerViewTicketCancellation.layoutManager = LinearLayoutManager(activity)

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
        binding.recycylerViewTicketCancellation.adapter = ticketAdapter


        ///enable the click card item
        ticketAdapter.onItemClick = {
            val intent = Intent(activity, CancelFlightActivity::class.java)
            intent.putExtra("tickettt",it)
            startActivity(intent)
        }


    }

}