package com.example.r7232.a7232;


import android.app.Application;
import android.content.Context;

public class MyApp extends Application{
    private static Context context ;
    private static UserAnswers userAnswers ;

    public static Context getContext(){
        return context ;
    }

    public MyApp(){
        context = this ;
    }

    public static UserAnswers getUserAnswers(){
         userAnswers = new UserAnswers(5) ;
        return userAnswers ;
    }



}
