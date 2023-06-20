package com.example.book_flight

import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText

data class PassengerInputDataClass(val header: String, val name:TextInputEditText, val surname:TextInputEditText,
                                   val birthday:TextInputEditText, val identityNo:TextInputEditText,
                                   val gender:RadioGroup)
