package rs.raf.vezbe12.presentation.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import rs.raf.vezbe12.R;
import rs.raf.vezbe12.extensions.IntKt;

public class PercentageTextView extends AppCompatTextView {

    private static final int CIRCLE_STROKE_WIDTH_DP = 4;

    // Colors we use for background and foreground circle
    private int mForegroundCircleColor;
    private int mBackgroundCircleColor;
    private float mCircleStrokeWidthInPx;

    // Rectangle which holds dimensions for the circle
    private RectF mRectF;

    // Paint which we use to draw circles
    private Paint mPaint;

    public PercentageTextView(Context context) {
        super(context);
        init(null);
    }

    public PercentageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PercentageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // Extract width and height from MeasureSpec
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        // Take shorter edge, so that we don't end up out off screen in certain cases
        int length = Math.min(width, height);

        // Create new measureSpec with mode EXACTLY
        int newMeasureSpec = MeasureSpec.makeMeasureSpec(length, MeasureSpec.EXACTLY);

        super.onMeasure(newMeasureSpec, newMeasureSpec);
    }

    private void init(AttributeSet attrs) {
        parseAttributes(attrs);
        mRectF = new RectF();
        mPaint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Set coordinates of the area in which we want to draw circles
        // We have to account for the stroke width
        float left = 0 + mCircleStrokeWidthInPx;
        float top = 0 + mCircleStrokeWidthInPx;
        float bottom = getHeight() - mCircleStrokeWidthInPx;
        float right = getWidth() - mCircleStrokeWidthInPx;

        mRectF.set(left, top, right, bottom);

        mPaint.setAntiAlias(true);
        mPaint.setColor(mBackgroundCircleColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mCircleStrokeWidthInPx);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawOval(mRectF, mPaint);

        mPaint.setColor(mForegroundCircleColor);

        float sweepAngle = getSweepAngle();

        canvas.drawArc(mRectF, 270f, sweepAngle, false, mPaint);
    }

    private float getSweepAngle() {
        CharSequence text = getText();
        boolean isNumber = TextUtils.isDigitsOnly(text);
        boolean isEmpty = TextUtils.isEmpty(text);

        if (isEmpty || !isNumber){
            return 0;
        }

        int number = Integer.parseInt(text.toString());
        float angle = (number / 100f) * 360;

        return angle;
    }

    private void parseAttributes(AttributeSet attrs) {

        if (attrs == null) {
            return;
        }

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.PercentageTextView);
        mForegroundCircleColor = typedArray.getColor(R.styleable.PercentageTextView_foregroundCircleColor, 0);
        mBackgroundCircleColor = typedArray.getColor(R.styleable.PercentageTextView_backgroundCircleColor, 0);
        // If user didn't set circle stroke width in XML we want to pass default value
        // We defined it in DP, and we hava to cnvert it to pixels because Canvas works with pixels,
        // not density pixels (DP)
        int defaultValue = IntKt.toPx(CIRCLE_STROKE_WIDTH_DP); //We refer to extension function written in kotlin
        mCircleStrokeWidthInPx = typedArray.getDimensionPixelSize(R.styleable.PercentageTextView_circleStrokeWidth, defaultValue);
        typedArray.recycle();
    }
}
