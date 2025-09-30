package com.example.telefonrehberi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.telefonrehberi.model.RehberModel
import com.example.telefonrehberi.viewmodel.KisiEkleViewModel

@Composable
fun KisiEkleScreen(navController: NavController, viewModel: KisiEkleViewModel = hiltViewModel()) {


    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpecialTextField(
            text = name,
            label = "Kişi Adı",
            keyboardType = KeyboardType.Text
        ) {
            name = it
        }

        Spacer(Modifier.height(12.dp))

        SpecialTextField(
            text = phoneNumber,
            label = "Telefon Numarası",
            keyboardType = KeyboardType.Number
        ) {
            phoneNumber = it
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                val kisi = RehberModel(name = name, phoneNumber = phoneNumber)
                viewModel.saveData(kisi)
                navController.navigate("anasayfa"){
                    popUpTo("kisi_ekle") { inclusive= true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5), contentColor = Color.White)
        ) {
            Text("Kaydet", fontSize = 18.sp)
        }
    }
}

@Composable
fun SpecialTextField(
    text: String,
    label: String,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp)
    )
}