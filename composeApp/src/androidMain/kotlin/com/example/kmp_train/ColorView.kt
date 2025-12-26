package com.example.kmp_train

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ColorView(vm: ColorVM, modifier: Modifier = Modifier) {
    val color = vm.color.collectAsState()
    val ns = NewsService()

    val coroutineScope = rememberCoroutineScope()
    var result by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.setup()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color.value ?: Color.White
            )
    ) {
        Text(text = "Press button to change color")
        Button(onClick = {
            coroutineScope.launch {
                try {
                    val res = ns.makeCall() // suspend функция
                    result = res // обновляем состояние
                } catch (e: Exception) {
                    // Обработка ошибок (по желанию)
                    result = "Ошибка: ${e.message}"
                }
            }
        }) {
            Text("Вызвать makeCall")
        }

        if (result.isNotEmpty()) {
            Text(
                text = "Результат: $result",
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Blue
            )
        }

        Button(onClick = {
            vm.presenter?.randomizeColor()
        }) {
            Text(text = "Change color")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorView(ColorVM())
}