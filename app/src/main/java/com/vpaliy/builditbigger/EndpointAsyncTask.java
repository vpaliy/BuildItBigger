package com.vpaliy.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import com.example.vpaliy.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private static JokeApi apiService = null;
    private Context context;
    private OnFetchJokeListener jokeListener;

    private EndpointAsyncTask(Context context, OnFetchJokeListener jokeListener){
        this.context=context;
        this.jokeListener=jokeListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        jokeListener.onStartFetching();
    }

    @Override
    protected String doInBackground(Void... params) {
        if(apiService==null){
            JokeApi.Builder builder=new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl(context.getString(R.string.root_url))
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            apiService=builder.build();
        }
        try{
            return apiService.getJoke().execute().getJoke();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        jokeListener.onJokeFetched(result);
    }

    public interface OnFetchJokeListener {
        void onJokeFetched(String joke);
        void onStartFetching();
    }

    public static EndpointAsyncTask createTask(Context context, OnFetchJokeListener jokeListener){
        return new EndpointAsyncTask(context,jokeListener);
    }
}