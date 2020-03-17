package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alyndroid.architecturepatternstutorialshomework.Pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.Pojo.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberView {

    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    @BindView(R.id.plus_result_textView)
    TextView plusResultTextView;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;

    NumberPresenter numberPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        plusButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);

        //MVP
        numberPresenter = new NumberPresenter(this);

    }

    //MVC
    NumberModel getNumbers() {
        DataBase db = new DataBase();
        return db.getNumbers();
    }

    int plus() {
        NumberModel numberModel = getNumbers();
        return numberModel.getFirstNum() + numberModel.getSecondNum();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus_button:
                plusResultTextView.setText("" + plus());
                break;
            case R.id.mul_button:
                numberPresenter.mul();
                break;
        }
    }

    //MVP
    @Override
    public void getMul(int mul) {
        mulResultTextView.setText(""+mul);
    }
}
