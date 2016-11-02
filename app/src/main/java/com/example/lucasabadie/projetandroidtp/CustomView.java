package com.example.lucasabadie.projetandroidtp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lucas Abadie on 31/10/2016.
 */
public class CustomView extends View {

    private Paint paint;

    public CustomView (Context context) {
        super(context);
        init();
    }


    public CustomView (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init () {
        paint = new Paint();
        paint.setTextSize(25);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // dessiner
        canvas.drawText(
                "New Text", 0, 0, paint);
    }
}
