package com.example.buttontab;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;

/**
 * 
 * Handles the group of buttons
 * 
 * @author Harikrishnan
 * 
 */
public class ButtonTab {

	private ButtonEntity buttonGroup[];
	private ButtonListener[] listener;
	private ButtonClickListener[] clickListeners;

	private ButtonEntity previousButtonEntity;

	public ButtonTab(final ButtonEntity[] buttonGroup) {
		this.buttonGroup = buttonGroup;
		listener = new ButtonListener[buttonGroup.length];
		clickListeners = new ButtonClickListener[buttonGroup.length];
		start();
	}

	private void start() {

		// Set the first button as selected
		previousButtonEntity = buttonGroup[0];
		setupHighlight(previousButtonEntity);
		listener[0] = new ButtonListener(previousButtonEntity);
		clickListeners[0] = new ButtonClickListener(previousButtonEntity);
		previousButtonEntity.getButtonId()
				.setOnFocusChangeListener(listener[0]);
		previousButtonEntity.getButtonId()
				.setOnClickListener(clickListeners[0]);

		// Set the other buttons as not selected
		for (int i = 1; i < buttonGroup.length; i++) {
			setupDefault(buttonGroup[i]);
			listener[i] = new ButtonListener(buttonGroup[i]);
			buttonGroup[i].getButtonId().setOnFocusChangeListener(listener[i]);

			clickListeners[i] = new ButtonClickListener(buttonGroup[i]);
			buttonGroup[i].getButtonId().setOnClickListener(clickListeners[i]);

		}
	}

	private void setupHighlight(ButtonEntity button) {
		button.setHighlightStyle();
		button.onClick();
	}

	private void setupDefault(ButtonEntity button) {
		button.setDefaultStyle();
	}

	private void setupFocus(ButtonEntity button) {
		button.setFocus();
	}

	private void setupDeFocus(ButtonEntity button) {
		button.setDefocusStyle();
	}

	/**
	 * 
	 * This Listener set the button style
	 * 
	 * @author Harikrishnan R
	 * 
	 */
	class ButtonListener implements OnFocusChangeListener {

		private ButtonEntity buttonEntity;

		public ButtonListener(final ButtonEntity buttonEntity) {
			this.buttonEntity = buttonEntity;
		}

		@Override
		public void onFocusChange(View v, boolean hasFocus) {

			if (hasFocus)
				setupFocus(buttonEntity);
			else
				setupDeFocus(buttonEntity);

		}

	}

	class ButtonClickListener implements OnClickListener {

		private ButtonEntity buttonEntity;

		public ButtonClickListener(final ButtonEntity buttonEntity) {
			this.buttonEntity = buttonEntity;

		}

		@Override
		public void onClick(View v) {

			if (previousButtonEntity != buttonEntity) {

				setupHighlight(buttonEntity);
				setupDefault(previousButtonEntity);
				previousButtonEntity = buttonEntity;

			}
		}

	}

}
