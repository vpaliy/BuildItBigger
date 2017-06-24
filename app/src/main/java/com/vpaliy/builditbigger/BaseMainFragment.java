package com.vpaliy.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vpaliy.joke_presentation.JokeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public abstract class BaseMainFragment extends Fragment
        implements EndpointAsyncTask.OnFetchJokeListener{

    private Unbinder unbinder;

    @BindView(R.id.progress_bar)
    protected ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_main,container,false);
        unbinder=ButterKnife.bind(this,root);
        return root;
    }

    @OnClick(R.id.generate_joke)
    public void askForJoke(){
        EndpointAsyncTask.createTask(getContext(),this).execute();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }

    @Override
    public void onStartFetching() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onJokeFetched(String joke) {
        progressBar.setVisibility(View.GONE);
    }

    public void showJoke(String joke){
        Toast.makeText(getContext(),joke,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(getContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_JOKE,joke);
         startActivity(intent);
    }
}
