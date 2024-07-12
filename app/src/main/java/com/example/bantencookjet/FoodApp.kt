package com.example.bantencookjet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bantencookjet.model.FoodDataSource
import com.example.bantencookjet.ui.component.FoodItem
import com.example.bantencookjet.ui.theme.BantenCookJetTheme

@Composable
fun FoodApp(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier) {
        LazyColumn {
            items(FoodDataSource.dummyFood, key = { it.id }) {
                FoodItem(image = it.image, title = it.name, desc = it.description, estimatePrice = it.estimatePrice)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodAppPreview() {
    BantenCookJetTheme {
        FoodApp()
    }
}