package com.suruga.tabandroid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.suruga.tabandroid.listview.DetailActivity;

public class ItemActivity extends Activity {
	
	private ItemListAdapter adapter;
	private ArrayList<String> itemsSelected=new ArrayList<String>();
	//private boolean selected=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		setupListViewAdapter();
		
		//add all the house items
		ArrayList<Item> items=new ArrayList<Item>();
		items.add(new Item(0, "House 1", "img1", false, 0, 0,"Tokyo", "", "", true, "", "", 0, 0, 0));
		items.add(new Item(1, "House 2", "img2", false, 500000000, 0,"Tokyo", "", "", true, "", "", 0, 0, 0));
		items.add(new Item(2, "House 3", "img21", false,0, 0,"", "", "", true, "", "", 0, 0, 0));
		items.add(new Item(3, "House 4", "img22", false,0, 0,"", "", "", true, "", "", 0, 0, 0));
		items.add(new Item(4, "House 5", "img3", false,0, 0,"", "", "", true, "", "", 0, 0, 0));
		items.add(new Item(5, "House 6", "img4", false,0, 0,"", "", "", true, "", "", 0, 0, 0));
		
		for (int i=0;i<items.size();i++){
			adapter.insert(items.get(i),i);
		}
        
	}
	
	@SuppressLint("NewApi")
	public void cellOnClickHandler(View v) {
		

		ItemListAdapter.ItemHolder itemHolder= (ItemListAdapter.ItemHolder) v.getTag();
		int position=itemHolder.item.getId();
		boolean selected=itemHolder.item.getSelected();
		
//		SharedPreferences prefs = this.getSharedPreferences(
//			      "com.suruga.tabandroid", Context.MODE_MULTI_PROCESS);
//		Editor editor = prefs.edit();
		
		
		if (selected==false){
			itemsSelected.add(String.valueOf(position));
			Set<String> set = new HashSet<String>();
			set.addAll(itemsSelected);
			
			AndroidTabLayoutActivity.selectedHouses=set;
			
			itemHolder.arrow.setImageResource(R.drawable.check);
			itemHolder.info.setVisibility(View.INVISIBLE);
			
			itemHolder.item.setSelected(true);
		    
		}
		else{
			itemsSelected.remove(String.valueOf(position));
			Set<String> set = new HashSet<String>();
			set.addAll(itemsSelected);
			
			AndroidTabLayoutActivity.selectedHouses=set;
			
			itemHolder.info.setVisibility(View.VISIBLE);
			itemHolder.info.setImageResource(R.drawable.information);
			itemHolder.arrow.setImageResource(R.drawable.arrow);
			
			itemHolder.item.setSelected(false);

			
		}
		
	}

	public void infoOnClickHandler(View v) {
		
		//itemHolder.
		
		Item itemSelected = (Item) v.getTag();
		
		Intent i = new Intent();
		
		i.setClass(ItemActivity.this, DetailActivity.class);
		//Toast.makeText(getApplicationContext(), itemselected.toString(), Toast.LENGTH_LONG).show();

		// parameters
		i.putExtra("rating", itemSelected.getRating());
		// i.putExtra("position", String.valueOf(position + 1));

		// start the detail page
		startActivity(i);
		
	}

	private void setupListViewAdapter() {
		adapter = new ItemListAdapter(ItemActivity.this,
				R.layout.list_item_row, new ArrayList<Item>());
		ListView list = (ListView) findViewById(R.id.itemList);

		list.setAdapter(adapter);
		

	}
}