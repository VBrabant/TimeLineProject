package com.example.timeline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.timeline.R;

public class BulletView extends View {

    private int bulletCol, labelCol;
    private String bulletText;
    private Paint bulletPaint;

    public BulletView(Context context) {
        super(context);
    }

    public BulletView(Context context, int squareCol, int labelCol, String squareText) {
        super(context);

        bulletPaint = new Paint();

        this.bulletCol = squareCol;
        this.labelCol = labelCol;
        this.bulletText = squareText;

    }

    public BulletView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bulletPaint = new Paint();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.BulletView, 0, 0);

        try {
            //get the text and colors specified using the names in attrs.xml
            bulletText = a.getString(R.styleable.BulletView_squareLabel);
            bulletCol = a.getInteger(R.styleable.BulletView_squareColor, 0);//0 is default
            labelCol = a.getInteger(R.styleable.BulletView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //draw the View
        //get half of the width and height as we are working with a circle
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;

        //get the radius as half of the width or height, whichever is smaller
        //subtract ten so that it has some space around it
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf;
        else
            radius=viewWidthHalf;

        bulletPaint.setStyle(Paint.Style.FILL);
        bulletPaint.setAntiAlias(true);

        //set the paint color using the circle color specified
        bulletPaint.setColor(bulletCol);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, bulletPaint);

        //set the text color using the color specified
        bulletPaint.setColor(labelCol);

        //set text properties
        bulletPaint.setTextAlign(Paint.Align.CENTER);
        bulletPaint.setTextSize(30);

        //draw the text using the string attribute and chosen properties
        canvas.drawText(bulletText, viewWidthHalf, viewHeightHalf, bulletPaint);
    }

    public void setBulletText(String bulletText) {
        this.bulletText = bulletText;
        invalidate();
        requestLayout();
    }
}
