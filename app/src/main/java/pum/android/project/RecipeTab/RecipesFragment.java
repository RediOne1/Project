package pum.android.project.RecipeTab;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pum.android.project.R;
import pum.android.project.tools.Recipe;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipesFragment extends ListFragment {

	private RecipeListAdapter adapter;
	private List<Recipe> recipeList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_recipes, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		recipeList = new ArrayList<>();
		ListView lv = getListView();
		adapter = new RecipeListAdapter(getActivity(), recipeList);
		lv.setAdapter(adapter);
		recipeList.add(new Recipe("Cycki"));
		recipeList.add(new Recipe("Więcej cycków"));
		recipeList.add(new Recipe("Jeszcze więcej cycków"));
		recipeList.add(new Recipe("O matko!"));
		recipeList.add(new Recipe("I tatko!"));
		adapter.notifyDataSetChanged();
	}
}
