package com.renaro.machinelearningsamples.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.renaro.machinelearningsamples.model.Element
import com.renaro.machinelearningsamples.model.Kernel
import com.renaro.machinelearningsamples.model.PredefinedColors


/**
 * Created by renarosantos1 on 08/12/17.
 */
class KmeanView(context: Context?, attributes: AttributeSet) : View(context, attributes) {
    var listener: OnClicked? = null
    var elements = mutableListOf<Element>()
    var kernels = mutableListOf<Kernel>()
    val availableColors = PredefinedColors.values()

    init {
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                listener?.onClick(event.x, event.y)
            }
            true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        elements.forEach { element ->
            canvas?.drawCircle(element.x, element.y, element.RADIUS, element.paint)
        }
        kernels.forEach { kernel ->
            canvas?.drawCircle(kernel.x, kernel.y, kernel.RADIUS, kernel.paint)
        }
    }


    interface OnClicked {
        fun onClick(posX: Float, posY: Float)
    }

    fun addElement(element: Element) {
        elements.add(element)
        invalidate()
    }

    fun addKernel(kernel: Kernel): Boolean {
        if (kernels.size < 5) {
            kernel.paint.color = availableColors[kernels.size].color
            kernels.add(kernel)
            invalidate()
            return true
        }
        return false
    }

    fun onRunClicked(): Boolean {
        if (kernels.size > elements.size) {
            return false
        } else {
            runKMeans()
            return true
        }
    }

    private fun runKMeans() {
        elements.forEach({ element ->
            element.updateNearestKernel(kernels)
        })
        invalidate()
    }


}