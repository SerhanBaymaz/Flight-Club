package com.example.book_flight.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.book_flight.R
import com.example.book_flight.databinding.FragmentProfileBinding
import com.example.book_flight.databinding.FragmentTicketBinding


class TicketFragment : Fragment(R.layout.fragment_ticket) {

    lateinit var binding: FragmentTicketBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentTicketBinding.bind(view)




    }

}