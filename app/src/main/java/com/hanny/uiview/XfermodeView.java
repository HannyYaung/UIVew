package com.hanny.uiview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class XfermodeView extends View {

    private Paint paint;

    public XfermodeView(Context context) {
        this(context, null);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Bitmap bitmapMeizi = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
        // 指定图片绘制区域(左上角的四分之一)
        Rect src = new Rect(0, 0, bitmapMeizi.getWidth(), bitmapMeizi.getHeight());
        // 指定图片在屏幕上显示的区域
        Rect dst = new Rect(0, 0, 400, 400);
        canvas.drawBitmap(bitmapMeizi, src, dst, paint);

        paint.setXfermode(xfermode);
        Bitmap bitmapBg = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        canvas.drawBitmap(bitmapBg, new Matrix(), paint);
        paint.setXfermode(null);
        canvas.restoreToCount(save);
    }
}
