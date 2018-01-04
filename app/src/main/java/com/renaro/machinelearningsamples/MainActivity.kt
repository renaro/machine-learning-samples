package com.renaro.machinelearningsamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.renaro.machinelearningsamples.model.Element
import com.renaro.machinelearningsamples.view.KmeanView

class MainActivity : AppCompatActivity(), KmeanView.OnClicked {

    lateinit var board: KmeanView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board = findViewById<KmeanView>(R.id.canvas)
        board.listener = this
    }

    override fun onClick(posX: Float, posY: Float) {
        board.addElement(Element(posX, posY))
    }

}
