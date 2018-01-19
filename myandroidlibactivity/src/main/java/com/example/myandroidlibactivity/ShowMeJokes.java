package com.example.myandroidlibactivity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;



public class ShowMeJokes extends AppCompatActivity {
   private String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_me_jokes);

        if(savedInstanceState!=null&&savedInstanceState.containsKey("joke")){
                joke=savedInstanceState.getString("joke");
        }else{
            joke=(String)getIntent().getStringExtra("joke");
        }

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        TextView textView=(TextView)findViewById(R.id.display_jokes);

        if(!TextUtils.isEmpty(joke)) {
            textView.setText(joke);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        ShowMeJokes.this.finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("joke",joke);
    }
}
