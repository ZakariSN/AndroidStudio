package com.example.android_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class CustomBarChartView extends View {

    private Paint barPaint, axisPaint, textPaint;
    private List<String> workoutHistory;

    public CustomBarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        barPaint = new Paint();
        barPaint.setColor(Color.BLUE);
        barPaint.setStyle(Paint.Style.FILL);

        axisPaint = new Paint();
        axisPaint.setColor(Color.BLACK);
        axisPaint.setStrokeWidth(5);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();


        canvas.drawLine(100, height - 100, width - 100, height - 100, axisPaint);
        canvas.drawLine(100, height - 100, 100, 100, axisPaint);


        if (workoutHistory != null && !workoutHistory.isEmpty()) {
            int barWidth = (width - 200) / workoutHistory.size();

            for (int i = 0; i < workoutHistory.size(); i++) {
                int left = 100 + i * barWidth;
                int right = left + barWidth - 10;
                int top = height - 100 - (i + 1) * 50;

                canvas.drawRect(left, top, right, height - 100, barPaint);
                canvas.drawText("W" + (i + 1), left + 10, top - 10, textPaint);
            }
        }
    }

    public void updateBarChart(List<String> workoutHistory) {
        this.workoutHistory = workoutHistory;
        invalidate();
    }
}