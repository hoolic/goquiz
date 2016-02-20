package com.example.holic.goquiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public boolean end;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        end = false;

        playButton = (Button) findViewById(R.id.startButtom);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ready go!",
                        Toast.LENGTH_LONG).show();
                startQuiz(null);
            }
        });

        //typeFace
        //Typeface font = Typeface.createFromAsset(getAssets(),“Strato-linked”);
        //TextView tv=(TextView) findViewById(R.id.textView0);
        //tv.setTypeface(font);

    }

    public void startQuiz(View view) {
        //TODO: Put to start game play activity
        //startActivity();
        Intent downloadIntent = new Intent(this, Quizplay.class);
        //downloadIntent.setData(Uri.parse(fileUrl));
        //startService(downloadIntent);
        startActivity(downloadIntent);

    }


}
