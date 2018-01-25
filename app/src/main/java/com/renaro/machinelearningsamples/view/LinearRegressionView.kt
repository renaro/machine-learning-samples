package com.renaro.machinelearningsamples.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by renarosantos1 on 10/01/18.
 */
class LinearRegressionView(context: Context, attributes: AttributeSet) : ElementBoard(context, attributes) {
    var listener: OnViewClicked? = null

    init {
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                listener?.onClick(event.x, event.y)
            }
            true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        elements.forEach { element -> canvas?.drawCircle(element.x, element.y, element.RADIUS, element.paint) }
    }


    interface OnViewClicked {
        fun onClick(posX: Float, posY: Float)
    }

    fun runClicked() {
        var sumx = 0.0
        var sumy = 0.0
        var sumx2 = 0.0
        elements.forEach{ element ->
            sumx  += element.x
            sumx2 += (element.x * element.x)
            sumy  += element.y
        }
        val xbar = sumx / elements.size
        val ybar = sumy /  elements.size

    }

}
