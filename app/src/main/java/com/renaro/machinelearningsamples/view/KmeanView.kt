package com.renaro.machinelearningsamples.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.renaro.machinelearningsamples.model.Element


/**
 * Created by renarosantos1 on 08/12/17.
 */
class KmeanView(context: Context?, attributes: AttributeSet) : View(context, attributes) {
    val paint = Paint()
    var listener: OnClicked? = null
    var elements = mutableListOf<Element>()

    init {
        paint.setColor(Color.BLACK)
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                listener?.onClick(event.x, event.y)
            }
            true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        elements.forEach { element ->
            canvas?.drawCircle(element.x, element.y, element.RADIUS, paint)
        }
    }


    interface OnClicked {
        fun onClick(posX: Float, posY: Float)
    }

    fun addElement(element: Element) {
        elements.add(element)
        invalidate()
    }


}