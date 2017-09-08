package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo’e"));
        words.add(new Word("ten", "na’aacha"));

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

        WordAdapter wordAdapter=new WordAdapter(this, words);
//        GridView gridView=(GridView)findViewById(R.id.grid);
//        gridView.setAdapter(arrayAdapter);
        ListView listview=(ListView) findViewById(R.id.list);
        listview.setAdapter(wordAdapter);
    }
}
