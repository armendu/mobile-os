package com.example.plantapp.screens.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantapp.ViewModelProvider
import kotlinx.coroutines.flow.collect

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentViewModel = viewModel(
        factory = ViewModelProvider.Factory
    )
) {
    val state by viewModel.contentUiState.collectAsState()

    viewModel.logApiData()

    LazyColumn(modifier = modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
        items(items = state.plantsList, key = { it.uid }) {
            it -> Plant(it.name)
        }
    }
//    val state by viewModel.contentUiState.collectAsState()
//    val plantsList by viewModel.plantsFromStorageService.collectAsState(initial = listOf())
//
//    LazyColumn(modifier = modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
//        items(items = plantsList, key = { it.uid }) {
//            it -> Plant(it.name)
//        }
//    }
}

@Composable
fun Plant(name: String, modifier: Modifier = Modifier) {
    val isExpanded = remember { mutableStateOf(false) }
    val expandedPadding = if (isExpanded.value) 48.dp else 0.dp
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

            ElevatedButton(onClick = { isExpanded.value = !isExpanded.value }) {
                Text(text = if (!isExpanded.value) "Click to expand" else "Hide")
            }
        }
    }
}