package com.example.android.miwok;

import android.graphics.drawable.Drawable;

/**
 * Created by Vinay on 9/5/2017.
 */

public class Word {
    String mMiwokTranslation;
    String mDefaultTranslation;
    int mImageResourceId=-1;

    public Word(String defaultTranslation, String miwokTranslation){
        mMiwokTranslation=miwokTranslation;
        mDefaultTranslation=defaultTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){
        mMiwokTranslation=miwokTranslation;
        mDefaultTranslation=defaultTranslation;
        mImageResourceId=imageResourceId;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){ return mImageResourceId; }
}
