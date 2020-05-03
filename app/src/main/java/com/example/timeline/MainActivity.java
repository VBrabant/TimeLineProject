package com.example.timeline;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.timeline.dto.Event;
import com.example.timeline.view.BulletView;
import com.example.timeline.view.RectangleView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView(getData());

    }

    BulletView createBullet(String label) {
        BulletView myButton = new BulletView(this, R.color.blue, R.color.green, label);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                75,
                75);
        //params.weight = 1.0f;
        myButton.setLayoutParams(params);

        return myButton;
    }

    View createAxis() {
        View myAxis = new View(this);
        myAxis.setBackgroundColor(Color.DKGRAY);
        LinearLayout.LayoutParams params_axis = new LinearLayout.LayoutParams(
                15,
                240);
        //params_axis.weight = 1.0f;
        myAxis.setLayoutParams(params_axis);

        return myAxis;
    }

    void setupView(Event[] events){

        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams params_scroll = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        scrollView.setLayoutParams(params_scroll);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        scrollView.addView(mainLayout);

        View myAxis = null;

        for (Event event : events) {

            String label = "" + event.index;

            BulletView myButton =  createBullet(label);
            myAxis = createAxis();

            mainLayout.addView(myButton);
            mainLayout.addView(myAxis);

        }

        if (myAxis != null) {
            mainLayout.removeView(myAxis);
        }

        TextView textView = new TextView(this);
        textView.setText("prourout");
        mainLayout.addView(textView);

        /*RectangleView rectangleView = new RectangleView(this);
        rectangleView.setRectangleText("Prouuut");
        rectangleView.setBackgroundColor(Color.GREEN);
        LinearLayout.LayoutParams params_rect = new LinearLayout.LayoutParams(
                200,
                200);
        rectangleView.setLayoutParams(params_rect);

        mainLayout.addView(rectangleView);*/

        setContentView(scrollView);
    }

    Event[] getData() {

        Event[] data = new JsonManager().create("tltest.json", getApplicationContext());

        return data;
    }



}
