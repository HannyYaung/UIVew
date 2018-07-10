package com.hanny.uiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditBgView extends EditText{

    public EditBgView(Context context) {
        super(context);
    }

    public EditBgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditBgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        //涂上绿色
        canvas.drawColor(Color.parseColor("#0094ff"));
        super.draw(canvas);
    }
}
