package com.example.bantencookjet.ui.screen.about


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bantencookjet.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrow_back),
                            contentDescription = "Back"
                        )
                    }
                }
            )

        },
        content = { paddingValues ->
            AboutContent(
                modifier = modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun AboutContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.fadly),
            contentDescription = "Gambar profile",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp, top = 24.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Fadly Oktapriadi",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "fadlyoktapriadi41@gmail.com",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AboutContent()
}
