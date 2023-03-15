package com.example.myviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var result = 0

    fun calculate(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }

    /*
    Ketika menambahkan turunan kelas ViewModel ke kelas MainViewModel, menandakan bahwa kelas ini menjadi kelas ViewModel
    segala sesuatu yang ada dikelas ini akan terjaga ketika activity masih aktif.
     */
}