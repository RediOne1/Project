package pum.android.project.seba;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pum.android.project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LodowkaFragment extends ListFragment implements View.OnClickListener {


	public LodowkaFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_lodowka, container, false);
	}
    public void onClick(View v){

    }
}
