package com.example.lesson_31

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class BannerView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttribute: Int = 0,
    defStyleRes: Int = 0,
): ConstraintLayout(context, attr, defStyleAttribute, defStyleRes) {

    private val message: TextView
    private val acceptText: TextView
    private val denyText: TextView


    init{
        LayoutInflater.from(context).inflate(R.layout.banner_view, this, true)
        message = findViewById<TextView>(R.id.message)
        acceptText = findViewById<TextView>(R.id.accept_text)
        denyText = findViewById<TextView>(R.id.deny_text)
    }
//    fun setOnAcceptOnClickLIstener
}