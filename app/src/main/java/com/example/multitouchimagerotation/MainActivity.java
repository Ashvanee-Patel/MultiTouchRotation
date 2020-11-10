package com.example.multitouchimagerotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  implements RotationGestureDetector.OnRotationGestureListener {
    ImageView imageView;
    private RotationGestureDetector mRotationDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRotationDetector = new RotationGestureDetector(this);

        imageView= findViewById(R.id.imageView1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        mRotationDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void OnRotation(RotationGestureDetector rotationDetector) {
        float angle = rotationDetector.getAngle();
        imageView.setRotation(imageView.getRotation() + (-angle));
        Log.d("RotationGestureDetector", "Rotation: " + Float.toString(angle));
    }
}