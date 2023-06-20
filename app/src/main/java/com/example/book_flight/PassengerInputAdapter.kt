package com.example.book_flight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class PassengerInputAdapter(val passengerInputList:ArrayList<PassengerInputDataClass>) :
    RecyclerView.Adapter<PassengerInputAdapter.PassengerInputViewHolder>() {//PassengerAdapter class


    class PassengerInputViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var header:TextView = itemView.findViewById(R.id.textView_header_person)

        var nameInput: TextInputEditText = itemView.findViewById(R.id.text_name_inputdata)
        var surnameInput: TextInputEditText = itemView.findViewById(R.id.text_surname_inputdata)
        var birthdayInput: TextInputEditText = itemView.findViewById(R.id.text_birthday_inputdata)
        var idnoInput: TextInputEditText = itemView.findViewById(R.id.text_idno_inputdata)
        var genderInput: RadioGroup = itemView.findViewById(R.id.radioGroup)

    }//PassengerViewHolder class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassengerInputAdapter.PassengerInputViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.passenger_infoinput_carditem,parent,false)
        return PassengerInputAdapter.PassengerInputViewHolder(view)
    }

    override fun getItemCount(): Int {
        return passengerInputList.size
    }

    override fun onBindViewHolder(holder: PassengerInputAdapter.PassengerInputViewHolder, position: Int) {

        val passenger = passengerInputList[position]

        holder.header.text = passenger.header

        holder.nameInput = passenger.name
        holder.surnameInput = passenger.surname
        holder.idnoInput = passenger.identityNo
        holder.birthdayInput =passenger.birthday
        holder.genderInput = passenger.gender
    }


}