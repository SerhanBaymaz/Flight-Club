package com.example.book_flight

import android.os.Parcel
import android.os.Parcelable

data class TicketDataClass(
    val airlineImage:Int, val airlineName:String?,
    val departureAirport: String?, val departureTime:String?,
    val arrivalAirport:String?, val arrivalTime:String?,
    val totalFlightTime:String?, val totalAmount:Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(airlineImage)
        parcel.writeString(airlineName)
        parcel.writeString(departureAirport)
        parcel.writeString(departureTime)
        parcel.writeString(arrivalAirport)
        parcel.writeString(arrivalTime)
        parcel.writeString(totalFlightTime)
        parcel.writeInt(totalAmount)
    }

    companion object CREATOR : Parcelable.Creator<TicketDataClass> {
        override fun createFromParcel(parcel: Parcel): TicketDataClass {
            return TicketDataClass(parcel)
        }

        override fun newArray(size: Int): Array<TicketDataClass?> {
            return arrayOfNulls(size)
        }
    }


}
