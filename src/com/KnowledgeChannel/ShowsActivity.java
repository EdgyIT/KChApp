package com.KnowledgeChannel;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ShowsActivity extends ListActivity implements OnItemClickListener {
	String value;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shows);
        
        ListView lvPerson=(ListView)findViewById(android.R.id.list);
        lvPerson.setOnItemClickListener(this);
        
        DBHelper db = new DBHelper(this);        
        db.open();    
        Cursor c = null;
        
        Bundle extras = getIntent().getExtras(); 
        if(extras != null) {
        	value = extras.getString("keyName");
        	if (value.equals("CL")) {
        		c = db.getAllCL();
        	}
        	else if (value.equals("TE")) {
        		c = db.getAllTE();
        	}
        	else if (value.equals("FLE")) {
        		c = db.getAllFLE();
        	}
        	else if (value.equals("M")) {
        		c = db.getAllM();
        	}
        	else if (value.equals("ST")) {
        		c = db.getAllST();
        	}
        	else if (value.equals("SSV")) {
        		c = db.getAllSSV();
        	}
        	else if (value.equals("NCA")) {
        		c = db.getAllNCA();
        	}
        }
        
        startManagingCursor(c);
        String[] columns = new String[] {db.KEY_CATEGORY };
        int[] to = new int[] {R.id.quote_entry };
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.list_format, c, columns, to);
        this.setListAdapter(mAdapter);
    }

    public void onItemClick(AdapterView arg0, View v, int position, long arg3) {
    	// TODO Auto-generated method stub
    	String url = "";
    	if (value.equals("CL")) {
    		switch (position) {
    			case 0: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=105FDEAED999DA75";break;//Alikabuk
    			case 1: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=5944789BFA2D0BA3";break;//Gab to Go
    			case 2: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en_US&client=mv-google&p=1786F81048CB1AC0";break;//Karen's World
    		}	
    	}
    	else if (value.equals("TE")) {
    		switch (position) {
				case 0: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=17AC5BDE62DC91F8";break;//Faculty Room
				case 1: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=69B47918D1565B72";break;//Power to Empower
    		}
    	}
    	else if (value.equals("FLE")) {
    		switch (position) {
				case 0: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=F44E799337FFB988";break;//Estudyantipid
				case 1: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=BD80949B0BF85B71";break;//Estudyantipid2
				case 2: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=DC9DC546E14E5A93";break;//Estudyantipid3
				case 3: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=C139FDD0564F3ACA";break;//Negosyo Ko, Asenso Ko
    		}
    	}
    	else if (value.equals("M")) {
    		switch (position) {
				case 0: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=F3A77ABFACC50266";break;//K-Math High
				case 1: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=968465B308122A1A";break;//Solved
    		}
    	}
    	else if (value.equals("ST")) {
    		switch (position) {
				case 0: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=1E8DABB6298E9E0B";break;//Agham Aralin
				case 1: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=D25EDE9F17F6FF17";break;//K-Hub Biology
				case 2: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=0C6D1A0556B10BB9";break;//K-Science High
				case 3: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=4882E91084703163";break;//Mi Isla
				case 4: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=AFA051E51B05B384";break;//Web Works
				case 5: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=8F59211460A839F9";break;//Why
    		}
    	}
    	else if (value.equals("SSV")) {
    		switch (position) {
				case 0: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=26E81AB61ADF8A22";break;//Kasaysayan TV
				case 1: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=2E84422209FCEADA";break;//Pamana
				case 2: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=39E00D255DC2CA6F";break;//Salam(Elementary)
				case 3: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=594F9685CAAA217D";break;//Salam High School
				case 4: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=3AFDCEA724C5F986";break;//Wow
    		}
    	}
    	
    	else if (value.equals("NCA")) {
    		switch (position) {
				case 0: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=23B82EDE377BBAE3";break;//K-NOW
				case 1: url = "http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=01D5E14002B66626";break;//RLB Hour
    		}
    	} 
    	
    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    	//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.youtube.com/view_playlist?gl=PH&hl=en&client=mv-google&p=105FDEAED999DA75")));
    }
}
