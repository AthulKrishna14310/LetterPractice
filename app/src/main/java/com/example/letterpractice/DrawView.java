package com.example.letterpractice;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DrawView extends android.support.v7.widget.AppCompatImageView {

    public ViewGroup.LayoutParams params;
    private Path path=new Path();
    private Paint brush=new Paint();
    private Bitmap bitmap;
    private int touched=0;
    private int total=0;
    private boolean outIndex=false;
    private ArrayList<Integer> pixels=new ArrayList<>();
    private int totalCoordinates=0;
    private boolean index=false;
    public int wrong=0;

    public int count=0;

    public ArrayList<Integer> getPixels() {
        return pixels;
    }

    public void setPixels(ArrayList<Integer> pixels) {
        this.pixels = pixels;
    }

    public DrawView(Context context) {
        super(context);

        brush.setAntiAlias(true);
        brush.setColor(Color.GREEN);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(15f);

        this.setDrawingCacheEnabled(true);
        this.buildDrawingCache(true);

        params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);



    }


    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        brush.setAntiAlias(true);
        brush.setColor(Color.GREEN);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(15f);
        this.setDrawingCacheEnabled(true);
        this.buildDrawingCache(true);

    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        brush.setAntiAlias(true);
        brush.setColor(Color.GREEN);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(15f);

        this.setDrawingCacheEnabled(true);
        this.buildDrawingCache(true);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX=event.getX();
        float pointY=event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX,pointY);
                return true;

            case MotionEvent.ACTION_MOVE:
                bitmap=this.getDrawingCache();

                if((int)event.getX()>0&&(int)event.getY()>0&&(int)event.getY()<bitmap.getHeight()
                &&(int)event.getX()<bitmap.getWidth()) {

                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    pixels.add((int) event.getX()+(int) event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    total++;

                    if(r==0&&g==0&&b==0){
                        outIndex=false;
                        touched++;
                        index=false;
                    }

                    if((r==255&&g==255&&b==255)){
                        index=false;
                    }
                    else if((r==255&&g==255&&b==255)||(r==255&&g==0&&b==0)){
                        outIndex=true;
                        wrong++;
                   }
                    else if(r==0&&g==255&&b==0){
                        index=false;
                    }

                    else if(r==255&&g==0&&b==255){
                        if(!index) {
                            count++;
                            index=true;
                        }

                    }

                    else
                        {
                        }
                    path.lineTo(pointX, pointY);
                }
                break;
            default:
                return false;

        }
        postInvalidate();
        return false;

    }

    public boolean isOutIndex() {
        return outIndex;
    }

    public void setOutIndex(boolean outIndex) {
        this.outIndex = outIndex;
    }

    @Override
    protected void onDraw(Canvas canvas) {
          canvas.drawPath(path,brush);

         }

    public int getTouched() {
        return touched;

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTouched(int touched) {
        this.touched = touched;
    }


}
