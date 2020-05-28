package rs.raf.vezbe12.presentation.view.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import rs.raf.vezbe12.R
import rs.raf.vezbe12.extensions.toPx
import timber.log.Timber

class SquareView : View {
    constructor(context: Context)
            : super(context)
    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    private var rect: Rect = Rect()
    private var paint: Paint = Paint()
    private val redStrokePaint: Paint = Paint().also {
        it.isAntiAlias = true
        it.color = ContextCompat.getColor(context, R.color.red)
        it.style = Paint.Style.STROKE
        it.strokeWidth = 4.toPx().toFloat()
    }
    private val blueFillPaint: Paint = Paint().also {
        it.isAntiAlias = true
        it.color = ContextCompat.getColor(context, R.color.blue)
        it.style = Paint.Style.FILL
    }

    var heightDivider = 1

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Timber.e("On measure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Timber.e("On layout")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Timber.e("On draw")

        // Set dimensions of the first shape to be drawn
        val left = 0
        val top = 0
        val bottom = height / heightDivider
        val right = width / 2
        rect.set(left, top, right, bottom)
        //Draw it with blue paint (fill)
        canvas?.drawRect(rect, blueFillPaint)
        //Draw it with red paint (only stroke)
        canvas?.drawRect(rect, redStrokePaint)

        // Set dimensions of the second shape to be drawn
        val left2 = right
        val top2 = top
        val bottom2 = bottom
        val right2 = width
        rect.set(left2, top2, right2, bottom2)
        //Draw it with blue paint (fill)
        canvas?.drawRect(rect, blueFillPaint)
        //Draw it with red paint (only stroke)
        canvas?.drawRect(rect, redStrokePaint)
    }
}