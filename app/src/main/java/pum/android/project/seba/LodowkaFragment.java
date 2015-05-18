package pum.android.project.seba;



import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pum.android.project.R;

public class LodowkaFragment extends ListFragment implements View.OnClickListener, ListView.OnItemClickListener, ListView.OnItemLongClickListener {
    private ListView lv;
    private ArrayList<String> ingList;
    private IngridientAdapter ingridientAdapter;
    int i=0;
	public LodowkaFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_lodowka, container, false);
        return view;
	}
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button addButton = (Button) getActivity().findViewById(R.id.add_button);
        addButton.setOnClickListener(this);
        lv = getListView();
        ingList = new ArrayList<>();
        ingridientAdapter = new IngridientAdapter(getActivity(),ingList);
        lv.setAdapter(ingridientAdapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
        ingList.add("cos");
        ingList.add("cos2");
        ingList.add("cos3");
        ingridientAdapter.notifyDataSetChanged();


    }

    public void onClick(View v){
        Toast.makeText(getActivity(), "sad" + Integer.toString(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(),"sad2",Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        i++;
        Toast.makeText(getActivity(),"sad2",Toast.LENGTH_SHORT).show();
    }
}
