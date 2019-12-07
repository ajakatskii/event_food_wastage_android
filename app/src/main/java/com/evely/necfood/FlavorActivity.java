package com.evely.necfood;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.SparseIntArray;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

public class FlavorActivity extends AppCompatActivity {

    private RadarChart mChart;
    private Typeface mTfLight;
    private SparseIntArray factors = new SparseIntArray(5);
    private SparseIntArray scores = new SparseIntArray(5);
    private ArrayList<RadarEntry> entries = new ArrayList<>();
    private ArrayList<IRadarDataSet> dataSets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavor);

        this.loadRadar();
        this.loadDataSuccess();
    }

    protected void loadRadar() {
        factors.append(1, R.string.salty);
        factors.append(2, R.string.spice);
        factors.append(3, R.string.bitter);
        factors.append(4, R.string.sweet);
        factors.append(5, R.string.sour);

        mTfLight = Typeface.SANS_SERIF; //Typeface.createFromAsset(this.getAssets(), "OpenSans-Light.ttf");

        mChart = (RadarChart) this.findViewById(R.id.chart);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setXOffset(0f);
        xAxis.setYOffset(0f);
        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(8f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter() {

            private String[] mFactors = new String[]{getString(factors.get(1)), getString(factors.get(2)),
                    getString(factors.get(3)), getString(factors.get(4)), getString(factors.get(5))};

            @Override
            public String getFormattedValue(float value) {
                return mFactors[(int) value % mFactors.length];
            }

//            @Override
//            public int getDecimalDigits() {
//                return 0;
//            }
        });

        YAxis yAxis = mChart.getYAxis();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(50f);
        yAxis.setTypeface(mTfLight);
        yAxis.setTextSize(9f);
        yAxis.setLabelCount(5, false);
        yAxis.setDrawLabels(false);

        mChart.getLegend().setEnabled(false);
        mChart.getDescription().setEnabled(false);
        mChart.animateXY(
                1400, 1400,
                Easing.EaseInOutQuad,
                Easing.EaseInOutQuad);

    }

    protected void loadDataSuccess() {
        scores.clear();
        scores.append(1, 18);
        scores.append(2, 26);
        scores.append(3, 35);
        scores.append(4, 40);
        scores.append(5, 48);
        drawChart();
    }

    private void drawChart() {

        entries.clear();

        for (int i = 1; i <= 5; i++) {
            entries.add(new RadarEntry(scores.get(i)));
        }

        RadarDataSet dataSet = new RadarDataSet(entries, "");
        dataSet.setColor(R.color.colorPrimary);
        dataSet.setDrawFilled(true);

        dataSets.add(dataSet);

        RadarData data = new RadarData(dataSets);
        data.setValueTypeface(mTfLight);
        data.setValueTextSize(8f);

//        data.setValueFormatter(new IValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
//                return String.valueOf((int) value);
//            }
//
//        });

        mChart.setData(data);
        mChart.invalidate();
    }
}
