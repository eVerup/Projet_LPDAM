package com.example.lucasabadie.projetandroidtp;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
<<<<<<< HEAD
import android.graphics.Paint;
=======
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
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

<<<<<<< HEAD

/**
 * A simple {@link Fragment} subclass.
 */
=======
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
public class SelectorFragment extends Fragment {

    private static final String TAG = "SelectorFragment";

    private View v;
<<<<<<< HEAD
    private Resources mResources;
    private Drawable drawableTest;
=======

    private Drawable drawableTest;
    private ColorFilter colorFilterGenerator;
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5

    private ImageView imgCamaro;
    private ImageView imgTruck;
    private ImageView imgBeetle;
    private ImageView imgRollsRoyce;
<<<<<<< HEAD
=======

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
    private Bitmap bitmapCamaro;
    private Bitmap bitmapTruck;
    private Bitmap bitmapBeetle;
    private Bitmap bitmapRollsRoyce;
<<<<<<< HEAD
=======

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
    private Button colorBlack;
    private Button colorBlue;
    private Button colorGreen;
    private Button colorRed;
<<<<<<< HEAD
=======

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
    private TextView np;
    private SeekBar seekBar;

    private Bitmap object;
    private String color;
    private int number;
    private int speed;
<<<<<<< HEAD
    private int seekBarMax = 100;

    public SelectorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_selector, container, false);

        // Get the Resources
        mResources = getResources();
=======
    private int seekBarMax = 30;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_selector, container, false);

        object = bitmapCamaro;
        color = "#000000";
        number = 1;
        speed = 0;
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5

        // Get the widgets reference from XML layout
        imgCamaro = (ImageView) v.findViewById(R.id.iCamaro);
        imgTruck = (ImageView) v.findViewById(R.id.iTruck);
        imgBeetle = (ImageView) v.findViewById(R.id.iBeetle);
        imgRollsRoyce = (ImageView) v.findViewById(R.id.iRollsRoyce);


        // Get the bitmap from drawable resources
<<<<<<< HEAD
        bitmapCamaro = BitmapFactory.decodeResource(mResources,R.drawable.ic_camaro);
        bitmapTruck = BitmapFactory.decodeResource(mResources,R.drawable.ic_delivery_truck_front);
        bitmapBeetle = BitmapFactory.decodeResource(mResources,R.drawable.ic_beetle_car_front);
        bitmapRollsRoyce = BitmapFactory.decodeResource(mResources,R.drawable.ic_rolls_royce_luxury_car_front);

        // Set global variable
        object = bitmapCamaro;
        color = "#000000";
        number = 1;
        speed = 0;

        // Display the bitmap in ImageView
        RoundedBitmapDrawable drawable = createRoundedBitmapDrawableWithBorder(bitmapCamaro);
        imgCamaro.setImageDrawable(drawable);
        imgTruck.setImageBitmap(bitmapTruck);
        imgBeetle.setImageBitmap(bitmapBeetle);
        imgRollsRoyce.setImageBitmap(bitmapRollsRoyce);
=======
        bitmapCamaro = BitmapFactory.decodeResource(getResources(),R.drawable.ic_camaro);
        bitmapTruck = BitmapFactory.decodeResource(getResources(),R.drawable.ic_delivery_truck_front);
        bitmapBeetle = BitmapFactory.decodeResource(getResources(),R.drawable.ic_beetle_car_front);
        bitmapRollsRoyce = BitmapFactory.decodeResource(getResources(),R.drawable.ic_rolls_royce_luxury_car_front);

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5

        imgCamaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD

                object = bitmapCamaro;

                // Convert the ImageView image to a rounded corners image with border
                RoundedBitmapDrawable drawable = createRoundedBitmapDrawableWithBorder(bitmapCamaro);
                // Set the ImageView image as drawable object
                imgCamaro.setImageDrawable(drawable);
                imgTruck.setImageBitmap(bitmapTruck);
                imgBeetle.setImageBitmap(bitmapBeetle);
                imgRollsRoyce.setImageBitmap(bitmapRollsRoyce);
                mListener.onAction(object, color, number, speed);
=======
                choisirObjet(1);
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
            }
        });
        imgTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD

                object = bitmapTruck;

                // Convert the ImageView image to a rounded corners image with border
                RoundedBitmapDrawable drawable = createRoundedBitmapDrawableWithBorder(bitmapTruck);
                // Set the ImageView image as drawable object
                imgCamaro.setImageBitmap(bitmapCamaro);
                imgTruck.setImageDrawable(drawable);
                imgBeetle.setImageBitmap(bitmapBeetle);
                imgRollsRoyce.setImageBitmap(bitmapRollsRoyce);
                mListener.onAction(object, color, number, speed);
=======
                choisirObjet(2);
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
            }
        });
        imgBeetle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD

                object = bitmapBeetle;

                // Convert the ImageView image to a rounded corners image with border
                RoundedBitmapDrawable drawable = createRoundedBitmapDrawableWithBorder(bitmapBeetle);
                // Set the ImageView image as drawable object
                imgCamaro.setImageBitmap(bitmapCamaro);
                imgTruck.setImageBitmap(bitmapTruck);
                imgBeetle.setImageDrawable(drawable);
                imgRollsRoyce.setImageBitmap(bitmapRollsRoyce);
                mListener.onAction(object, color, number, speed);
