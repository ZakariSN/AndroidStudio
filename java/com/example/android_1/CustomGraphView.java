package com.example.android_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CustomGraphView extends View {

    private List<Integer> stepEntries = new ArrayList<>();
    private Paint linePaint, pointPaint, textPaint;

    public CustomGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(5);

        pointPaint = new Paint();
        pointPaint.setColor(Color.BLUE);
        pointPaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();


        canvas.drawLine(100, height - 100, width - 100, height - 100, linePaint);
        canvas.drawLine(100, height - 100, 100, 100, linePaint);


        if (stepEntries != null && !stepEntries.isEmpty()) {
            int maxSteps = 100000;
            float scaleX = (float) (width - 200) / stepEntries.size();
            float scaleY = (float) (height - 200) / maxSteps;

            for (int i = 0; i < stepEntries.size(); i++) {
                float x = 100 + i * scaleX;
                float y = height - 100 - (stepEntries.get(i) * scaleY);

                canvas.drawCircle(x, y, 10, pointPaint);
                if (i > 0) {
                    float prevX = 100 + (i - 1) * scaleX;
                    float prevY = height - 100 - (stepEntries.get(i - 1) * scaleY);
                    canvas.drawLine(prevX, prevY, x, y, linePaint);
                }
            }

            canvas.drawText("Steps Progress", 100, 100, textPaint);
        }
    }

    public void updateGraph(List<Integer> stepEntries) {
        this.stepEntries = stepEntries;
        invalidate();
    }
}