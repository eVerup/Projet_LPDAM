package com.example.lucasabadie.projetandroidtp;


<<<<<<< HEAD
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
=======
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5

/**
 * A simple {@link Fragment} subclass.
 */
<<<<<<< HEAD

public class GameFragment extends Fragment {

    //region Variables

        private static final String TAG = "GameFragment";

        private View v;
        private Resources mResources;
        private MediaPlayer mp;
        private CustomView customView;

        private Bitmap object;
        private int numObject;
        private String sColor;
        private int speed;

    //endregion

    //region Constructor

        public GameFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            v = inflater.inflate(R.layout.fragment_game, container, false);

            mResources = getResources();
            mp = MediaPlayer.create(getContext(), R.raw.musicwin);
            object = BitmapFactory.decodeResource(mResources,R.drawable.ic_camaro);
            numObject = 1;
            sColor = "#000000";
            speed = 0;

            customView = (CustomView) v.findViewById(R.id.CustomView);
            customView.setActivity(getActivity());
            customView.setObject(object);
            customView.setNumObject(numObject);
            customView.setsColor(sColor);
            customView.setSpeed(speed);
            customView.setMediaPlayer(mp);

            customView.setOnTouchListener(customView);

            return v;
        }

    //endregion

    //region Methods

        /** Method for set the object (item) **/
        public void changerObject(Bitmap m) {
            object = m;
        }

        /** Method for set the number of items **/
        public void changerNombre( int n ) {
            numObject = n;
        }

        /** Method for set the color (in string because the treatment is done later) **/
        public void changerColor(String s) {
            sColor = s;
        }

        /** Method for set the speed **/
        public void changerSpeed(int i) {
            speed = i;
        }

        /** Method for start the game **/
        public void Game() {

            customView.setObject(object);
            customView.setNumObject(numObject);
            customView.setsColor(sColor);
            customView.setSpeed(speed);
        }

        @Override
        public void onPause() {
            super.onPause();

            customView.getMediaPlayer().pause();
        }

    //endregion

=======
public class GameFragment extends Fragment {

    private static final String TAG = "GameFragment";

    private View v;
    private Resources mResources;
    private RelativeLayout imgLayout;
    private MediaPlayer mp;

    private Bitmap object;
    private int numObject;
    private int color;
    private String sColor;
    private int speed;

    private int x;
    private int xMax;
    private int y;
    private int yMax;
    private Random xRDM;
    private Random yRDM;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_game, container, false);

        mResources = getResources();
        mp = MediaPlayer.create(getContext(), R.raw.musicwin);
        object = BitmapFactory.decodeResource(mResources,R.drawable.ic_camaro);
        numObject = 1;
        color = Color.parseColor("#000000");
        sColor = "#000000";
        speed = 0;
        imgLayout = (RelativeLayout) v.findViewById(R.id.imageLayout);

        xRDM = new Random();
        yRDM = new Random();



        for(int i=0;i < numObject;i++)
        {
            ImageView image = new ImageView(v.getContext());
            RelativeLayout.LayoutParams vp = new RelativeLayout.LayoutParams(64, 64);
            x = 0;
            Log.d(TAG,"onCreateView: x = " + x +".");
            y = 0;
            Log.d(TAG,"onCreateView: y = " + y +".");
            vp.setMargins(x, y, 0, 0);
            image.setLayoutParams(vp);
            image.setMaxHeight(64);
            image.setMaxWidth(64);

            // other image settings
            image.setImageBitmap(object);
            image.setColorFilter(color);

            imgLayout.addView(image);
        }

        return v;
    }

    public void changerObject(Bitmap m) {
        object = m;
        //((ImageView)getView().findViewById(R.id.imageView)).setImageBitmap(m);
    }

    public void changerNombre( int n ) {
        numObject = n;
        ((TextView)getView().findViewById(R.id.textFragment)).setText("Number of object : "+n);
    }

    public void changerColor(String s) {
       // ImageView lineColorCode = (ImageView)v.findViewById(R.id.imageView);
        color = Color.parseColor(s); //The color u want
        sColor = s;
        Log.d(TAG,"changerColor: color = " + color +".");
        //lineColorCode.setColorFilter(color);
    }

    public void changerSpeed(int i) {
        speed = i;
        ((TextView)getView().findViewById(R.id.textView4)).setText("Speed : "+speed);
    }

    public void Game() {
        imgLayout.removeAllViews();

        if (xMax == 0 && yMax == 0){
            xMax = imgLayout.getWidth()-64;
            Log.d(TAG,"Game: xMax = " + xMax +".");
            yMax = imgLayout.getHeight()-64;
            Log.d(TAG,"Game: yMax = " + yMax +".");
        }

        for(int i=0;i < numObject;i++)
        {
            ImageView image = new ImageView(v.getContext());
            RelativeLayout.LayoutParams vp = new RelativeLayout.LayoutParams(64, 64);
            x = xRDM.nextInt(xMax - 0 + 1);
            Log.d(TAG, "Game: x = " + x + ".");
            vp.leftMargin = x;
            y = yRDM.nextInt(yMax - 0 + 1);
            Log.d(TAG, "Game: y = " + y + ".");
            vp.topMargin = y;
            image.setLayoutParams(vp);

            // other image settings
            image.setImageBitmap(object);

            if (i == numObject - 1){

                switch (sColor) {
                    case "#000000": {
                        image.setColorFilter(Color.parseColor("#333333"));
                        break;
                    }
                    case "#1e76ea": {
                        image.setColorFilter(Color.parseColor("#115bbb"));
                        break;
                    }
                    case "#38cd0b": {
                        image.setColorFilter(Color.parseColor("#289108"));
                        break;
                    }
                    case "#ff0004": {
                        image.setColorFilter(Color.parseColor("#ff3336"));
                        break;
                    }
                }

                image.setTag("objectIntruder");
                Log.d(TAG, "Game: id = objectIntruder .");
            }
            else {
                image.setColorFilter(color);
                image.setTag("object" + i);
                Log.d(TAG, "Game: id = object" + i + ".");
            }
            //image.setColorFilter(color);

            imgLayout.addView(image);
        }

        ImageView intruder = (ImageView) v.findViewWithTag("objectIntruder");
        intruder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick of intruder: Good Game, you win.");
                //mp.reset();
                mp.start();
                // Use the Builder class for convenient dialog construction
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("You win ! Good Job !")
                        .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mp.reset();
                                Game();
                            }
                        })
                        .setNegativeButton("Stop", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mp.stop();
                                getActivity().finish();
                                System.exit(0);
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create();

                builder.show();
            }
        });
    }
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
}
