package com.renaro.machinelearningsamples.model

import android.graphics.Color

/**
 * Created by renarosantos1 on 05/01/18.
 */
enum class PredefinedColors(val position : Int, val color : Int ){

    RED(0, Color.RED),
    BROWN(1, Color.argb(255,139,69,19)),
    BLUE(2, Color.BLUE),
    GREEN(3, Color.GREEN),
    MAGENTA(4, Color.MAGENTA)

}