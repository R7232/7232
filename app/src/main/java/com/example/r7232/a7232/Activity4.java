package com.example.r7232.a7232;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity4 extends QuestionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        init();
    }

    private void init(){
        m_image = (ImageView)findViewById(R.id.iv_image) ;
        m_image.setImageResource(R.drawable.fourth);
    }

    @Override
    protected Class getBackActivityClass() {
        return Activity3.class;
    }

    @Override
    protected Class getNextActivityClass() {
        return Activity5.class;
    }

    @Override
    protected int getBackButtonVisibility() {
        return View.VISIBLE;
    }

    @Override
    protected int getNextButtonVisibility() {
        return View.VISIBLE;
    }


    private ImageView m_image ;
}
