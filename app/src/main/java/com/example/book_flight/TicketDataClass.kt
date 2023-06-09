package com.example.book_flight

data class TicketDataClass(val airlineImage:Int, val airlineName:String,
                           val departureAirport:String, val departureTime:String,
                           val arrivalAirport:String, val arrivalTime:String,
                           val totalFlightTime:String, val totalAmount:Int)
