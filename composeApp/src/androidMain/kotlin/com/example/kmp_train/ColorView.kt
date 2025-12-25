package com.example.kmp_train

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ColorView(vm: ColorVM, modifier: Modifier = Modifier) {
    val color = vm.color.collectAsState()
    LaunchedEffect(Unit) {
        vm.setup()
    }

    Column(
        modifier = modifier.fillMaxSize().background(
            color.value ?: Color.White
        )
    ) {
        Text(text = "Press button to change color")
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