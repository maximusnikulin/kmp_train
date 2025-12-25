package com.example.kmp_train

interface ISimpleColorView {
    var presenter: IColorScreenPresenter?
    fun showColor(color: Colors)
}

class ColorScreenPresenter : IColorScreenPresenter {
    override var colorView: ISimpleColorView? = null

    // Код какой-то…
    fun showColor(color: Colors) {
        colorView?.showColor(color)
    }

    override fun randomizeColor() {
        val colorCode = (0..2).random()
        val color = Colors.entries.find { it.id == colorCode}
        showColor(color ?: Colors.BLUE)
    }
}

interface IColorScreenPresenter {
    var colorView: ISimpleColorView?
    fun randomizeColor()
}

enum class Colors(val id: Int) {
    BLUE(0), RED(2), GREEN(3)
}