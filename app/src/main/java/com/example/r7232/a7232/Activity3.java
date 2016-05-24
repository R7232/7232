package com.example.r7232.a7232;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity3 extends QuestionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        init();
    }

    private void init(){
        m_image = (ImageView)findViewById(R.id.iv_image) ;
        m_image.setImageResource(R.drawable.third);
    }

    @Override
    protected Class getBackActivityClass() {
        return Activity2.class;
    }

    @Override
    protected Class getNextActivityClass() {
        return Activity4.class;
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
