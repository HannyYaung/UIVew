package com.hanny.uiview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ShaderView extends View {

    private Paint paint;

    public ShaderView(Context context) {
        this(context, null);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawShaderLine(canvas);
//        drawRadiaGradient(canvas);
//        drawSweepGradient(canvas);
//        drawBitmapShader(canvas);
        drawComposeShader(canvas);
    }


    //线性渐变
    private void drawShaderLine(Canvas canvas) {
        //起点位置(100,300) 到终点位置(500,300)线性渐变 最后一个参数,端点范围之外的着色模式
        //CLAMP 端点之外延续 REPEAT 重复 MIRROR 镜像
        Shader shader = new LinearGradient(100, 300, 500, 300, Color.parseColor("#0094ff"),
                Color.parseColor("#ff0000"), Shader.TileMode.MIRROR);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }

    //辐射渐变
    private void drawRadiaGradient(Canvas canvas) {
        //从中心向周围辐射状的渐变
        Shader shader = new RadialGradient(500, 500, 200, Color.parseColor("#0094ff")
                , Color.parseColor("#ff0000"), Shader.TileMode.MIRROR);
        paint.setShader(shader);
        canvas.drawCircle(500, 500, 300, paint);
    }

    //扫描渐变
    private void drawSweepGradient(Canvas canvas) {
        Shader shader = new SweepGradient(300, 300, Color.parseColor("#0094ff"), Color.parseColor("#ff0000"));
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }

    //用图片来着色
    private void drawBitmapShader(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }

    //混合着色
    private void drawComposeShader(Canvas canvas) {
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.meizi);
        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.DST_IN);
        paint.setShader(shader);

        canvas.drawCircle(300, 300, 300, paint);

    }
}
