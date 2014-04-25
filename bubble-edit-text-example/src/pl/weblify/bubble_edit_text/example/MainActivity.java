package pl.weblify.bubble_edit_text.example;

import pl.weblify.bubble_edit_text.BubbleEditText;
import pl.weblify.bubble_edit_text.Hyperlink;
import pl.weblify.bubble_edit_text.OnBubbleClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private ListView mListView;
	private BubbleEditText mBubbleEditText;

	private String[] mHarryPotterSpells = { "Aguamenti", "Alohomora",
			"Anapneo", "Aparecium", "Avada Kedavra" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// first lets import the views and set adapter to listview
		setupViews();
		setupListView();

		// we want to get a callback when user clicks on a bubble
		mBubbleEditText.setOnBubbleClickListener(new MyOnBubbleClickListener());
		// this sets weather bubble will have this x icon at the right edge
		mBubbleEditText.setRemoveIcon(true);

	}

	private void setupListView() {
		// set adapter to listview
		mListView.setAdapter(getAdapter());
		// we will listen to what the user selects from listview
		mListView.setOnItemClickListener(new MyOnItemClickListener());
	}

	private ArrayAdapter<String> getAdapter() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_list_item_1,
				mHarryPotterSpells);
		return adapter;
	}

	private class MyOnBubbleClickListener implements OnBubbleClickListener {

		@Override
		public void onBubbleClick(View view, Hyperlink linkSpec) {
			Log.v(TAG, "onBubbleClick");
			// we can do whatever You want with this click event. In this case
			// we simply remove the bubble.
			mBubbleEditText.removeBubble(linkSpec);

		}

	}

	/**
	 * import all the views that we will use in this activity
	 */
	private void setupViews() {

		mListView = (ListView) findViewById(R.id.listView);
		mBubbleEditText = (BubbleEditText) findViewById(R.id.editText);

	}

	/**
	 * instance of this class will allow us to get callback on the listview so
	 * we know which position the user selected
	 * 
	 * @author rafal
	 * 
	 */
	private class MyOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// get string that the user clicked
			String spell = mHarryPotterSpells[position];
			// add text that is going to be wrapped in bubble
			mBubbleEditText.addBubbleText(spell);
			// set text to textView, including one that is wrapped in bubble
			mBubbleEditText.setText(mBubbleEditText.getText() + spell + " ");
		}

	}

}
