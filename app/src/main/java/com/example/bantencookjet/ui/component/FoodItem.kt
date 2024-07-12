package com.example.bantencookjet.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bantencookjet.R
import com.example.bantencookjet.ui.theme.BantenCookJetTheme

@Composable
fun FoodItem(
    image: Int,
    title: String,
    desc: String,
    estimatePrice: String,
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 6.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = desc,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = estimatePrice,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FoodItemPreview() {
    BantenCookJetTheme {
        FoodItem(R.drawable.food1, "Sate Bandeng", "aasdfasdgsaas", "Rp331-Rp331")
    }
}
