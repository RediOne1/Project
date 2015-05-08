package pum.android.project.RecipeTab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pum.android.project.R;
import pum.android.project.tools.Recipe;

/**
 * author:  Adrian Kuta
 * index:   204423
 * date:    08.05.15
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private List<Recipe> mDataset;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		public TextView title;
		public ImageView image;

		public ViewHolder(View itemView) {
			super(itemView);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(List<Recipe> myDataset) {
		this.mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
	                                               int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.recipe_list_item, parent, false);
		// set the view's size, margins, paddings and layout parameters

		ViewHolder vh = new ViewHolder(v);
		vh.image = (ImageView) v.findViewById(R.id.recipe_list_item_image);
		vh.title = (TextView) v.findViewById(R.id.recipe_list_item_title);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element]
		int resources[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
		holder.image.setImageResource(resources[position]);

		holder.title.setText(mDataset.get(position).name);

	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}
}
