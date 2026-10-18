package com.fitlifepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { FitLifeApp() } }
    }
}

@Composable
private fun FitLifeApp() {
    var calories by rememberSaveable { mutableStateOf("1900") }
    var water by rememberSaveable { mutableStateOf("2.0") }
    var weight by rememberSaveable { mutableStateOf("79") }
    var message by rememberSaveable { mutableStateOf("Your fitness journey starts with one small step.") }

    Scaffold { padding ->
        Surface(Modifier.fillMaxSize().padding(padding), color = MaterialTheme.colorScheme.background) {
            Column(
                Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text("FitLife Pro", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("Your everyday fitness companion")
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("Today's overview", style = MaterialTheme.typography.titleLarge)
                        OutlinedTextField(calories, { calories = it }, label = { Text("Daily calories (kcal)") }, modifier = Modifier.fillMaxWidth())
                        OutlinedTextField(water, { water = it }, label = { Text("Water (litres)") }, modifier = Modifier.fillMaxWidth())
                        OutlinedTextField(weight, { weight = it }, label = { Text("Current weight (kg)") }, modifier = Modifier.fillMaxWidth())
                        Button(onClick = { message = "Details updated on this screen. We'll add permanent saving after the first successful build." }, modifier = Modifier.fillMaxWidth()) {
                            Text("Save today's details")
                        }
                    }
                }
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Food diary", style = MaterialTheme.typography.titleLarge)
                        Spacer(Modifier.height(6.dp))
                        Text("Next: meal logging and daily nutrition totals.")
                    }
                }
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Activity", style = MaterialTheme.typography.titleLarge)
                        Spacer(Modifier.height(6.dp))
                        Text("Next: steps, walks, and workout logging.")
                    }
                }
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Progress", style = MaterialTheme.typography.titleLarge)
                        Spacer(Modifier.height(6.dp))
                        Text("Next: saved weight entries and progress history.")
                    }
                }
                Text(message, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
