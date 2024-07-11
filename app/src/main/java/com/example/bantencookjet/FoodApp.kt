package com.example.bantencookjet

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bantencookjet.ui.theme.BantenCookJetTheme

@Composable
fun FoodApp(){}

@Preview(showBackground = true)
@Composable
fun JetHeroesAppPreview() {
    BantenCookJetTheme {
        FoodApp()
    }
}