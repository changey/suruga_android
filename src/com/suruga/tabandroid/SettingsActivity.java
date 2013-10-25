package com.suruga.tabandroid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.suruga.tabandroid.listview.HouseInfoActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsActivity extends Activity {

	private SettingListAdapter adapter;
	private ArrayList<String> itemsSelected=new ArrayList<String>();
	//private boolean selected=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		setupListViewAdapter();
		
		//add all the house items
		ArrayList<Item> items=new ArrayList<Item>();
		items.add(new Item(0, "City", "img1", false, 0));
		items.add(new Item(1, "Interested In", "img2", false, 500000000));
		items.add(new Item(2, "Monthly Budget", "img21", false,0));
		items.add(new Item(3, "Savings", "img22", false,0));
		
		for (int i=0;i<items.size();i++){
			adapter.insert(items.get(i),i);
		}
        
	}
	
	@SuppressLint("NewApi")
	public void cellOnClickHandler(View v) {
		

		//ItemListAdapter.ItemHolder itemHolder= (ItemListAdapter.ItemHolder) v.getTag();
		
		Intent i = new Intent();
		i.setClass(SettingsActivity.this, com.suruga.tabandroid.selections.CityActivity.class);

		startActivity(i);
		
//		if (selected==false){
//			itemsSelected.add(String.valueOf(position));
//			Set<String> set = new HashSet<String>();
//			set.addAll(itemsSelected);
//			
//			AndroidTabLayoutActivity.selectedHouses=set;
//			
//			//editor.putStringSet("key", set);
//			//editor.commit();
//			
//			itemHolder.arrow.setImageResource(R.drawable.check);
//			itemHolder.info.setVisibility(View.INVISIBLE);
//			
//			itemHolder.item.setSelected(true);
//		    //selected=true;
//		    
//		    
//		    
//		}
//		else{
//			itemsSelected.remove(String.valueOf(position));
//			Set<String> set = new HashSet<String>();
//			set.addAll(itemsSelected);
//			
//			AndroidTabLayoutActivity.selectedHouses=set;
//			//g.setSelectedHouses(set);
//			//editor.putStringSet("key", set);
//			//editor.commit();
//			
//			itemHolder.info.setVisibility(View.VISIBLE);
//			itemHolder.info.setImageResource(R.drawable.information);
//			itemHolder.arrow.setImageResource(R.drawable.arrow);
//			
//			itemHolder.item.setSelected(false);
//			//selected=false;
//			
//			
//		}
		
	}

//	public void infoOnClickHandler(View v) {
//		
//		
//		Item itemToRemove = (Item) v.getTag();
//		
//		Intent i = new Intent();
//		i.setClass(SettingsActivity.this, HouseInfoActivity.class);
//
//		// parameters
//		// i.putExtra("position", String.valueOf(position + 1));
//
//		/*
//		 * selected item parameters 1. House number 2. Weather 3. Wind speed 4.
//		 * Temperature 5. Weather icon
//		 */
//		// i.putExtra("number",
//		// weatherDataCollection.get(position).get(KEY_CITY));
//		// i.putExtra("weather",
//		// weatherDataCollection.get(position).get(KEY_CONDN));
//
//		// start the detail page
//		startActivity(i);
//		
//	}

	private void setupListViewAdapter() {
		adapter = new SettingListAdapter(SettingsActivity.this,
				R.layout.setting_row, new ArrayList<Item>());
		ListView list = (ListView) findViewById(R.id.itemList);

		list.setAdapter(adapter);
		

	}

}