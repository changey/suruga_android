package com.suruga.tabandroid.listview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.suruga.tabandroid.AndroidTabLayoutActivity;
import com.suruga.tabandroid.Globals;
import com.suruga.tabandroid.Item;
import com.suruga.tabandroid.ItemListAdapter;
import com.suruga.tabandroid.R;
import com.suruga.tabandroid.selections.City;
import com.suruga.tabandroid.selections.CityActivity;
import com.suruga.tabandroid.selections.CityListAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailReviewActivity extends Activity {
	
	private DetailListAdapter adapter;
	
	String position = "1";

	String iconfile = "";
	ImageButton imgWeatherIcon;
	
	int rating_int=0;
	Item item=null;
	Globals g=Globals.getInstance();
	
	@SuppressLint("NewApi")
	@Override
	public void onResume() {
		super.onResume();

		final TextView rating = (TextView) findViewById(R.id.rating);
		
		Intent j = getIntent();

	    int index=j.getIntExtra("index", 0);
		
		item=g.getItems().get(index);
		
		rating_int=item.getRating();
		
		rating.setText(" "+String.valueOf(rating_int));
        
//		if(rating_int==0){
//			rating.setText(" ? ");
//		}
//		else{
//		    rating.setText(" "+String.valueOf(rating_int));
//		}
		
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.suruga.tabandroid.R.layout.detailreviewpage);
        
        final Button minus = (Button) findViewById(R.id.minus);
        final Button plus = (Button) findViewById(R.id.plus);
        final TextView rating = (TextView) findViewById(R.id.rating);
        
        Intent j = getIntent();
        
        //this.position = i.getStringExtra("position");
        rating_int=j.getIntExtra("rating", 0);
    
        
        ArrayList<Detail> details = new ArrayList<Detail>();
		details.add(new Detail(0, "Review your financial plan", "img1", false));
		
		setupListViewAdapter();
		
		// Toast.makeText(getApplicationContext(), details.get(0).getName(), Toast.LENGTH_LONG).show();


		for (int i = 0; i < details.size(); i++) {
			adapter.insert(details.get(i), i);
		}

        
		try {
			
	        Intent i = getIntent();
	        
	        this.position = i.getStringExtra("position");
	        //this.rating_int=i;
            
	        
	        String uri = "drawable/"+ "d" + iconfile;
	        int imageBtnResource = getResources().getIdentifier(uri, null, getPackageName());
			
		}
		
		catch (Exception ex) {
			Log.e("Error", "Loading exception");
		}
		
    }
    
    @SuppressLint("NewApi")
	public void cellOnClickHandler(View v) {

	}
    
    private void setupListViewAdapter() {
		adapter = new DetailListAdapter(DetailReviewActivity.this, R.layout.detail_row,
				new ArrayList<Detail>());
		ListView list = (ListView) findViewById(R.id.detaillist);

		list.setAdapter(adapter);

	}
	 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.suruga.tabandroid.R.menu.main, menu);
        return true;
    }
}
