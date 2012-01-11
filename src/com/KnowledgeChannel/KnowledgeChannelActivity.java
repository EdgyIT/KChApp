package com.KnowledgeChannel;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;

import android.widget.VideoView;

public class KnowledgeChannelActivity extends Activity {
	
	String viewSource1 ="rtsp://v2.cache2.c.youtube.com/CjYLENy73wIaLQk4yIKcLgEXoRMYJCAkFEIJbXYtZ29vZ2xlSARSBXdhdGNoYM3-4IjTk6X0Tgw=/0/0/0/video.3gp";
    String viewSource2 ="rtsp://v3.cache7.c.youtube.com/CjYLENy73wIaLQkpgwiacHcCWBMYJCAkFEIJbXYtZ29vZ2xlSARSBXdhdGNoYM3-4IjTk6X0Tgw=/0/0/0/video.3gp";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //VideoView
        
        
        VideoView myVideoView1 = (VideoView)findViewById(R.id.videoView1);
        VideoView myVideoView2 = (VideoView)findViewById(R.id.videoView1);
        
        //String viewSource1 ="rtsp://v2.cache2.c.youtube.com/CjYLENy73wIaLQk4yIKcLgEXoRMYJCAkFEIJbXYtZ29vZ2xlSARSBXdhdGNoYM3-4IjTk6X0Tgw=/0/0/0/video.3gp";
       //String viewSource2 ="rtsp://v3.cache7.c.youtube.com/CjYLENy73wIaLQkpgwiacHcCWBMYJCAkFEIJbXYtZ29vZ2xlSARSBXdhdGNoYM3-4IjTk6X0Tgw=/0/0/0/video.3gp";
      
        myVideoView1.setVideoURI(Uri.parse(viewSource1));
        myVideoView1.setMediaController(new MediaController(this));
        myVideoView1.requestFocus();
        myVideoView1.start();
        
        myVideoView2.setVideoURI(Uri.parse(viewSource2));
        myVideoView2.setMediaController(new MediaController(this));
        myVideoView2.requestFocus();
        myVideoView2.start();
        
        //END
        
        Button btnBrowse = (Button)findViewById(R.id.button2);
        //registerForContextMenu(btnBrowse);
        //openContextMenu(btnBrowse);
        //unregisterForContextMenu(btnBrowse);
        
        OnClickListener ocl = new OnClickListener(){
        	public void onClick(View sender){
        		registerForContextMenu(sender); 
                openContextMenu(sender);
                unregisterForContextMenu(sender);
        	}
        };        
        btnBrowse.setOnClickListener(ocl);     

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = new MenuInflater(this);
    	inflater.inflate(R.menu.optionsmenu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
        case R.id.MENU_ABOUT:
        	Intent intentAbout = new Intent(KnowledgeChannelActivity.this,About.class);
        	startActivity(intentAbout);
        	return true;
        //case R.id.MENU_BROWSE:
        	
        //Don't know what to do	
        	
        //	return true;
        case R.id.MENU_EXIT:
        	finish();
        default: 
        	return false;
        }
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    	MenuInflater inflater = new MenuInflater(this);
    	inflater.inflate(R.menu.categorymenu, menu);
	}
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	Intent intent = null; 
    	switch(item.getItemId()){
    	 case R.id.MENU_CL:
    		intent = new Intent(KnowledgeChannelActivity.this,ShowsActivity.class);
    		intent.putExtra("keyName", "CL");
	    	startActivity(intent);
         	return true;
    	 case R.id.MENU_TE:
    		intent = new Intent(KnowledgeChannelActivity.this,ShowsActivity.class);
     		intent.putExtra("keyName", "TE");
 	    	startActivity(intent);
         	return true;
    	 case R.id.MENU_FLE:
    		intent = new Intent(KnowledgeChannelActivity.this,ShowsActivity.class);
     		intent.putExtra("keyName", "FLE");
 	    	startActivity(intent);
          	return true;
    	 case R.id.MENU_M:
    		intent = new Intent(KnowledgeChannelActivity.this,ShowsActivity.class);
     		intent.putExtra("keyName", "M");
 	    	startActivity(intent);
          	return true;
     	 case R.id.MENU_ST:
     		intent = new Intent(KnowledgeChannelActivity.this,ShowsActivity.class);
    		intent.putExtra("keyName", "ST");
	    	startActivity(intent);
         	return true;
     	 case R.id.MENU_SSV:
     		intent = new Intent(KnowledgeChannelActivity.this,ShowsActivity.class);
    		intent.putExtra("keyName", "SSV");
	    	startActivity(intent);
         	return true;
         	
     	 case R.id.MENU_NCA:
     		intent = new Intent(KnowledgeChannelActivity.this,ShowsActivity.class);
    		intent.putExtra("keyName", "NCA");
	    	startActivity(intent);
         	return true;
         	
    	 default:
    		 return false;
    	 } 
    }
}