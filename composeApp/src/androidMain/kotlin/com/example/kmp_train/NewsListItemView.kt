package com.example.kmp_train

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun NewsListItemView(item: NewsItem, modifier: Modifier = Modifier) {
// Горизонтальный контейнер
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp,8.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
// Изображение с загрузкой по url
        Image(painter = rememberImagePainter(item.urlToImage.orEmpty()),
            contentDescription = "image",
            modifier = Modifier.width(120.dp).height(120.dp).
            padding(0.dp, 0.dp, 8.dp, 0.dp))
// Вертикальный контейнер
        Column {
// Текст с настройками стиля
            Text(text = item.title.orEmpty(), style =
                MaterialTheme.typography.titleMedium)
            Text(text = item.content.orEmpty(), style =
                MaterialTheme.typography.titleSmall, maxLines = 3)
            Text(text = item.publishedAt.orEmpty(), style =
                MaterialTheme.typography.bodyMedium)
        }
    }
}
