package com.renaro.machinelearningsamples.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.renaro.machinelearningsamples.model.Element

/**
 * Created by renarosantos1 on 10/01/18.
 */
class LinearRegressionView(context: Context, attributes: AttributeSet) : View(context, attributes) {
    var listener: KmeanView.UserInterface? = null
    var elements = mutableListOf<Element>()
    var animationGoingOn = false

    init {
            setOnTouchListener{ _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    listener?.onClick(event.x, event.y)
                }
                true
            }
    }

    override fun onDraw(canvas: Canvas?) {
        elements.forEach { element ->  canvas?.drawCircle(element.x, element.y, element.RADIUS, element.paint) }
        if (animationGoingOn) {

        }
    }


}
