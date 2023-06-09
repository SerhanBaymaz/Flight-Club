package com.example.book_flight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TicketAdapter(val ticketList:ArrayList<TicketDataClass>) :
    RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    class TicketViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageViewAirline : ImageView = itemView.findViewById(R.id.imageView_airline)
        val textViewAirline : TextView = itemView.findViewById(R.id.textView_airline)

        val textViewDepartureAirport : TextView = itemView.findViewById(R.id.textView_departure_ticket)
        val textViewDepartureTime : TextView = itemView.findViewById(R.id.textView_dep_hour)
        val textViewArrivalAirport : TextView = itemView.findViewById(R.id.textView_arrvl_ticket)
        val textViewArrivalTime : TextView = itemView.findViewById(R.id.textView_arrvl_hour)

        val textViewTotalTime : TextView = itemView.findViewById(R.id.textView_total_flight_time)
        val textViewTotalAmount : TextView = itemView.findViewById(R.id.textView_total_amount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_ticket_item,parent,false)
        return TicketViewHolder(view)
    }


    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = ticketList[position]
        holder.imageViewAirline.setImageResource(ticket.airlineImage)
        holder.textViewAirline.text = ticket.airlineName

        holder.textViewArrivalAirport.text = ticket.arrivalAirport
        holder.textViewArrivalTime.text = ticket.arrivalTime
        holder.textViewDepartureAirport.text = ticket.departureAirport
        holder.textViewDepartureTime.text = ticket.departureTime

        holder.textViewTotalTime.text = ticket.totalFlightTime
        holder.textViewTotalAmount.text = ticket.totalAmount.toString()


    }


    override fun getItemCount(): Int {
        return ticketList.size
    }




}