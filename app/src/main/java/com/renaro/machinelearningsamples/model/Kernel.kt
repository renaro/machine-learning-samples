package com.renaro.machinelearningsamples.model

import android.graphics.Color
import android.graphics.Paint

/**
 * Created by renarosantos1 on 05/01/18.
 */

class Kernel(var x: Float, var y: Float) {
    val paint = Paint()
    val RADIUS = 10f

    init {
        paint.setColor(Color.RED)
    }

    override fun equals(other: Any?): Boolean {
        return other != null && other is Kernel && other.x == this.x && other.y == this.y
    }


}