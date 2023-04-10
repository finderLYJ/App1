package com.example.app1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        Intent intent=getIntent();
        Uri uri=Uri.parse(intent.getStringExtra("uri"));
        title=findViewById(R.id.title_videoplay);
        title.setText(intent.getStringExtra("title"));
        videoView=findViewById(R.id.videoView);
        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(VideoPlayActivity.this));
    }
}