package com.example.bitcom.test.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bitcom.test.R;


public class TopBar extends RelativeLayout {
    private ImageView ivLeft,ivRight;
    private TextView tvTitle;
    private onLeftClickListener leftClickListener;
    private onRightClickListener rightClickListener;
    public interface onLeftClickListener{
         void onLeftClick();
    }
    public interface onRightClickListener{
        void onRightClick();
    }
    public void setOnLeftClickListener(onLeftClickListener leftClickListener){
        this.leftClickListener=leftClickListener;
    }

    public void setOnRightClickListener(onRightClickListener rightClickListener){
        this.rightClickListener=rightClickListener;
    }
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        String titleText=ta.getString(R.styleable.TopBar_titleText);
        Log.d("tag","titleText="+titleText);
        int titleTextColor=ta.getColor(R.styleable.TopBar_titleTextColor,0x38ad5a);
        float titleTextSize=ta.getFloat(R.styleable.TopBar_titleTextSize,18f);
        int leftDrawable=ta.getResourceId(R.styleable.TopBar_leftDrawable,0);
        int rightDrawable=ta.getResourceId(R.styleable.TopBar_rightDrawable,R.drawable.ic_launcher_background);
        ta.recycle();

        LayoutInflater.from(context).inflate(R.layout.top_bar_layout,this);

        ivLeft=(ImageView)findViewById(R.id.ivLeft);
        ivLeft.setBackgroundResource(leftDrawable);
        ivLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(leftClickListener!=null){
                    leftClickListener.onLeftClick();
                }

            }
        });

        ivRight=(ImageView)findViewById(R.id.ivRight);
        ivRight.setBackgroundResource(rightDrawable);
        ivRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightClickListener!=null){
                    rightClickListener.onRightClick();
                }

            }
        });

        tvTitle=(TextView)findViewById(R.id.tvTitle);
        tvTitle.setText(titleText);
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
    }
}
