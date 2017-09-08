package com.example.android.miwok;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.android.miwok.MainActivity;
import com.example.android.miwok.NumbersActivity;

/**
 * Created by Vinay on 9/4/2017.
 */

public class NumbersClickListener implements View.OnClickListener {
    public void onClick(View view){
//        Intent intent=new Intent(view.getContext(), NumbersActivity.class);
//        startActivity(intent);
        Toast.makeText(view.getContext(), "Open the list of numbers", Toast.LENGTH_SHORT).show();
    }
}
