package com.example.android.miwok;

/**
 * Created by Vinay on 9/7/2017.
 */

public class ReportCard {
    String mName, mCmpe207Grade, mCmpe200Grade, mCmpe239Grade, mCmpe277Grade;

    public ReportCard(String name, String cmpe207Grade, String cmpe200Grade, String cmpe239Grade, String cmpe277Grade){
        mName=name;
        mCmpe207Grade=cmpe207Grade;
        mCmpe200Grade=cmpe200Grade;
        mCmpe239Grade=cmpe239Grade;
        mCmpe277Grade=cmpe277Grade;
    }

    public String getName(){
        return mName;
    }

    public void setName(String name){
        mName=name;
    }

    public String getCmpe207Grade(){
        return mCmpe207Grade;
    }

    public void setCmpe207Grade(String grade){
        mCmpe207Grade=grade;
    }

    public String getCmpe200Grade(){
        return mCmpe200Grade;
    }

    public void setCmpe200Grade(String grade){
        mCmpe200Grade=grade;
    }

    public String getCmpe239Grade(){
        return mCmpe239Grade;
    }

    public void setCmpe239Grade(String grade){
        mCmpe239Grade=grade;
    }

    public String getCmpe277Grade(){
        return mCmpe277Grade;
    }

    public void setCmpe277Grade(String grade){
        mCmpe277Grade=grade;
    }

    public String toString(){
        return String.format("Name: {0}; CMPE 207 Grade: {1}; CMPE 200 Grade: {2}; " +
                "CMPE 239 Grade: {3}; CMPE 277 Grade:{4}",getName(), getCmpe207Grade(), getCmpe200Grade(), getCmpe239Grade(),
                getCmpe277Grade());
    }
}
