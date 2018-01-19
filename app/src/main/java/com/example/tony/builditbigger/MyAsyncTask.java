package com.example.tony.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.core.deps.guava.annotations.VisibleForTesting;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.example.MyClass;

import com.example.myandroidlibactivity.ShowMeJokes;
import com.example.tony.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Tony on 12/23/2017.
 */

public class MyAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private CountingIdlingResource idlingResource=new CountingIdlingResource("Data_loader");
    @Override
    protected String doInBackground(Pair<Context, String>[] pairs) {

        idlingResource.increment();

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://mohamedtony-builditbigger.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        context = pairs[0].first;
       // String joke = null;
        try {
          return myApiService.sayHi(MyClass.getJoke()).execute().getData();
            //joke= myApiService.getJoke().execute().getData();
           // return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
       // Log.d("joke",joke);
       // return joke;
    }
    @Override
    protected void onPostExecute(String result) {
         //   Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        //Log.e(" error ",result);

        idlingResource.decrement();
        if(result!=null) {
            Intent intent = new Intent(context, ShowMeJokes.class);
            intent.putExtra("joke", result);
            context.startActivity(intent);
        }


    }

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {

        return idlingResource;
    }
}

