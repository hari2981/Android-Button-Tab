package com.example.buttontab;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * This is a sample which display three buttons act as tabs.
 * 
 * @author Harikrishnan
 * 
 */
public class Test extends Activity {
	/** Called when the activity is first created. */
	Button name;
	Button symbol;
	Button center;
	EditText user;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setupView();

	}

	private Drawable getResource(int id) {
		return getResources().getDrawable(id);
	}

	public void setupView() {
		name = (Button) findViewById(R.id.name);
		// center = (Button) findViewById(R.id.center);
		symbol = (Button) findViewById(R.id.symbol);
		user = (EditText) findViewById(R.id.username);



		// For each button you have to specify the default , highlight image.

		ButtonEntity nameEntity = new ButtonEntity(name) {
			@Override
			public void onClick() {
				user.setHint("Name");
			}
		};
		nameEntity.setDefaultImage(getResource(R.drawable.silver_button_left));
		nameEntity.setHighlightImage(getResource(R.drawable.green_button_left));
		nameEntity.setTextColorDefault(Color.GRAY);
		nameEntity.setTextColorHighlight(Color.WHITE);
		/*
		 * ButtonEntity centerEntity = new ButtonEntity(center) {
		 * 
		 * @Override public void onClick() { user.setHint("center"); } };
		 * centerEntity
		 * .setDefaultImage(getResource(R.drawable.silver_button_cr));
		 * centerEntity
		 * .setHighlightImage(getResource(R.drawable.green_button_cr));
		 * centerEntity.setTextColorDefault(Color.GRAY);
		 * centerEntity.setTextColorHighlight(Color.WHITE);
		 */
		ButtonEntity symbolEntity = new ButtonEntity(symbol) {
			@Override
			public void onClick() {
				user.setHint("symbol");
			}
		};
		symbolEntity.setDefaultImage(getResource(R.drawable.silver_button_right));
		symbolEntity.setHighlightImage(getResource(R.drawable.green_button_right));
		symbolEntity.setTextColorDefault(Color.GRAY);
		symbolEntity.setTextColorHighlight(Color.WHITE);

		ButtonEntity[] buttonGroup = { nameEntity, symbolEntity };

		// invoke Buttontab with an array of button as arguments
		new ButtonTab(buttonGroup);
	}

}
