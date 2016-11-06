package com.example.lucasabadie.projetandroidtp;

<<<<<<< HEAD
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lucas Abadie on 31/10/2016.
 */

public class CustomView extends View implements View.OnTouchListener {

    //region Variables / Getter / Setter

        //region Variables

            private static final String TAG = "CustomView";
            private Activity activity;

            private ArrayList <DrawingObject> objectTab;
            private IntruderObject intruder;
            private MediaPlayer mMP;

            private Bitmap mObject;
            private Bitmap tempObject;
            private int mNumObject;
            private int tempNumObject;
            private String msColor;
            private String tempColor;
            private int mSpeed;
            private int tempSpeed;

            private int xMax;
            private int xTouch;
            private int yMax;
            private int yTouch;

            private Random rdm;
            private boolean bIsReload = false;

        //endregion

        //region Getter / Setter
            public MediaPlayer getMediaPlayer() { return mMP; }

            public void setObject(Bitmap mObject) { this.mObject = mObject; }
            public void setNumObject(int mNumObject) { this.mNumObject = mNumObject; }
            public void setsColor(String msColor) { this.msColor = msColor; }
            public void setSpeed(int mSpeed) { this.mSpeed = mSpeed; }
            public void setActivity(Activity activity) { this.activity = activity; }
            public void setMediaPlayer(MediaPlayer mMP) { this.mMP = mMP; }
        //endregion

    //endregion

    //region Constructor

        public CustomView (Context context) {
            super(context);
            init();
        }


        public CustomView (Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public void init () {
            rdm = new Random();
            objectTab = new ArrayList<>();

            //Initialisation of temporary variables (or save variables) for next tests
            tempObject = mObject;
            tempNumObject = mNumObject;
            tempColor = msColor;
            tempSpeed = mSpeed;

            removeCallbacks(animator);
            post(animator);
        }

    //endregion

    //region Methods

        /** Method for retrieving data on the size of the view **/
        @Override
        protected void onLayout(boolean changed, int left, int top, int
                right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            xMax = this.getWidth();
            yMax = this.getHeight();
        }

        /** Method for add data in the ArrayList<> **/
        private DrawingObject addObject() {
            DrawingObject drawingObject;

            drawingObject = new DrawingObject(mObject, xMax, yMax, rdm.nextInt(10 - 5)+1, rdm.nextInt(15 - 10 + 1 )+1, mSpeed, msColor);

            return drawingObject;
        }

        private Runnable animator = new Runnable() {
            @Override
            public void run() {
                invalidate();
                postDelayed(this, 15);
            }
        };

        @Override
        protected void onDraw(Canvas canvas) {

            // Test to clear and recreate the ArrayList items when changing settings
            if ( tempObject != mObject || tempNumObject != mNumObject || tempColor != msColor || tempSpeed != mSpeed || bIsReload) {

                bIsReload = false;

                tempObject = mObject;
                tempNumObject = mNumObject;
                tempColor = msColor;
                tempSpeed = mSpeed;

                objectTab.clear();

                for (int i = 0; i < mNumObject-1; i++) {
                    objectTab.add(this.addObject());
                }

                intruder = new IntruderObject(mObject, xMax, yMax, rdm.nextInt(10 - 5)+1, rdm.nextInt(15 - 10 + 1 )+1, mSpeed, msColor);
            }

            // Draw item by item contained in the ArrayList
            for (int i = 0; i < mNumObject-1; i++) {
                objectTab.get(i).draw(canvas);
            }

            // Draw intruder
            intruder.draw(canvas);

            // Move item by item contained in the ArrayList
            for (int i = 0; i < mNumObject-1; i++) {
                objectTab.get(i).update();
            }

            //Move intruder
            intruder.update();

        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            // Test to see if the screen is pressed
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

                // Recovery of the x and y position of the pressed area
                xTouch = (int) motionEvent.getX()+30;
                yTouch = (int) motionEvent.getY()+30;

                // Test to see if the x and y position of the pressed area are contained in the intruder zone
                if( ((xTouch < (intruder.getX() + intruder.getmObject().getWidth()) + 30) && (xTouch > (intruder.getX() + intruder.getmObject().getWidth()) - 30)) &&
                        ((yTouch < (intruder.getY() + intruder.getmObject().getHeight()) + 30) && (yTouch > (intruder.getY() + intruder.getmObject().getHeight()) - 30))) {
                    Log.d(TAG,"onTouch : You win.");

                    mMP.seekTo(0);
                    mMP.start();

                    final Vibrator v = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(2000);

                    // Use the Builder class for convenient dialog construction
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setCancelable(false);
                    builder.setMessage("You win ! You are a king, do you want to play again ?")
                            .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    mMP.pause();
                                    bIsReload = true;
                                }
                            })
                            .setNegativeButton("No, please stop", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    mMP.stop();
                                    v.cancel();
                                    activity.finish();

                                    System.exit(0);
                                }
                            });
                    // Create the AlertDialog object and return it
                    builder.create();

                    builder.show();
                }

                return true;
            }

            return false;
        }

    //endregion

=======
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lucas Abadie on 31/10/2016.
 */
public class CustomView extends View {

    private Paint paint;

    public CustomView (Context context) {
        super(context);
        init();
    }


    public CustomView (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init () {
        paint = new Paint();
        paint.setTextSize(25);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // dessiner
        canvas.drawText(
                "New Text", 0, 0, paint);
    }
>>>>>>> 4e7fa08e5b83129b4932c592d34580e395f00de5
}
