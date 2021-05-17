package com.example.pruebatecnica.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pruebatecnica.R;
import com.example.pruebatecnica.presenter.MainPresenterImpl;
import com.example.pruebatecnica.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    private final MainPresenter presenter = new MainPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.setupView();

        presenter.setupAdapter();
    }

    public void onClickCall(View view) {
        TextView button = (TextView)view;
        String buttonText = button.getText().toString();

        presenter.doCall(buttonText);
    }

}