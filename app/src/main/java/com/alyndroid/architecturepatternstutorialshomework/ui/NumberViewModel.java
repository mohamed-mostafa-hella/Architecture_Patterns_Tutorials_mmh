package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.Pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.Pojo.NumberModel;

public class NumberViewModel extends ViewModel {

    MutableLiveData<String> devResult = new MutableLiveData<>();

    private NumberModel getNumbers() {
        DataBase db = new DataBase();
        return db.getNumbers();
    }

    void dev() {
        NumberModel numberModel = getNumbers();
        int devNumber = numberModel.getFirstNum() / numberModel.getSecondNum();
        devResult.setValue(""+devNumber);
    }


}
