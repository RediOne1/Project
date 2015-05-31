package pum.android.project.seba;


import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pum.android.project.R;
import pum.android.project.tools.Ingridients;
import pum.android.project.tools.JSONParser;
/*fragment odpowiada za wyglÄ…d i dziaÅ‚anie lodÃ³wki
*/
public class LodowkaFragment extends ListFragment implements View.OnClickListener, ListView.OnItemClickListener, ListView.OnItemLongClickListener {
    private ListView lv;
    private ArrayList<Ingridients> ingList;
    private IngridientAdapter ingridientAdapter;
    int i=0;
    String HTMLlist[];
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
        /*pobieranie danych z serwera
          w formacie JSON
         */
        JSONAsyn Async=new JSONAsyn();
        Async.execute("http://vps170438.ovh.net:9090/getIngridientsList","ingridientsList");
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
                ingList.add(new Ingridients(Integer.parseInt(c.getString("id")), c.getString("name"), c.getString("image")));
                ingridientAdapter.notifyDataSetChanged();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //przechowuje wybrane skÅ‚adniki
        HTMLlist=new String[ingList.size()];
    }

    public void onClick(View v){
        String header="http://vps170438.ovh.net:9090/getRecipeByIng/";
        if (HTMLlist.length==0){
            Toast.makeText(getActivity(), "Proszê wybraæ sk³adnik", Toast.LENGTH_SHORT).show();
            return;
        }
        int i=0;
        //dodaje skÅ‚adniki do zapytania
        for(i=0;i<HTMLlist.length;i++){
            if(HTMLlist[i]!=null)
                if(i<HTMLlist.length-1) {
                    header = header +"'"+ HTMLlist[i] + "',";
                }else{
                    header =header +"'" + HTMLlist[i] + "\'";
                }

        }
        Toast.makeText(getActivity(), header, Toast.LENGTH_SHORT).show();
        //przekazywanie danych do activity
        Intent ingridientPost = new Intent(getActivity(), IngridientsActivity.class);
        ingridientPost.putExtra("post", header);
        startActivity(ingridientPost);
    }
    //nie uzywane
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(),"sad2",Toast.LENGTH_SHORT).show();
        return true;
    }

    //po naciœniêciu przycisku szukaj
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String message;
        int  colorTable[]={Color.BLACK, Color.WHITE};
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        ColorDrawable color =(ColorDrawable)imageView.getBackground();//pobiera kolor t³a
        //zmienia kolor i wykonuje zale¿n¹ akcjê
        if(color.getColor()==colorTable[0]){
            imageView.setBackgroundColor(colorTable[1]);
            HTMLlist[position]=Long.toString(ingList.get(position).id);
            message = "Dodano skÅ‚adnik ";
        }else{
            imageView.setBackgroundColor(colorTable[0]);
            HTMLlist[position]="";
            message="UsuniÄ™to skÅ‚adnik ";
        }
        Toast.makeText(getActivity(),message+ingList.get(position).name,Toast.LENGTH_SHORT).show();

    }
}
