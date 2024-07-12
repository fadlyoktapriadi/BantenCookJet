package com.example.bantencookjet.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.bantencookjet.common.UiState
import com.example.bantencookjet.di.Injection
import com.example.bantencookjet.model.Food
import com.example.bantencookjet.ui.ViewModelFactory
import com.example.bantencookjet.ui.component.FoodItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
        navController: NavHostController,
        modifier: Modifier = Modifier,
        viewModel: HomeViewModel = viewModel(
            factory = ViewModelFactory(Injection.provideRepository())
        )
    ){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Banten Cook") },
                actions = {
                    IconButton(onClick = { navController.navigate("about") }) {
                        Icon(Icons.Default.Person, contentDescription = "about_page")
                    }
                }
            )

        },
        content = { paddingValues ->
            viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getAllFood()
                    }
                    is UiState.Success -> {
                        HomeContent(
                            foods = uiState.data,
                            navController = navController,
                            modifier = modifier.padding(paddingValues)
                        )
                    }
                    is UiState.Error -> {}
                }
            }
        }
    )
}

@Composable
fun HomeContent(
    foods: List<Food>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(foods) {
                FoodItem(
                    image = it.image,
                    title = it.name,
                    desc = it.description,
                    estimatePrice = it.estimatePrice,
                    modifier = Modifier.clickable {
                        navController.navigate("detail/${it.id}")
                    }
                )
            }
        }
    }
}
