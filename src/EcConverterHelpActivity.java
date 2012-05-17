/**
 * Copyright (C) Matt McCouaig, 2012.
 */

package uk.co.eclipsion.ecconverter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EcConverterHelpActivity extends Activity {
	
	TextView tvMain = (TextView) findViewById(R.id.tvHelp);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_layout);
	}

}
