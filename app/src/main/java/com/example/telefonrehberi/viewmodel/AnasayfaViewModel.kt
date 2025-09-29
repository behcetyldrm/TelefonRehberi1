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
import com.example.telefonrehberi.roomdatabase.RehberDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel(context: Context) : ViewModel() {

    val database = RehberDatabase.DatabaseProvider.getDatabase(context)
    private val dao = database.rehberDao()

    var kisi_listesi by mutableStateOf<List<RehberModel>>(listOf())

    fun getAllData() {
         viewModelScope.launch(Dispatchers.IO) { kisi_listesi = dao.getAllData() }
    }
}