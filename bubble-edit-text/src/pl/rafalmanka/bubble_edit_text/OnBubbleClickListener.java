package pl.rafalmanka.bubble_edit_text;

import android.view.View;

public interface OnBubbleClickListener {
	/**
	 * 
	 * @param view
	 *            - BubbleEditText
	 * @param linkSpec
	 *            - object containing text that was clicked, start and stop
	 *            position
	 */
	public void onBubbleClick(View view, Hyperlink linkSpec);
}
