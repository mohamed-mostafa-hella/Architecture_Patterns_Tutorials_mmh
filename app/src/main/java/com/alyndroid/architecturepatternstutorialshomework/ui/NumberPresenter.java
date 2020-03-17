package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.Pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.Pojo.NumberModel;

public class NumberPresenter {

    NumberView interFace;

    public NumberPresenter(NumberView interFace) {
        this.interFace = interFace;
    }

    NumberModel getNumbers(){
        DataBase db =  new DataBase();
        return db.getNumbers();
    }

    void  mul (){
        NumberModel numberModel = getNumbers();
        int first = numberModel.getFirstNum();
        int second = numberModel.getSecondNum();
         interFace.getMul( first * second );
    }
}
