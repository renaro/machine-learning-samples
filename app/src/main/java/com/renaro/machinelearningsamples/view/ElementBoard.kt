package com.renaro.machinelearningsamples.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.renaro.machinelearningsamples.model.Element

/**
 * Created by renarosantos1 on 24/01/18.
 */
open class ElementBoard(context: Context, attributes: AttributeSet) : View(context, attributes) {
    var elements = mutableListOf<Element>()

    fun addElement(element: Element) {
        elements.add(element)
        invalidate()
    }
    open fun resetBoard() {
        elements.clear()
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        elements.forEach { element -> canvas?.drawCircle(element.x, element.y, element.RADIUS, element.paint) }
    }

}