=======
                choisirObjet(3);
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
            }
        });
        imgRollsRoyce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD

                object = bitmapRollsRoyce;

                // Convert the ImageView image to a rounded corners image with border
                RoundedBitmapDrawable drawable = createRoundedBitmapDrawableWithBorder(bitmapRollsRoyce);
                // Set the ImageView image as drawable object
                imgCamaro.setImageBitmap(bitmapCamaro);
                imgTruck.setImageBitmap(bitmapTruck);
                imgBeetle.setImageBitmap(bitmapBeetle);
                imgRollsRoyce.setImageDrawable(drawable);
                mListener.onAction(object, color, number, speed);
            }
        });

=======
                choisirObjet(4);
            }
        });


>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
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
<<<<<<< HEAD

                int nbMax = 100;

                if(number < nbMax){
                    number++;
                }
                else{
                    number = nbMax;
=======
                if(number < 10){
                    number++;
                }
                else{
                    number = 10;
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
                }
                Log.d(TAG,"onClick of buttonPlus: np = " + number +".");
                np.setText(String.valueOf(number));
            }
        });

<<<<<<< HEAD
=======
        Log.d(TAG,"onCreateView: np = " + number +".");

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
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

<<<<<<< HEAD
                ((TextView)v.findViewById(R.id.SeekBarText)).setText("Speed : " + speed + "%");
=======
                ((TextView)v.findViewById(R.id.SeekBarText)).setText("Speed : " + progress);

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
                mListener.onAction(object, color, number, speed);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        return v;
    }

<<<<<<< HEAD
    // Container Activity must implement this kind of interface
=======
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

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
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
<<<<<<< HEAD

    private RoundedBitmapDrawable createRoundedBitmapDrawableWithBorder(Bitmap bitmap){
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int borderWidthHalf = 4; // In pixels
        //Toast.makeText(mContext,""+bitmapWidth+"|"+bitmapHeight,Toast.LENGTH_SHORT).show();

        // Calculate the bitmap radius
        int bitmapRadius = 150;

        int bitmapSquareWidth = Math.min(bitmapWidth,bitmapHeight);
        //Toast.makeText(mContext,""+bitmapMin,Toast.LENGTH_SHORT).show();

        int newBitmapSquareWidth = bitmapSquareWidth+borderWidthHalf;
        //Toast.makeText(mContext,""+newBitmapMin,Toast.LENGTH_SHORT).show();

        /*
            Initializing a new empty bitmap.
            Set the bitmap size from source bitmap
            Also add the border space to new bitmap
        */
        Bitmap roundedBitmap = Bitmap.createBitmap(newBitmapSquareWidth,newBitmapSquareWidth,Bitmap.Config.ARGB_8888);

        /*
            Canvas
                The Canvas class holds the "draw" calls. To draw something, you need 4 basic
                components: A Bitmap to hold the pixels, a Canvas to host the draw calls (writing
                into the bitmap), a drawing primitive (e.g. Rect, Path, text, Bitmap), and a paint
                (to describe the colors and styles for the drawing).

            Canvas(Bitmap bitmap)
                Construct a canvas with the specified bitmap to draw into.
        */
        // Initialize a new Canvas to draw empty bitmap
        Canvas canvas = new Canvas(roundedBitmap);

        /*
            drawColor(int color)
                Fill the entire canvas' bitmap (restricted to the current clip) with the specified
                color, using srcover porterduff mode.
        */

        // Calculation to draw bitmap at the circular bitmap center position
        int x = (borderWidthHalf/2) + bitmapSquareWidth - bitmapWidth;
        int y = (borderWidthHalf/2) + bitmapSquareWidth - bitmapHeight;

        /*
            drawBitmap(Bitmap bitmap, float left, float top, Paint paint)
                Draw the specified bitmap, with its top/left corner at (x,y), using the specified
                paint, transformed by the current matrix.
        */
        /*
            Now draw the bitmap to canvas.
            Bitmap will draw its center to circular bitmap center by keeping border spaces
        */
        canvas.drawBitmap(bitmap, x, y, null);

        // Initializing a new Paint instance to draw circular border
        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderWidthHalf);
        borderPaint.setColor(Color.GRAY);

        /*
            drawCircle(float cx, float cy, float radius, Paint paint)
                Draw the specified circle using the specified paint.
        */
        /*
            Draw the circular border to bitmap.
            Draw the circle at the center of canvas.
         */
        canvas.drawCircle(canvas.getWidth()/2, canvas.getWidth()/2, newBitmapSquareWidth/2, borderPaint);

        /*
            RoundedBitmapDrawable
                A Drawable that wraps a bitmap and can be drawn with rounded corners. You can create
                a RoundedBitmapDrawable from a file path, an input stream, or from a Bitmap object.
        */
        /*
            public static RoundedBitmapDrawable create (Resources res, Bitmap bitmap)
                Returns a new drawable by creating it from a bitmap, setting initial target density
                based on the display metrics of the resources.
        */
        /*
            RoundedBitmapDrawableFactory
                Constructs RoundedBitmapDrawable objects, either from Bitmaps directly, or from
                streams and files.
        */
        // Create a new RoundedBitmapDrawable
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mResources,roundedBitmap);

        /*
            setCornerRadius(float cornerRadius)
                Sets the corner radius to be applied when drawing the bitmap.
        */
        // Set the corner radius of the bitmap drawable
        roundedBitmapDrawable.setCornerRadius(bitmapRadius);

        /*
            setAntiAlias(boolean aa)
                Enables or disables anti-aliasing for this drawable.
        */
        roundedBitmapDrawable.setAntiAlias(true);

        // Return the RoundedBitmapDrawable
        return roundedBitmapDrawable;
    }
=======
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
}
