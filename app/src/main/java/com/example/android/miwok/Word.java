package com.example.android.miwok;

/**
 * Created by Vinay on 9/5/2017.
 */

public class Word {
    String mMiwokTranslation;
    String mDefaultTranslation;

    public Word(String defaultTranslation, String miwokTranslation){
        mMiwokTranslation=miwokTranslation;
        mDefaultTranslation=defaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
}
