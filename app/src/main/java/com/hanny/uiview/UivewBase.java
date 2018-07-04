package com.hanny.uiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class UivewBase extends View {

    private Paint paint;

    public UivewBase(Context context) {
        this(context, null);
    }

    public UivewBase(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UivewBase(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBg(canvas);
        drawCircle(canvas);
        drawRect(canvas);
        drawPoint(canvas);
        drawOval(canvas);
        drawLine(canvas);
        drawRountRect(canvas);
        drawArc(canvas);
    }




    //画背景颜色
    private void drawBg(Canvas canvas) {
        canvas.drawColor(Color.BLACK); //纯黑色
        canvas.drawColor(Color.parseColor("#88880000"));//半透明颜色
        canvas.drawRGB(125, 200, 100); //设置RGB
        canvas.drawARGB(100, 255, 0, 0);
    }

    //画圆
    private void drawCircle(Canvas canvas) {
        paint.setColor(Color.RED);
        //默认实心圆
        canvas.drawCircle(300, 200, 200, paint);
        //画空心圆
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);//设置线条宽度
        paint.setAntiAlias(true);//设置抗锯齿,也可以在new Paint() 的时候加上一个 ANTI_ALIAS_FLAG 参数就行
        canvas.drawCircle(400, 400, 200, paint);
    }

    //画矩形
    private void drawRect(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(100, 100, 200, 200, paint);
    }

    //画原点
    private void drawPoint(Canvas canvas) {
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.SQUARE);//点的样式，圆形，方形
        canvas.drawPoint(500, 500, paint);

        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                8 /* 一共绘制 8 个数（4 个点）*/, paint);
    }

    //画椭圆
    private void drawOval(Canvas canvas) {
        canvas.drawOval(200, 300, 700, 500, paint);
    }

    //画线
    private void drawLine(Canvas canvas) {
        canvas.drawLine(0, 0, 500, 500, paint);
        float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
        canvas.drawLines(points, paint);
    }

    //画圆角矩形
    private void drawRountRect(Canvas canvas) {
        canvas.drawRoundRect(300, 400, 500, 700, 50, 50, paint);
    }
    //绘制圆弧和扇形
    private void drawArc(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(300,300,650,800,0,120,false,paint);
    }
}
