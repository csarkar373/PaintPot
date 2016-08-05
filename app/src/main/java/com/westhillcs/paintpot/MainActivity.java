package com.westhillcs.paintpot;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private PaintPotView v_drawingPad;
    private Button b_red, b_blue, b_green; // color buttons
    private Button b_reset, b_dotSizePlus, b_dotSizeMinus; // control buttons
    private TextView tv_dotSize;
    private static final int DOT_SIZE_INCREMENT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    private void init() {
        // associate java variables with layout variables
        b_red = (Button)findViewById(R.id.red_b);
        b_blue = (Button)findViewById(R.id.blue_b);
        b_green = (Button)findViewById(R.id.green_b);
        b_reset= (Button)findViewById(R.id.reset_b);
        b_dotSizePlus = (Button)findViewById(R.id.dotSizePlus_b);
        b_dotSizeMinus = (Button)findViewById(R.id.dotSizeMinus_b);

        // define OnClickListeners
        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_reset.setOnClickListener(this);
        b_dotSizePlus.setOnClickListener(this);
        b_dotSizeMinus.setOnClickListener(this);

        v_drawingPad = (PaintPotView)findViewById(R.id.drawingPad_v);
        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        tv_dotSize.setText("DOT SIZE =" + v_drawingPad.getDotSize());
    }


    @Override
    public void onClick(View view) {

        Button _b  = (Button)findViewById(view.getId());

        switch (view.getId()) {
            case R.id.red_b: v_drawingPad.setPenColor(Color.RED);
                Log.d("Button Pressed: ", _b.getText() + ""); // debug
                break;
            case R.id.blue_b: v_drawingPad.setPenColor(Color.BLUE);
                Log.d("Button Pressed: ", _b.getText() + ""); // debug
                break;
            case R.id.green_b: v_drawingPad.setPenColor(Color.GREEN);
                Log.d("Button Pressed: ", _b.getText() + ""); // debug
                break;
            case R.id.reset_b: v_drawingPad.reset();
                tv_dotSize.setText("DOT SIZE = " + v_drawingPad.getDotSize());
                Log.d("Button Pressed: ", _b.getText() + ""); // debug
                break;
            case R.id.dotSizePlus_b: v_drawingPad.changeDotSize(+DOT_SIZE_INCREMENT);
                tv_dotSize.setText("DOT SIZE = " + v_drawingPad.getDotSize());
                Log.d("Button Pressed: ", _b.getText() + ""); // debug
                break;
            case R.id.dotSizeMinus_b:v_drawingPad.changeDotSize(-DOT_SIZE_INCREMENT);
                tv_dotSize.setText("DOT SIZE = " + v_drawingPad.getDotSize());
                Log.d("Button Pressed: ", _b.getText() + ""); // debug
                break;
        }




    }
}















