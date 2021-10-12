package com.example.tcamera.button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView  extends View {
    private Paint mPaint;

    //在代码中定义和使用时用到的
    public CanvasView(Context context) {
        super(context);
        init();
    }

    //在xml中定义我们的自定义属性时用到
    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //在构造函数中初始化画笔
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px
    }
    //在View中画出我们需要的内容
    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(0xff8bc5ba);
        mPaint.setAntiAlias(true);  //设置画笔为抗锯齿模式，不然画出来太丑了
        mPaint.setStyle(Paint.Style.FILL);//默认绘图为填充模式
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int halfCanvasWidth = canvasWidth / 2;
        int halfCanvasHeight = canvasHeight / 2;
        int R = canvasHeight/4;

//        // 绘制一个矩形的内切椭圆
//        RectF rectF = new RectF(100, 10, 370, 150);
//        canvas.drawOval(rectF, mPaint);


//        //通过绘制两个圆形成圆环
//        //1. 首先绘制大圆
//        canvas.drawCircle(halfCanvasWidth, 450, R, mPaint);
//        //2. 然后绘制小圆，让小圆覆盖大圆，形成圆环效果
//        int r = (int) (R * 0.75);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawCircle(halfCanvasWidth, 450, r, mPaint);
//
        // 绘制一个圆心坐标在(halfCanvasWidth,250)，半径为R 的圆
        Paint mPaint1=new Paint();
        mPaint1.setColor(Color.GRAY);
        canvas.drawCircle(halfCanvasWidth, halfCanvasHeight, R, mPaint1);

//        //通过画笔的描边绘图模式绘制圆环
//        mPaint.setColor(0xff8bc5ba);//设置颜色
//        mPaint.setStyle(Paint.Style.STROKE);//绘图为描边模式
//        float strokeWidth = (float) (R * 0.15); //设置线条宽度
//        mPaint.setStrokeWidth(strokeWidth);
//        canvas.drawCircle(halfCanvasWidth, 650, R, mPaint);
    }
}
