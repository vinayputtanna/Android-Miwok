package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vinay on 9/5/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor){
        super(context, 0, words);
        mBackgroundColor=backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord=getItem(position);

        TextView miwokTextView=(TextView)listItemView.findViewById(R.id.miwokText);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView=(TextView)listItemView.findViewById(R.id.englishText);
        defaultTextView.setText(currentWord.getDefaultTranslation());


        ImageView imageView=(ImageView)listItemView.findViewById(R.id.image);
        if(!(currentWord.getImageResourceId()==-1)){
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer=listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}