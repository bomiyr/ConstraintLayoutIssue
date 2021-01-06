package com.bomiyr.constraintlayoutbug

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.animateFrameLayoutBtn)
            .setOnClickListener {
                changeSize(R.id.view1)
            }

        findViewById<View>(R.id.animateConstraintLayoutBtn)
            .setOnClickListener {
                changeSize(R.id.view2)
            }

        findViewById<View>(R.id.animateConstraintLayoutBtn2)
            .setOnClickListener {
                changeSize(R.id.view3, true)
            }
    }

    fun changeSize(res: Int, requestLayoutForConstraintLayout: Boolean = false) {

        val frameLayout = findViewById<ViewGroup>(res)

        val finalHeight = TypedValue
            .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100f, resources.displayMetrics)
            .toInt()

        val constraintLayout = frameLayout?.getChildAt(0) as? ConstraintLayout

        val layoutParams = frameLayout.layoutParams
        layoutParams.height = finalHeight

        frameLayout.layoutParams = layoutParams
        frameLayout.requestLayout()

        if (requestLayoutForConstraintLayout) {
            constraintLayout?.requestLayout()
        }
    }
}