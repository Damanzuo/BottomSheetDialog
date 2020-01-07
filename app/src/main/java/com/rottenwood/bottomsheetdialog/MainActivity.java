package com.rottenwood.bottomsheetdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LinearLayout mBottomDialog;
    private BottomSheetBehavior<LinearLayout> behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview);
        mBottomDialog = findViewById(R.id.bottom_dialog);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了弹窗", Toast.LENGTH_SHORT).show();
            }
        });

        behavior = BottomSheetBehavior.from(mBottomDialog);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //这里是bottomSheet 状态的改变
                if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
                int measuredHeight = bottomSheet.getMeasuredHeight();
                int height = bottomSheet.getHeight();
                Log.d(TAG, "onSlide:measuredHeight  " + measuredHeight);
                Log.d(TAG, "onSlide:height  " + height);
                Log.d(TAG, "onSlide:slideOffset  " + slideOffset);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (bottomSheetFragment != null) {
//            bottomSheetFragment.dismiss();
//        }
    }
}
