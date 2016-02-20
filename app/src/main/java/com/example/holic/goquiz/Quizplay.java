package com.example.holic.goquiz;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by holic on 16/2/19.
 */

public class Quizplay extends FragmentActivity
        implements textFrag.OnFragmentInteractionListener,
                   pictureFrag.OnFragmentInteractionListener {

    public static int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizplay);
        score = 0;

        textFrag textQ = new textFrag();
        textQ.setArguments(getIntent().getExtras());

        //TA implementation
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.Fraglayout, textQ)
                .addToBackStack(null)
                .commit();
        //TA end

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    public void onFragmentInteraction(Uri uri){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
