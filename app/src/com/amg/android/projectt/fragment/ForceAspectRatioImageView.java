package com.amg.android.projectt.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.amg.android.projectt.R;

/** Maintains an aspect ratio based on either width or height. Disabled by default. */
public class ForceAspectRatioImageView extends ImageView {
    private final int widthRatio;
    private final int heightRatio;

    public ForceAspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView);
        widthRatio = a.getInteger(R.styleable.AspectRatioImageView_widthRatio, 1);
        heightRatio = a.getInteger(R.styleable.AspectRatioImageView_heightRatio, 1);
        a.recycle();
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            if (heightMode != MeasureSpec.EXACTLY) {
                heightSize = (int) (widthSize * 1f / widthRatio * heightRatio);
            }
        } else if (heightMode == MeasureSpec.EXACTLY) {
            widthSize = (int) (heightSize * 1f / heightRatio * widthRatio);
        } else {
            throw new IllegalStateException("Either width or height must be EXACTLY.");
        }

        widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize, MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
