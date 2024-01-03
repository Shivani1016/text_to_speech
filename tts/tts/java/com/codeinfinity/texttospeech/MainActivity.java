package com.codeinfinity.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t;

    EditText pitch, rate, texttospeak;

    Button speak;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pitch = findViewById(R.id.pitch);
        rate = findViewById(R.id.speechrate);
        texttospeak = findViewById(R.id.texttospeech);

        t = new TextToSpeech(this, new TextToSpeech.OnInitListener() {

            @Override

            public void onInit(int i) {

                if (i == TextToSpeech.SUCCESS) {
                    t.setLanguage(Locale.ENGLISH);
                } else {
                    Toast.makeText(MainActivity.this, "Text to Speech Could not be initialised", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void speak(View v){
        String text = texttospeak.getText().toString();

        if (pitch.getText().toString().equals("")) {
            t.setPitch(1.0f);
        } else {
            t.setPitch(Float.parseFloat(pitch.getText().toString()));

        }

        if (rate.getText().toString().equals("")) {
            t.setSpeechRate(1.0f);
        } else {

            t.setSpeechRate(Float.parseFloat(rate.getText().toString()));
        }
        t.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}