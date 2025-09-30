package com.example.telefonrehberi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.telefonrehberi.viewmodel.AnasayfaViewModel

@Composable
fun AnasayfaScreen(viewModel: AnasayfaViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getAllData()
    }

    val kisi_listesi = viewModel.kisi_listesi

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 10.dp)
    ){
        items(kisi_listesi) { kisi ->
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = kisi.name, fontSize = 20.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(3.dp))
                    Text(text = kisi.phoneNumber, fontSize = 18.sp, modifier = Modifier.padding(3.dp))
                }

                IconButton(
                    onClick = { viewModel.deleteData(kisi) },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
                }
            }
            HorizontalDivider(thickness = 1.dp, color = Color.Black) //Çizgi koymak için
        }
    }
}