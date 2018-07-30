package com.example.root.testapplicationo.customview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class CustomDesign extends View {
    private RectF mRectF;
    private Paint mPaint ;
    private float mIndeterminateSweep;
    private float mstartAngle;
    private int msize;

    /*
    * CustomDesign(Context context)->
    * Called when it is created Programatically (new DualProgressView(this))
    * */
    public CustomDesign(Context context) {
        super(context);
        init();
    }


    // CustomDesign(Context context, AttributeSet attrs) ->
    // Called when view in inflated via XML. param attrs which contain collection of your attributes you passed via XML.

    public CustomDesign(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

  //  CustomDesign(Context context, AttributeSet attrs, int defStyleAttr) ->
    // this invoked manually to apply any default style you want to apply for your widget.

    public CustomDesign(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomDesign(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    //onMeasure is the place you decide how much width and height is needed for your view.
    // If you have multiple child inside your custom view(if you are extending a ViewGroup and building your own layout),
    // you should measure each child width and height using below method.
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    /*int xPad = getPaddingLeft() + getPaddingRight();
        int yPad = getPaddingTop() + getPaddingBottom();
        int width = getMeasuredWidth() - xPad;
        int height = getMeasuredHeight() - yPad;
        mSize = (width < height) ? width : height;
        setMeasuredDimension(mSize + xPad, mSize + yPad);*/
       int xPad = getPaddingLeft() + getPaddingRight();
       int yPad = getPaddingBottom() + getPaddingRight() ;
       int width = getMeasuredWidth() -xPad ;
       int height = getMeasuredHeight() -yPad ;
       msize = (width<height)? width : height ;

       // After that you should call the below method with appropriate width and height considering all the child view (if present) in your CustomView.

        setMeasuredDimension(msize + xPad,msize+yPad);

    }

    //measureChildWithMargins(childView, widthMeasureSpec, 0, heightMeasureSpec, 0);
   // After that you should call the below method with appropriate width and height considering all the child view (if present) in your CustomView.
  /*  int yPad = getPaddingTop() + getPaddingBottom();
    int width = getMeasuredWidth() - xPad;
    int height = getMeasuredHeight() - yPad;
    mSize = (width < height) ? width : height;
    setMeasuredDimension(mSize + xPad, mSize + yPad);*/

  //  onLayout is required when you are going to create a CustomView which also has so many child views.
  // onLayout we set the position of each child based on the width and height calculated in the measuring pass.
  // We don’t need to override this in our case.
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /*
    * Drawing

Lets do the actual work. onDraw(Canvas canvas) is the meat of our rendering code.
if you are extending a View, you are responsible for drawing the View on the Screen.
    */
    // first we will draw rectangle
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8f);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mRectF = new RectF(200,200,800,800);
        mIndeterminateSweep = 10f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
   // canvas.clipRect(10,10,10,0);
    canvas.drawRect(mRectF,mPaint);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    animateArch();

    }

    private void animateArch() {
    final ValueAnimator frontEndExtend = ValueAnimator.ofFloat(0,360);
        frontEndExtend.setDuration(5000);
        frontEndExtend.setInterpolator(new LinearInterpolator());
        frontEndExtend.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mstartAngle = (Float)valueAnimator.getAnimatedValue();
                mIndeterminateSweep += 2;
                if(mIndeterminateSweep >360)
                    mIndeterminateSweep = 15f ;
                invalidate();
            }
        });

        frontEndExtend.start();
        frontEndExtend.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
/*
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }


* */