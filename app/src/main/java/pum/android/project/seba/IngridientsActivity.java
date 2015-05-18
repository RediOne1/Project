package pum.android.project.seba;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import pum.android.project.R;
import pum.android.project.RecipeTab.RecipesFragment;

/**
 * Created by seba on 18.05.15.
 */
public class IngridientsActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingridients_activity);
        String post=getIntent().getStringExtra("post");
        Bundle message = new Bundle();

        /*RecipesFragment fragment =  new RecipesFragment();
        message.putString("post",post);
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        fragment.setArguments(message);
        transaction.replace(R.id.ihavenoidea ,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //RecipesFragment fragment =  new RecipesFragment();
        fragmentTransaction.add(R.id.ihavenoidea, new RecipesFragment());
        fragmentTransaction.commit();*/


    }
}
