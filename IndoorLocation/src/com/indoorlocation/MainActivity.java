package com.indoorlocation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {
	
	private GestureDetectorCompat simpledetector;
	
	String TAG = "main Activity";

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new Thread(new Connection()).start();
        drawMainContent();
        
        simpledetector = new GestureDetectorCompat(this, new MyGestureListener());
        
    }

    
    public boolean onTouchEvent(MotionEvent event){	
    	this.simpledetector.onTouchEvent(event);
    	return super.onTouchEvent(event);
    }
    
    
    class MyGestureListener implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener{
    	
    	private static final String DEBUG_TAG = "Gestures"; 
        
        
		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onDoubleTapEvent(MotionEvent e) {
			Log.d(DEBUG_TAG,"Action was ");
            return true;
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}
        
        
    }

    
    public void drawMainContent(){
    	
    	ImageView settings = (ImageView) findViewById(R.id.settings);
    	settings.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.d(TAG," ITS SOMETHING ");
				return false;
			}
		});   	
    }

}
