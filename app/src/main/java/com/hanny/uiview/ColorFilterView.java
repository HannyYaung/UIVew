package com.hanny.uiview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ColorFilterView extends View {

    private Paint paint;

    public ColorFilterView(Context context) {
        this(context, null);
    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawLightFilter(canvas);
//        drawProterDuffColorFilter(canvas);
        drawColorMatrixColorFilter(canvas);
    }

    private void drawLightFilter(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
        ColorFilter colorFilter = new LightingColorFilter(0xffffff, 0xffff00);
        paint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
    }

    private void drawProterDuffColorFilter(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
        ColorFilter colorFilter = new PorterDuffColorFilter(Color.parseColor("#ff00ff"), PorterDuff.Mode.DST_OUT);
        paint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
    }

    private void drawColorMatrixColorFilter(Canvas canvas) {
        //https://github.com/chengdazhi/StyleImageView
    }
}
