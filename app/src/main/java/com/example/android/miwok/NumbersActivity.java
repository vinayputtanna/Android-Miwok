package com.example.android.miwok;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

//        LinearLayout rootView=(LinearLayout)findViewById(R.id.rootView);
//        int j=0;
//        while(j<words.size()){
//            TextView numberTextView=new TextView(this);
//            numberTextView.setText(words.get(j));
//            rootView.addView(numberTextView);
//            j++;
//        }
//
//        for(int i=0;i<words.size();i++){
//            TextView numberTextView=new TextView(this);
//            numberTextView.setText(words.get(i));
//            rootView.addView(numberTextView);
//        }

        WordAdapter wordAdapter=new WordAdapter(this, words, R.color.category_numbers);
//        GridView gridView=(GridView)findViewById(R.id.grid);
//        gridView.setAdapter(arrayAdapter);
        ListView listview=(ListView) findViewById(R.id.list);
        listview.setAdapter(wordAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord= (Word) parent.getItemAtPosition(position);
                int audioResourceId=currentWord.getAudioResourceId();
                MediaPlayer mediaPlayer=MediaPlayer.create(NumbersActivity.this, audioResourceId);
                mediaPlayer.start();
            }
        });
    }
}
