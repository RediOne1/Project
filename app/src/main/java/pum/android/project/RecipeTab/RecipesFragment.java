package pum.android.project.RecipeTab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pum.android.project.R;
import pum.android.project.seba.JSONAsyn;
import pum.android.project.tools.Recipe;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipesFragment extends Fragment{

	private List<Recipe> recipeList;
	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager mLayoutManager;
    public RecipesFragment(){
    }
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

		mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		mRecyclerView.setHasFixedSize(true);

		// use a linear layout manager
		mLayoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);

		// specify an adapter (see also next example)
		adapter = new RecipeRecyclerViewAdapter(getActivity(), recipeList);
		mRecyclerView.setAdapter(adapter);
        JSONAsyn Async=new JSONAsyn();
        Async.execute("http://vps170438.ovh.net:9090/getRecipesList","recipesList");
        while(Async.rdy!=true){
            try{
                Thread.sleep(100);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        JSONArray ingArray = Async.getJsonAsync();
        try {
            for (int i = 0; i < ingArray.length(); i++) {
                JSONObject c = ingArray.getJSONObject(i);
                recipeList.add(new Recipe(Integer.parseInt(c.getString("id")), c.getString("name"), c.getString("image")));
                adapter.notifyDataSetChanged();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

		recipeList.add(new Recipe(1, "Cycki"));
		recipeList.add(new Recipe(2, "Więcej cycków"));
		recipeList.add(new Recipe(3, "Jeszcze więcej cycków"));
		recipeList.add(new Recipe(4, "O matko!"));
		recipeList.add(new Recipe(5, "I tatko!"));
		adapter.notifyDataSetChanged();
	}
}
