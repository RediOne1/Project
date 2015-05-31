package pum.android.project.RecipeTab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pum.android.project.MainTabActivity;
import pum.android.project.R;
import pum.android.project.seba.IngridientsActivity;
import pum.android.project.tools.Recipe;
import pum.android.project.tools.displayingbitmaps.ImageFetcher;

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {
	public List<Recipe> recipeList;
	private ImageFetcher imageFetcher;

	public RecipeRecyclerViewAdapter(Context context, List<Recipe> recipeList) {
		try{
            imageFetcher = ((MainTabActivity) context).getImageFetcher();
        }catch (Exception ex){
            imageFetcher = ((IngridientsActivity) context).getImageFetcher();
        }
		this.recipeList = recipeList;
	}

	@Override
	public RecipeRecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.recipe_list_item, parent, false);

		ViewHolder vh = new ViewHolder(v, new ViewHolder.RecipeListener() {
			@Override
			public void onRecipeClick(int position) {
				//TODO tutaj ustaw jakie activity ma byc uruchamiane
				/*Intent intent = new Intent(parent.getContext(), IngridientsActivity.class);
				long id = recipeList.get(position).id;
				intent.putExtra("id", id);
				parent.getContext().startActivity(intent);*/
				Toast.makeText(parent.getContext(), "Wybrano " + recipeList.get(position).name, Toast.LENGTH_SHORT).show();
			}
		});
		vh.image = (ImageView) v.findViewById(R.id.recipe_list_item_image);
		vh.title = (TextView) v.findViewById(R.id.recipe_list_item_title);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		String resources[] = {"http://i.imgur.com/PTFiBo5.jpg",
				"http://i.imgur.com/PTFiBo5.jpg",
				"http://i.imgur.com/PTFiBo5.jpg",
				"http://i.imgur.com/PTFiBo5.jpg",
				"http://i.imgur.com/PTFiBo5.jpg"};
		/*if(recipeList.get(position).image=="null"){
		    holder.image.setImageResource(resources[1]);
        }else{
            new DownloadBitmap(holder.image).execute(recipeList.get(position).image);
        }
		*/
        if(recipeList.get(position).image!=null) {
            imageFetcher.loadImage(recipeList.get(position).image, holder.image);
        }else{
            imageFetcher.loadImage(resources[1], holder.image);
        }
        holder.title.setText(recipeList.get(position).name);

	}

	@Override
	public int getItemCount() {
		return recipeList.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		public TextView title;
		public ImageView image;
		private RecipeListener listener;

		public ViewHolder(View itemView, RecipeListener listener) {
			super(itemView);
			this.listener = listener;
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			listener.onRecipeClick(getAdapterPosition());
		}

		public interface RecipeListener {
			void onRecipeClick(int position);
		}
	}
}
