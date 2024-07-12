package com.example.bantencookjet


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bantencookjet.ui.screen.about.AboutScreen
import com.example.bantencookjet.ui.screen.detail.DetailScreen
import com.example.bantencookjet.ui.screen.home.HomeScreen
import com.example.bantencookjet.ui.theme.BantenCookJetTheme

@Composable
fun FoodApp(
){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { HomeScreen(navController) }
        composable("detail/{foodId}") { backStackEntry ->
            DetailScreen(navController,backStackEntry.arguments?.getString("foodId") ?: "")
        }
        composable("about") { AboutScreen(navController) }
    }


}

@Preview(showBackground = true)
@Composable
fun FoodAppPreview() {
    BantenCookJetTheme {
        FoodApp()
    }
}