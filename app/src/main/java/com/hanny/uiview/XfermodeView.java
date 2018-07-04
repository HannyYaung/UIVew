package com.hanny.uiview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class XfermodeView extends View{
    public XfermodeView(Context context) {
        this(context,null);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
