package pum.android.project.RecipeTab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import pum.android.project.R;
import pum.android.project.tools.Recipe;

/**
 * author:  Adrian Kuta
 * index:   204423
 * date:    08.05.15
 */
public class RecipeListAdapter extends BaseAdapter {

	private List<Recipe> recipeList;
	private LayoutInflater inflater;

	public RecipeListAdapter(Context context, List<Recipe> recipeList) {
		this.recipeList = recipeList;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return recipeList.size();
	}

	@Override
	public Recipe getItem(int position) {
		return recipeList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.recipe_list_item, parent, false);
			holder.image = (ImageView) convertView.findViewById(R.id.recipe_list_item_image);
			holder.title = (TextView) convertView.findViewById(R.id.recipe_list_item_title);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		if (getItem(position).images == null || getItem(position).images.size() == 0) {
			int resources[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
			Random random = new Random();
			int n = random.nextInt(resources.length);
			holder.image.setImageResource(resources[position]);
		}
		holder.title.setText(getItem(position).name);
		return convertView;
	}

	class ViewHolder {
		ImageView image;
		TextView title;
	}
}
