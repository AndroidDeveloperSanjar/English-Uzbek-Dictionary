package com.example.dictionary.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String){
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}