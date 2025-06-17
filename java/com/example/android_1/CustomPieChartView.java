package com.example.android_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomPieChartView extends View {

    private Paint slicePaint, textPaint;


    private int protein, carbs, fats, fiber;

    public CustomPieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        slicePaint = new Paint();
        slicePaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 50;

        float total = protein + carbs + fats + fiber;
        if (total == 0) return;

        float[] percentages = {protein / total, carbs / total, fats / total, fiber / total};
        float startAngle = 0;
        int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        for (int i = 0; i < percentages.length; i++) {
            float sweepAngle = percentages[i] * 360;
            slicePaint.setColor(colors[i]);
            canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius,
                    startAngle, sweepAngle, true, slicePaint);
            startAngle += sweepAngle;
        }

        canvas.drawText("Protein: " + protein, centerX - radius, centerY - radius + 50, textPaint);
        canvas.drawText("Carbs: " + carbs, centerX - radius, centerY - radius + 100, textPaint);
        canvas.drawText("Fats: " + fats, centerX - radius, centerY - radius + 150, textPaint);
        canvas.drawText("Fiber: " + fiber, centerX - radius, centerY - radius + 200, textPaint);
    }

    public void updatePieChart(int protein, int carbs, int fats, int fiber) {
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.fiber = fiber;
        invalidate();
    }
}