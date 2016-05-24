package com.example.r7232.a7232;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Activity5 extends QuestionActivity {

    private ImageView m_image ;

    @Override
    protected void onStart() {
        super.onStart();
        m_image = (ImageView)findViewById(R.id.iv_image) ;
        m_image.setImageResource(R.drawable.fifth);
        setNextButtonText("完成");




    }

    @Override
    protected Class getBackActivityClass() {
        return Activity4.class;
    }

    @Override
    protected Class getNextActivityClass() {
        return null;
    }

    @Override
    protected int getBackButtonVisibility() {
        return View.VISIBLE;
    }

    @Override
    protected int getNextButtonVisibility() {
        return View.VISIBLE;
    }

    @Override
    public void next(View view) {

        int answer = retunanswer();

        StringBuilder message = new StringBuilder();
        message.append("你猜的數字.......\n\n")
                .append(answer + "\n\n");


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Activity5.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        QuestionActivity.resetQuestionIndex();
                    }

                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();


    }

    public int retunanswer(){

        int answer = 0 ;

        UserAnswers userAnswers = QuestionActivity.getUserAnswers() ;

        switch (userAnswers.getAnswers(0)) {
            case 1:
                answer = answer + 1;
                break;
        }
        switch (userAnswers.getAnswers(1)) {
            case 1:
                answer = answer + 2;
                break ;
        }
        switch (userAnswers.getAnswers(2)) {
            case 1:
                answer = answer + 4;
                break ;
        }
        switch (userAnswers.getAnswers(3)) {
            case 1:
                answer = answer + 8;
                break;
        }
        switch (userAnswers.getAnswers(4)) {
            case 1:
                answer = answer + 16;
                break;
        }
        return answer ;

    }

}






