package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager am;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange){
                case AudioManager.AUDIOFOCUS_GAIN:
                    mMediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayerResources();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;
            }
        }
    };
    MediaPlayer.OnCompletionListener onCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayerResources();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        am =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ArrayList<Word> colors=new ArrayList<Word>();
        colors.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colors.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        colors.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colors.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colors.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter adapter=new WordAdapter(this, colors, R.color.category_colors);
        ListView listview=(ListView)findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord= (Word) parent.getItemAtPosition(position);
                int audioResourceId=currentWord.getAudioResourceId();
                releaseMediaPlayerResources();
                int result=am.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer=MediaPlayer.create(ColorsActivity.this, audioResourceId);
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
    }

    public void releaseMediaPlayerResources(){
        if(mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
            am.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayerResources();
    }
}
