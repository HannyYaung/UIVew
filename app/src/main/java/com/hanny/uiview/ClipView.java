package com.hanny.uiview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class ClipView extends View {

    private Paint paint;
    private Bitmap bitmap;

    public ClipView(Context context) {
        this(context, null);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawClip(canvas);

//        drawCanvas(canvas);
//        drawMatrix(canvas);

//        drawCamera(canvas);
    }

    private void drawClip(Canvas canvas) {
        canvas.save();
        Path path = new Path();
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        path.addCircle(400, 400, 300, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        canvas.restore();
    }

    private void drawCanvas(Canvas canvas) {
        canvas.save();
        canvas.translate(100, 100);
        canvas.rotate(45);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        canvas.restore();
        //cavas 的方式有很多种，旋转 缩放 ，平移 错切 最重要的是可以进行Matrix 进行变换
    }

    private void drawMatrix(Canvas canvas) {
        canvas.save();

        canvas.restore();
    }

    private void drawCamera(Canvas canvas){
        canvas.save();
        Camera camera  = new Camera();
        camera.save();
        camera.rotateX(30);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap,500,500,paint);
        canvas.restore();
    }
}
