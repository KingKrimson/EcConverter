/**
 * Copyright (C) Matt McCouaig, 2012.
 */

package uk.co.eclipsion.ecconverter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EcConverterMainActivity extends ListActivity {
	
	private final int TEMP = 0, WEIGHT = 1, HEIGHT = 2, LENGTH = 3, AREA = 4, VOLUME = 5, VELOCITY = 6, PRESSURE = 7;
	private final int MENU_HELP = 1, MENU_ABOUT = 2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String[] listItems = getResources().getStringArray(R.array.main_listView_entries);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.main, listItems));
        
        ListView mainListView = getListView();
        mainListView.setTextFilterEnabled(true);
        
        final Intent i = new Intent(this, EcConverterActivity.class);
        
        mainListView.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		switch(position) {
        		case TEMP:
        			i.putExtra("Temperature", TEMP);
        			break;
        		case WEIGHT:
        			i.putExtra("Weight", WEIGHT);
        			break;
        		case HEIGHT:
        			i.putExtra("Height", HEIGHT);
        			break;
        		case LENGTH:
        			i.putExtra("Length", LENGTH);
        			break;
        		case AREA:
        			i.putExtra("Area", AREA);
        			break;
        		case VOLUME:
        			i.putExtra("Volume", VOLUME);
        			break;
        		case VELOCITY:
        			i.putExtra("Velocity", VELOCITY);
        			break;
        		case PRESSURE:
        			i.putExtra("Pressure", PRESSURE);
        			break;
        		default:
        			break;
        		}
        		startActivity(i);
        	}
        });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_HELP, 0, R.string.menu_help);
		menu.getItem(0).setIcon(R.drawable.ic_menu_name_help);
		menu.add(0, MENU_ABOUT, 1, R.string.menu_about);
		menu.getItem(1).setIcon(R.drawable.ic_menu_about);
		boolean result = super.onCreateOptionsMenu(menu);
		return result;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case MENU_HELP:
			onHelpClicked();
			return true;
		case MENU_ABOUT:
			onAboutClicked();
			return true;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	private void onAboutClicked() {
		
	}

	public void onHelpClicked() {
		Intent i = new Intent(this, EcConverterHelpActivity.class);
		startActivity(i);
	}
}