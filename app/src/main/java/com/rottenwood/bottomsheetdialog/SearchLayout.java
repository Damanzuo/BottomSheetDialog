package com.rottenwood.bottomsheetdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author damanz
 * @Time 2019/12/21 22:16
 * @describe
 */

public class SearchLayout extends LinearLayout {
    //是否可进行文字输入
    private boolean isEnableEdit;


    public SearchLayout(Context context) {
        this(context, null);
    }

    public SearchLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
