package com.example.pruebatecnica.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pruebatecnica.R;
import com.example.pruebatecnica.presenter.MainPresenter;
import com.example.pruebatecnica.presenter.MainView;

public class MainActivity extends AppCompatActivity {

    private MainView presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        presenter.setupView();

        presenter.setupAdapter();
    }

    public void onClickCall(View view) {
        TextView button = (TextView)view;
        String buttonText = button.getText().toString();

        presenter.showCall(buttonText);
    }

}