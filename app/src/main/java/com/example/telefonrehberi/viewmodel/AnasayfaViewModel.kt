package com.example.telefonrehberi.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.telefonrehberi.model.RehberModel
import com.example.telefonrehberi.roomdatabase.RehberDao
import com.example.telefonrehberi.roomdatabase.RehberDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(private val dao: RehberDao) : ViewModel() {

    var kisi_listesi by mutableStateOf<List<RehberModel>>(listOf())

    fun getAllData() {
         viewModelScope.launch(Dispatchers.IO) { kisi_listesi = dao.getAllData() }
    }

    fun deleteData(kisi: RehberModel) {
        viewModelScope.launch (Dispatchers.IO){ dao.deleteData(kisi) }
    }
}