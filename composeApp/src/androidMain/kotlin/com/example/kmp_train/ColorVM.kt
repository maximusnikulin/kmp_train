package com.example.kmp_train

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow

class ColorVM() : ISimpleColorView {
    val color: MutableStateFlow<Color?> = MutableStateFlow(null)
    override var presenter: IColorScreenPresenter? = null
    fun setup() {
        this.presenter = ColorScreenPresenter()
        this.presenter?.colorView = this

    }

    override fun showColor(color: Colors) {
        this.color.tryEmit(color.toColor())
    }
}