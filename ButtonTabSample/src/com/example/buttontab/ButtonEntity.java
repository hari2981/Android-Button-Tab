package com.example.buttontab;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.Button;

/**
 * 
 Button entity contains the properties of buttons
 * 
 * @author Harikrishnan
 * 
 */
public class ButtonEntity {

	private Button button;

	private Drawable defaultImage;
	private Drawable highlightImage;

	private int highlightColor = 0;
	private int defaultColor = 0;
	private int focusedColor = Color.BLACK;

	private int previousTextColor;

	public ButtonEntity(final Button button) {

		this.button = button;
	}

	public void onClick() {

	}

	public Button getButtonId() {
		return this.button;
	}

	public void setDefaultImage(final Drawable defaultImage) {
		this.defaultImage = defaultImage;
	}

	public void setHighlightImage(final Drawable highlightImage) {
		this.highlightImage = highlightImage;
	}

	public void setTextColorDefault(final int defaultColor) {
		this.defaultColor = defaultColor;
	}

	public void setTextColorHighlight(final int highlightColor) {
		this.highlightColor = highlightColor;
	}

	public void setTextFocusedColor(final int focused) {
		this.focusedColor = focused;
	}

	public void setHighlightStyle() {
		if (this.button != null && this.highlightImage != null) {
			this.button.setBackgroundDrawable(this.highlightImage);

			this.previousTextColor = this.highlightColor;

			if (!this.button.isFocused())
				this.button.setTextColor(this.highlightColor);
		}
	}

	public void setDefaultStyle() {
		if (this.button != null && this.defaultImage != null) {
			this.button.setBackgroundDrawable(this.defaultImage);

			this.previousTextColor = this.defaultColor;
			if (!this.button.isFocused())
				this.button.setTextColor(this.defaultColor);
		}
	}

	public void setFocus() {
		if (this.button != null)
			this.button.setTextColor(focusedColor);

	}

	public void setDefocusStyle() {
		if (this.button != null)
			this.button.setTextColor(this.previousTextColor);

	}
}
