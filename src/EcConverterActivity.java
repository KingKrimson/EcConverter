/**
 * Copyright (C) Matt McCouaig, 2012.
 */

package uk.co.eclipsion.ecconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EcConverterActivity extends Activity {

	private static final int MENU_HELP = 0, MENU_ABOUT = 1;
	private Spinner spinLHS, spinRHS;
	private TextView tvTitle, tvConvertedValue;
	private EditText editTextBox;
	private Button convertButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.converter_layout);
		
		spinLHS = (Spinner) findViewById(R.id.spinLHS);
		spinRHS = (Spinner) findViewById(R.id.spinRHS);
		tvTitle  = (TextView) findViewById(R.id.tvTitle);
		tvConvertedValue  = (TextView) findViewById(R.id.tvConvertedValue);
		editTextBox = (EditText) findViewById(R.id.editTextBox);
		convertButton = (Button) findViewById(R.id.convertButton);
		
		// Obtains the value passed in through the Intent.
		Bundle extras = getIntent().getExtras();
		
		// Sets up the components correctly for each resource.
		if (extras.containsKey("Temperature")) {
			initComponents(R.string.convert_title_temp, R.array.spinner_temp);
		} else if (extras.containsKey("Weight")) {
			initComponents(R.string.convert_title_weight, R.array.spinner_weight);
		} else if (extras.containsKey("Height")) {
			initComponents(R.string.convert_title_height, R.array.spinner_height);
		} else if (extras.containsKey("Length")) {
			initComponents(R.string.convert_title_length, R.array.spinner_length);
		} else if (extras.containsKey("Area")) {
			initComponents(R.string.convert_title_area, R.array.spinner_area);
		} else if (extras.containsKey("Volume")) {
			initComponents(R.string.convert_title_volume, R.array.spinner_volume);
		} else if (extras.containsKey("Velocity")) {
			initComponents(R.string.convert_title_velocity, R.array.spinner_velocity);
		} else if (extras.containsKey("Pressure")) {
			initComponents(R.string.convert_title_pressure, R.array.spinner_pressure);
		} else {
			// Send message declaring bug occured, no catagories picked correctly.
			// Take back to menu.
			Intent i = new Intent(this, EcConverterMainActivity.class);
			startActivity(i); // Check for memory leaks here. Activity loop.
		}
		
		// Sets up an event listener for when the button is pressed.
		convertButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				convert();
			}
		});
	}
	
	// Menu making nonsense below. Creating it, what happens on selection, and the methods for the selection.
	
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
	
	// Gets the correct conversion and applies the value to the textbox.
	public void convert() {
		String originalValue = editTextBox.getText().toString();
		
	}
	
	// Creates the spinner data adapter and returns it.
	public ArrayAdapter<CharSequence> setSpinner(int arrayResource) {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrayResource, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		return adapter;
	}
	
	// Initilises the components based on the user's choice on the main menu.
	private void initComponents(int titleText, int spinSet) {
		tvTitle.setText(titleText);
		spinLHS.setAdapter(setSpinner(spinSet));
		spinRHS.setAdapter(setSpinner(spinSet));
	}
}
