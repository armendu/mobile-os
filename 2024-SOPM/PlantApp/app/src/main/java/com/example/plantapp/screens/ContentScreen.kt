package com.example.plantapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.plantapp.PlantApp
import com.example.plantapp.data.AppDatabase
import kotlinx.coroutines.launch

@Composable
fun ContentScreen(modifier: Modifier = Modifier, plantNames: List<String> = listOf("Bamboo", "Cactus", "Orchid")) {
    Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
        for (name in plantNames) {
            Plant(name)
        }
    }
}

@Composable
fun Plant(name: String, modifier: Modifier = Modifier) {
    val isExpanded = remember { mutableStateOf(false) }
    val expandedPadding = if (isExpanded.value) 48.dp else 0.dp
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Surface(
        modifier = modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(modifier = modifier.padding(20.dp)) {
            Column(modifier = Modifier.padding(expandedPadding)) {
                Text(
                    text = "$name!",
                    modifier = modifier
                )
            }

            ElevatedButton(onClick = { coroutineScope.launch {
                val repo = AppDatabase.getDatabase(context.applicationContext).plantDao()
                repo.insert(com.example.plantapp.data.Plant(1, "Same plant", "Description"))

            } }) {
                Text(text = if (!isExpanded.value) "Click to expand" else "Hide")
            }
        }
    }
}