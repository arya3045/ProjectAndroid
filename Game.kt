package com.example.tugasakhir

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Game (

    var name: String = " ",
    var detail: String = " ",
    var photo: Int = 0

) : Parcelable