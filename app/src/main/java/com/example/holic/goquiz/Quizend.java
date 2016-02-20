package com.example.holic.goquiz;

/**
 * Created by holic on 16/2/19.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quizend extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizend);
        Button quit = (Button) findViewById(R.id.quitButton);
        Button loop = (Button) findViewById(R.id.againButton);

        int count = Quizplay.score;
        TextView results = (TextView) findViewById(R.id.scoreResults);
        results.setText("Wow! You get " + count + "/2 correct !");



        loop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Quizplay.class);
                startActivity(intent);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                finish();
            }
        });
    }
}
