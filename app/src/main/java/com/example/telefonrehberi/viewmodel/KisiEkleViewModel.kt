package com.example.telefonrehberi.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.telefonrehberi.model.RehberModel
import com.example.telefonrehberi.roomdatabase.RehberDao
import com.example.telefonrehberi.roomdatabase.RehberDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiEkleViewModel @Inject constructor(private val dao: RehberDao) : ViewModel() {

    fun saveData(kisi: RehberModel) {
        viewModelScope.launch (Dispatchers.IO){
            dao.insertData(kisi)
        }
    }
}