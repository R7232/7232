package com.example.r7232.a7232;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public abstract class QuestionActivity extends AppCompatActivity {

    private Button m_btn_next ;
    private Button m_btn_back ;

    private static int m_index = 0 ;
    private static int m_back_index ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        init();
    }

    @SuppressWarnings("ResourceType")
    private void init() {



        m_btn_next = (Button)findViewById(R.id.btn_next) ;
        m_btn_back = (Button)findViewById(R.id.btn_back) ;

        m_btn_next.setVisibility(getNextButtonVisibility());
        m_btn_back.setVisibility(getBackButtonVisibility());
    }


    public void back(View view) {

        m_back_index = m_index ;
        m_index-- ;

        Intent intent = new Intent(this,getBackActivityClass()) ;
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivity(intent);
    }

    public void next(View view) {
        m_back_index = m_index ;
        m_index++ ;

        Intent intent = new Intent(this,getNextActivityClass()) ;
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);



    }

    public void setBackButtonText(CharSequence text){
        m_btn_back.setText(text);
    }
    public void setNextButtonText(CharSequence text){
        m_btn_next.setText(text);
    }

    protected abstract Class getBackActivityClass(); // 切換下個畫面的 Activity.class
    protected abstract Class getNextActivityClass(); // 切換上個畫面的 Activity.class
    protected abstract  int getBackButtonVisibility(); // Back 按鈕是否能被看見
    protected abstract  int getNextButtonVisibility(); // Next 按鈕是否能被看見


    private static UserAnswers userAnswers = MyApp.getUserAnswers();

    public static UserAnswers getUserAnswers() {
        return userAnswers;
    }

    public void click(View view) {
        RadioButton radio = (RadioButton)view;

        switch (radio.getId()){
            case R.id.radio_a:

                userAnswers.setAnswers(m_index , 1);
                Log.d("abc","" + userAnswers.getAnswers(0)) ;
                Log.d("abc","" + userAnswers.getAnswers(1)) ;
                Log.d("abc","" + userAnswers.getAnswers(2)) ;
                Log.d("abc","" + userAnswers.getAnswers(3)) ;
                Log.d("abc","" + userAnswers.getAnswers(4)) ;

                break;
            case R.id.radio_b:

                userAnswers.setAnswers(m_index , 0);
                Log.d("abc","" + userAnswers.getAnswers(0)) ;
                Log.d("abc","" + userAnswers.getAnswers(1)) ;
                Log.d("abc","" + userAnswers.getAnswers(2)) ;
                Log.d("abc","" + userAnswers.getAnswers(3)) ;
                Log.d("abc","" + userAnswers.getAnswers(4)) ;
                break;
        }
    }

    public static void resetQuestionIndex() {
        m_index = 0;
        m_back_index = 0;
    }
}

