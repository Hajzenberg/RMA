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

        val left = 0
        val top = 0
        val bottom = height
        val right = width

        // Set dimensions of a shape to be drawn
        rect.set(left, top, right, bottom)

        // Set color of a shape
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.color = ContextCompat.getColor(context, R.color.blue)
        paint.strokeWidth = 4.toPx().toFloat()

        canvas?.drawRect(rect, paint)

        paint.color = ContextCompat.getColor(context, R.color.red)
        paint.style = Paint.Style.STROKE

        canvas?.drawRect(rect, paint)

    }
}