package com.hanny.uiview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class StyleView extends View {

    private Paint paint;

    public StyleView(Context context) {
        this(context, null);
    }

    public StyleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StyleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {

//        drawDither(canvas);

//        drawPathEffect(canvas);

//        drawConorEffect(canvas);
//        drawShadowLayer(canvas);
        drawMaskFilter(canvas);
    }

    private void drawDither(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
        paint.setDither(false);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
    }

    private void drawPathEffect(Canvas canvas) {
        PathEffect pathEffect = new DashPathEffect(new float[]{5, 10}, 10);
        paint.setPathEffect(pathEffect);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(300, 300, 300, paint);
    }

    private void drawConorEffect(Canvas canvas) {
        PathEffect pathEffect = new CornerPathEffect(20);
        paint.setPathEffect(pathEffect);

        Path path = new Path();
        path.moveTo(100, 600);
        path.lineTo(200, 100);
        path.lineTo(300, 700);
        path.lineTo(400, 300);

        canvas.drawPath(path, paint);
    }

    private void drawShadowLayer(Canvas canvas) {
        paint.setShadowLayer(20, 0, 0, Color.RED);
        paint.setTextSize(40);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Hello World", 80, 300, paint);
    }

    private void drawMaskFilter(Canvas canvas) {
       Bitmap bitmap =  BitmapFactory.decodeResource(getResources(),R.drawable.meizi);
        paint.setMaskFilter(new BlurMaskFilter(100, BlurMaskFilter.Blur.INNER));
        canvas.drawBitmap(bitmap,new Matrix(),paint);

        paint.setMaskFilter(new EmbossMaskFilter(new float[]{0,1,1},0.2f,8,10));
        canvas.drawBitmap(bitmap,new Matrix(),paint);
    }
}
