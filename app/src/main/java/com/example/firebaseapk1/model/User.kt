package com.example.firebaseapk1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class User (
var nama: String,
var email: String,
var lahir: String,
var password: String
)