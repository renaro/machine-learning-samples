package com.renaro.machinelearningsamples.model

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point


/**
 * Created by renarosantos1 on 04/01/18.
 */

class Element(val x: Float, val y: Float) {
    val paint = Paint()
    val RADIUS = 28F
    var nearestKernel = Kernel(x, y)

    init {
        paint.color = Color.BLACK
    }

    fun updateNearestKernel(kernels: MutableList<Kernel>) {
        var currentNearestKernel: Kernel = kernels[0]
        var minDistance: Double = Double.MAX_VALUE
        kernels.forEach({ kernel ->
            val distance = calculateDistance(kernel)
            if (distance < minDistance) {
                minDistance = distance
                currentNearestKernel = kernel
            }
        })
        nearestKernel = currentNearestKernel
        paint.color = nearestKernel.paint.color
    }

    private fun calculateDistance(kernel: Kernel): Double {
        val result = Point()
        result.y = Math.abs((y - kernel.y).toInt())
        result.x = Math.abs((x - kernel.x).toInt())
        val distance = Math.sqrt((result.y * result.y + result.x * result.x).toDouble())
        println(distance)
        return distance
    }
}