package com.example.book_flight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PassengerAdapter(val passengerList:ArrayList<PassengerDataClass>) :
    RecyclerView.Adapter<PassengerAdapter.PassengerViewHolder>() {//PassengerAdapter class


    class PassengerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

            val textViewHeader : TextView = itemView.findViewById(R.id.textView_header_person)
            val textViewName : TextView = itemView.findViewById(R.id.textView_name_data)
            val textViewSurname : TextView = itemView.findViewById(R.id.textView_surname_data)
            val textViewIdno: TextView = itemView.findViewById(R.id.textView_idno_data)

        }//PassengerViewHolder class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.summary_person_carditem,parent,false)
        return PassengerAdapter.PassengerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return passengerList.size
    }

    override fun onBindViewHolder(holder: PassengerViewHolder, position: Int) {

        val passenger = passengerList[position]

        holder.textViewHeader.text = passenger.header
        holder.textViewName.text = passenger.name
        holder.textViewSurname.text = passenger.surname
        holder.textViewIdno.text = passenger.identityNo
    }


}