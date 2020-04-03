package com.example.imdmainactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {
    private LineChart mChart;
    ArrayList<Entry> x;
    ArrayList<String> y;
    ArrayList<Entry> z;

    private DrawerLayout mNavDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);

        x = new ArrayList<Entry>();
        y = new ArrayList<String>();
        z = new ArrayList<Entry>();


        mChart = (LineChart) findViewById(R.id.lineChart);


        mChart.setDrawGridBackground(true);
        mChart.setTouchEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setHorizontalScrollBarEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setPinchZoom(false);
        mChart.getXAxis().setTextSize(6f);
        mChart.setDescription("");
        mChart.getAxisLeft().setTextSize(12f);

        //   mChart.getXAxis().setDrawGridLines(false);
//        mChart.setMarkerView(mv);

        mChart.setBackgroundColor(Color.rgb(247, 250, 255));

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setEnabled(true);
        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);

        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        l.setEnabled(true);

        //   mChart.getXAxis().setDrawLabels(false);

        x.add(new Entry((35), 0));

        x.add(new Entry((33), 1));

        x.add(new Entry((40), 2));


        x.add(new Entry(51, 3));


        x.add(new Entry(23, 4));


        x.add(new Entry(35, 5));


        y.add(new String("18-03-2018"));
        y.add(new String("19-03-2018"));
        y.add(new String("20-03-2018"));
        y.add(new String("21-03-2018"));
        y.add(new String("22-03-2018"));
        y.add(new String("23-03-2018"));


        LineDataSet set1 = new LineDataSet(x, "Temperature");
        set1.setColors(ColorTemplate.COLORFUL_COLORS);
        set1.setLineWidth(2.0f);
        set1.setCircleColor(Color.BLACK);
        set1.setValueTextSize(9);
        LineData data = new LineData(y, set1);
        mChart.setData(data);
        mChart.invalidate();



        /*Navigation Bar and Tool Bar*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mNavDrawer = findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this
                , mNavDrawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mNavDrawer.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public void onBackPressed() {

        if (mNavDrawer.isDrawerOpen(GravityCompat.START)) {
            mNavDrawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.add){
          /*  Intent i =new Intent(MainActivity.this,SearchActivity.class);
            startActivity(i);*/

            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}