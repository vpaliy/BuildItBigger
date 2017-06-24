package com.vpaliy.joke_presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE="joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        ButterKnife.bind(this);
        final String joke=getIntent().getExtras().getString(EXTRA_JOKE);
        TextView jokeText=ButterKnife.findById(this,R.id.joke_text);
        jokeText.setText(joke);
    }
}
