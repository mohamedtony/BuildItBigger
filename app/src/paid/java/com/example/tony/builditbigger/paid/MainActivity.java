package com.example.tony.builditbigger.paid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tony.builditbigger.MyAsyncTask;
import com.example.tony.builditbigger.R;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // new MyAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        button2=(Button) findViewById(R.id.button2);


    }

    public void tellJoke(View v) {
        v.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);


        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = null;
        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }
        Boolean stateChanged = activeNetwork != null && activeNetwork.isConnected();

        if (stateChanged) {
            new MyAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
        } else {
            Toast.makeText(this, " Please, check your internet ", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        progressBar.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.VISIBLE);

    }
}
