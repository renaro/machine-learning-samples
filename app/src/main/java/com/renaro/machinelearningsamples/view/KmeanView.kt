package com.renaro.machinelearningsamples.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import com.renaro.machinelearningsamples.model.Kernel
import com.renaro.machinelearningsamples.model.PredefinedColors


/**
 * Created by renarosantos1 on 08/12/17.
 */
class KmeanView(context: Context, attributes: AttributeSet) : ElementBoard(context, attributes) {
    var listener: UserInterface? = null
    var kernels = mutableListOf<Kernel>()
    val availableColors = PredefinedColors.values()
    private var step: Int = 0

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
        kernels.forEach { kernel ->
            canvas?.drawCircle(kernel.x, kernel.y, kernel.RADIUS, kernel.paint)
        }
    }


    interface UserInterface {
        fun onClick(posX: Float, posY: Float)
        fun onError(message: String)
        fun nextStepIteration(iteration: Int)
        fun hasConverged()
    }

    fun addKernel(kernel: Kernel) {
        if (kernels.size < 5) {
            kernel.paint.color = availableColors[kernels.size].color
            kernels.add(kernel)
            invalidate()
        } else {
            listener?.onError("Max Kernel number is 5");
        }

    }

    fun onRunClicked() {
        if (elements.isEmpty() || kernels.isEmpty()) {
            listener?.onError("Number of Data Points and Elements must not be 0")
        } else if (kernels.size > elements.size) {
            listener?.onError("Number of Elements should be greater than Kernels")
        } else {
            runKmeans()
        }
    }

    private fun runKmeans() {
        //STEP 1 - update the elements with the nearest kernel
        if (step == 0 || step % 2 == 0) {
            updateNearestKernel()
            //STEP 2 - Calculate the new position of the kernels based on the mean of the elements
        } else {
            val hasChanged = moveKernels()
            //if the kernels hasn't changed, it is over!
            if (!hasChanged) {
                listener?.hasConverged()
            }
        }
        listener?.nextStepIteration(++step)
    }

    private fun moveKernels(): Boolean {
        var hasChanged = false
        kernels.forEach({ kernel ->
            val elementsFromKernel = elements.filter { it.nearestKernel == kernel }
            if (elementsFromKernel.isNotEmpty()) {
                var sumX = 0f
                var sumY = 0f
                elementsFromKernel.forEach({ e -> sumX += e.x; sumY += e.y })
                val newKernelX = sumX / elementsFromKernel.size.toFloat()
                val newKernelY = sumY / elementsFromKernel.size.toFloat()
                if (hasChanged || Kernel(newKernelX, newKernelY) != kernel) {
                    hasChanged = true
                }
                kernel.x = newKernelX
                kernel.y = newKernelY
            }

        })
        invalidate()
        return hasChanged
    }

    private fun updateNearestKernel() {
        elements.forEach({ element ->
            element.updateNearestKernel(kernels)
        })
        invalidate()
    }

    override fun resetBoard() {
        step = 0
        listener?.nextStepIteration(step)
        elements.clear()
        kernels.clear()
        invalidate()
    }


}