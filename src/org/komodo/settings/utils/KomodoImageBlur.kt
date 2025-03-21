package org.komodo.settings.utils

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.RenderEffect
import android.graphics.Shader
import android.util.AttributeSet
import android.widget.ImageView

class KomodoImageBlur : ImageView {

    companion object {
        private const val BLUR_RADIUS = 8f
        private const val COLOR_FILTER_HEX = "#55000000"
    }

    constructor(context: Context) : super(context) {
        applyBlurEffect()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyBlurEffect()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        applyBlurEffect()
    }

    private fun applyBlurEffect() {
        val blurEffect = RenderEffect.createBlurEffect(BLUR_RADIUS, BLUR_RADIUS, Shader.TileMode.CLAMP)
        setRenderEffect(blurEffect)
        setColorFilter(Color.parseColor(COLOR_FILTER_HEX), PorterDuff.Mode.SRC_OVER)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        applyBlurEffect()
    }
}