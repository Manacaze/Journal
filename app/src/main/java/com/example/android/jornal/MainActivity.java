package com.example.android.jornal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mViewJournal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewJournal = findViewById(R.id.tv_view_journal);

        fetchJournalData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mn_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_login:
                openSignin();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openSignin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    //Fecth Journal data
    private void fetchJournalData(){
        mViewJournal.setText("I tried, but i didn't have experience with Android Basic, I gonna try to learn Again, but starting for android Basic");
    }

}
