package com.example.contatos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

	private static final String API_KEY = "AIzaSyB1CM7_qEJJYONkzQ4qH0AFzCdB9135sOs";
	private String videoID;
	private YouTubePlayerView youtube;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		youtube = (YouTubePlayerView) findViewById(R.id.youtubeplayerview);
		youtube.initialize(API_KEY, this);
		
		videoID = getIntent().getStringExtra("URL");
		Toast.makeText(this, "ID video "+retiraIDYouTube(videoID), Toast.LENGTH_SHORT).show();

	}
	
	public String retiraIDYouTube(String url){
		String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
	    Pattern compiledPattern = Pattern.compile(pattern);
	    Matcher matcher = compiledPattern.matcher(url);

	    if(matcher.find()){
	        return matcher.group();
	    }else
	    	return "";
	}


	@Override
	public void onInitializationFailure(Provider provider,YouTubeInitializationResult error) {		
		Toast.makeText(this, "onInitializationFailure()", Toast.LENGTH_SHORT).show();		
	}


	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player,boolean wasRestored) {
		Log.i("MeuLog","Entrou no onInitializationSuccess");
		if (!wasRestored){			
			player.cueVideo(retiraIDYouTube(videoID));
		}
		
	}

}
