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

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {
	private List<Recipe> recipeList;

	public RecipeRecyclerViewAdapter(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	@Override
	public RecipeRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.recipe_list_item, parent, false);

		ViewHolder vh = new ViewHolder(v);
		vh.image = (ImageView) v.findViewById(R.id.recipe_list_item_image);
		vh.title = (TextView) v.findViewById(R.id.recipe_list_item_title);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		int resources[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
		holder.image.setImageResource(resources[position]);

		holder.title.setText(recipeList.get(position).name);

	}

	@Override
	public int getItemCount() {
		return recipeList.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView title;
		public ImageView image;

		public ViewHolder(View itemView) {
			super(itemView);
		}
	}
}
