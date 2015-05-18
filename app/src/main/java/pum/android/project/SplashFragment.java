package pum.android.project;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pum.android.project.tools.Recipe;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {


	public SplashFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_splash, container, false);
	}

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String ing="kruszony lód, ketchup";
        String desc="Do kruszonego lodu dodaj ketchup, mo¿na posypac bu³k¹ tart¹.";
        Recipe recipe=new Recipe(1,"Ketchup z kruszonym lodem",ing,desc);
        ImageView image= (ImageView) view.findViewById(R.id.mainImage);
        image.setImageResource(R.drawable.image1);
        TextView header= (TextView) view.findViewById(R.id.header);
        header.setText(recipe.name);

        TextView descr= (TextView) view.findViewById(R.id.description);
        descr.setText(recipe.description);

        TextView ingr= (TextView) view.findViewById(R.id.ingridients);
        ingr.setText(recipe.ingredients);
    }
}
