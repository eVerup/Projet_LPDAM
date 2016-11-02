package com.example.lucasabadie.projetandroidtp;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class SelectorFragment extends Fragment {

    private static final String TAG = "SelectorFragment";

    private View v;

    private Drawable drawableTest;
    private ColorFilter colorFilterGenerator;

    private ImageView imgCamaro;
    private ImageView imgTruck;
    private ImageView imgBeetle;
    private ImageView imgRollsRoyce;

    private Bitmap bitmapCamaro;
    private Bitmap bitmapTruck;
    private Bitmap bitmapBeetle;
    private Bitmap bitmapRollsRoyce;

    private Button colorBlack;
    private Button colorBlue;
    private Button colorGreen;
    private Button colorRed;

    private TextView np;
    private SeekBar seekBar;

    private Bitmap object;
    private String color;
    private int number;
    private int speed;
    private int seekBarMax = 30;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_selector, container, false);

        object = bitmapCamaro;
        color = "#000000";
        number = 1;
        speed = 0;

        // Get the widgets reference from XML layout
        imgCamaro = (ImageView) v.findViewById(R.id.iCamaro);
        imgTruck = (ImageView) v.findViewById(R.id.iTruck);
        imgBeetle = (ImageView) v.findViewById(R.id.iBeetle);
        imgRollsRoyce = (ImageView) v.findViewById(R.id.iRollsRoyce);


        // Get the bitmap from drawable resources
        bitmapCamaro = BitmapFactory.decodeResource(getResources(),R.drawable.ic_camaro);
        bitmapTruck = BitmapFactory.decodeResource(getResources(),R.drawable.ic_delivery_truck_front);
        bitmapBeetle = BitmapFactory.decodeResource(getResources(),R.drawable.ic_beetle_car_front);
        bitmapRollsRoyce = BitmapFactory.decodeResource(getResources(),R.drawable.ic_rolls_royce_luxury_car_front);


        imgCamaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choisirObjet(1);
            }
        });
        imgTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choisirObjet(2);
            }
        });
        imgBeetle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choisirObjet(3);
            }
        });
        imgRollsRoyce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choisirObjet(4);
            }
        });


        // Get the widgets reference from XML layout
        colorBlack = (Button) v.findViewById(R.id.bColorBlack);
        drawableTest = getResources().getDrawable(R.drawable.roundbutton);
        colorBlack.setBackground(drawableTest);
        colorBlack.getBackground().setTint(Color.parseColor("#000000"));
        colorBlue = (Button) v.findViewById(R.id.bColorBlue);
        colorGreen = (Button) v.findViewById(R.id.bColorGreen);
        colorRed = (Button) v.findViewById(R.id.bColorRed);

        colorBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                color = "#000000";

                // Convert the Button to a rounded corners button
                colorBlack.setBackground(drawableTest);
                colorBlack.getBackground().setTint(Color.parseColor("#000000"));
                colorBlue.setBackgroundColor(Color.parseColor("#1e76ea"));
                colorGreen.setBackgroundColor(Color.parseColor("#38cd0b"));
                colorRed.setBackgroundColor(Color.parseColor("#ff0004"));
                mListener.onAction(object, color, number, speed);
            }
        });
        colorBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                color = "#1e76ea";

                // Convert the Button to a rounded corners button
                colorBlack.setBackgroundColor(Color.parseColor("#000000"));
                colorBlue.setBackground(drawableTest);
                colorBlue.getBackground().setTint(Color.parseColor("#1e76ea"));
                colorGreen.setBackgroundColor(Color.parseColor("#38cd0b"));
                colorRed.setBackgroundColor(Color.parseColor("#ff0004"));
                mListener.onAction(object, color, number, speed);
            }
        });
        colorGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                color = "#38cd0b";

                // Convert the Button to a rounded corners button
                colorBlack.setBackgroundColor(Color.parseColor("#000000"));
                colorBlue.setBackgroundColor(Color.parseColor("#1e76ea"));
                colorGreen.setBackground(drawableTest);
                colorGreen.getBackground().setTint(Color.parseColor("#38cd0b"));
                colorRed.setBackgroundColor(Color.parseColor("#ff0004"));
                mListener.onAction(object, color, number, speed);
            }
        });
        colorRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                color = "#ff0004";

                // Convert the Button to a rounded corners button
                colorBlack.setBackgroundColor(Color.parseColor("#000000"));
                colorBlue.setBackgroundColor(Color.parseColor("#1e76ea"));
                colorGreen.setBackgroundColor(Color.parseColor("#38cd0b"));
                colorRed.setBackground(drawableTest);
                colorRed.getBackground().setTint(Color.parseColor("#ff0004"));
                mListener.onAction(object, color, number, speed);
            }
        });

        np = (TextView)v.findViewById(R.id.NumberPickerText);
        number = Integer.parseInt(np.getText().toString());

        Button buttonMinus = (Button) v.findViewById(R.id.bMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: buttonMinus pushed.");
                if(number > 1){
                    number--;
                }
                else{
                    number = 1;
                }
                Log.d(TAG,"onClick of buttonMinus: np = " + number +".");
                np.setText(String.valueOf(number));
            }
        });

        Button buttonPlus = (Button) v.findViewById(R.id.bPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: buttonPlus pushed.");
                if(number < 10){
                    number++;
                }
                else{
                    number = 10;
                }
                Log.d(TAG,"onClick of buttonPlus: np = " + number +".");
                np.setText(String.valueOf(number));
            }
        });

        Log.d(TAG,"onCreateView: np = " + number +".");

        np.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                mListener.onAction(object, color, number, speed);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        seekBar = (SeekBar) v.findViewById(R.id.seekBar);
        seekBar.setMax(seekBarMax);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                speed = progress;

                ((TextView)v.findViewById(R.id.SeekBarText)).setText("Speed : " + progress);

                mListener.onAction(object, color, number, speed);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        return v;
    }

    private void choisirObjet( int i ) {
        imgCamaro.setBackgroundResource(R.drawable.none);
        imgTruck.setBackgroundResource(R.drawable.none);
        imgBeetle.setBackgroundResource(R.drawable.none);
        imgRollsRoyce.setBackgroundResource(R.drawable.none);

        switch( i ) {
            case 1: {
                object = bitmapCamaro;

                imgCamaro.setBackgroundResource(R.drawable.roundbutton);

                break;
            }

            case 2: {
                object = bitmapTruck;

                imgTruck.setBackgroundResource(R.drawable.roundbutton);

                break;
            }

            case 3: {
                object = bitmapBeetle;

                imgBeetle.setBackgroundResource(R.drawable.roundbutton);

                break;
            }

            case 4: {
                object = bitmapRollsRoyce;

                imgRollsRoyce.setBackgroundResource(R.drawable.roundbutton);

                break;
            }
        }

        mListener.onAction(object, color, number, speed);
    }

    public interface OnActionListener {
        void onAction(Bitmap object, String color, int numObject, int speed);
    }

    OnActionListener mListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnActionListener");
        }
    }
}
