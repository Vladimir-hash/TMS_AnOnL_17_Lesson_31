package com.example.lesson_31

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator

class PageIndicatorView @JvmOverloads constructor(
        context: Context,
        attr: AttributeSet? = null,
        defStyleAttribute: Int = 0,
        defStyleRes: Int = 0,
    ): View(context, attr, defStyleAttribute, defStyleRes) {

        private val typedArray = context.obtainStyledAttributes(R.styleable.IndicatorView)
        private val count = typedArray.getInt(R.styleable.IndicatorView_piv_count, 0)

        init{
            typedArray.recycle()
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 100
        val desiredHeight = 100
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        //Measure Width
        val width = if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            widthSize
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            Math.min(desiredWidth, widthSize)
        } else {
            //Be whatever you want
            desiredWidth
        }

        //Measure Height
        val height = if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            heightSize
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            Math.min(desiredHeight, heightSize)
        } else {
            //Be whatever you want
            desiredHeight
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }


        private val paint = Paint().also {
            it.color = Color.BLUE
            it.strokeWidth = 10F
        }
        private var radiusRatio = 1F


        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val x = width / 2F
            val y = height / 2F
            val radius = minOf(width, height) / 2F

            paint.color = Color.parseColor( "#FF00FF")
            canvas.drawCircle(x, y , radius, paint)
        }

        fun startAnimation() {
            var width: Int
            val animator = ValueAnimator.ofFloat(1F, 0.5F)
            animator.duration = 5000
            animator.interpolator = DecelerateInterpolator()
            animator.addUpdateListener { animation ->
                radiusRatio = animation.animatedValue as Float
            }
        }


    }
