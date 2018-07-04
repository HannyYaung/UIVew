package com.hanny.uiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PathView extends View {

    private Paint paint;
    private Path path;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        pathCircle(canvas);
//        pathLine(canvas);
        pathArc(canvas);
    }


    //添加子图形
    private void pathCircle(Canvas canvas) {
        paint.setAntiAlias(true);
        path.addCircle(300, 300, 200, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    //画线
    private void pathLine(Canvas canvas) {
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        //相对原点
        path.lineTo(100, 100);
        //相对当前的位置relatively
        path.rLineTo(100, 0);
        canvas.drawPath(path, paint);
    }

    //画弧
    private void pathArc(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        path.lineTo(100, 100);
        // 强制移动到弧形起点（无痕迹）
        path.arcTo(100, 100, 300, 300, 0, 359, true);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        path.lineTo(100, 100);
        path.arcTo(100, 100, 300, 300, -90, 90, false); // 直接连线连到弧形起点（有痕迹）
        canvas.drawPath(path, paint);
    }
}
