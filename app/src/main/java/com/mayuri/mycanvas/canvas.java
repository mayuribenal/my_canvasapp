package com.mayuri.mycanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class canvas extends View {
    Paint paint;
    Path path;

    public canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        path = new Path();
        paint.setStrokeWidth(5f);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                path.moveTo(xPos,yPos);
                case MotionEvent.ACTION_DOWN:
                 break;
              case MotionEvent.ACTION_MOVE:
                  path.lineTo(xPos,yPos);
                  break;
            default:
                break;
        }
        invalidate();
        return true;
    }

}
