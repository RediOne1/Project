package pum.android.project.seba;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.*;
import java.util.List;

import pum.android.project.MainTabActivity;
import pum.android.project.R;
import pum.android.project.tools.DownloadBitmap;
import pum.android.project.tools.Ingridients;
import pum.android.project.tools.displayingbitmaps.ImageFetcher;

/**
 * Created by seba on 08.05.15.
 */
public class IngridientAdapter extends BaseAdapter
{
    private List<Ingridients> ingList;
    private LayoutInflater inflater;
    ImageFetcher imf;

    public IngridientAdapter(Context context, ArrayList<Ingridients> ingList){
        this.ingList=ingList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return ingList.size();
    }

    @Override
    public Ingridients getItem(int position) {
        return ingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
          convertView = inflater.inflate(R.layout.ingridient, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        //ustawia obrazki z sieci albo placeholder
        if(getItem(position).image=="null"){
            imageView.setImageResource(parent.getResources().getIdentifier("image1","drawable","pum.android.project"));
        }else{
            new DownloadBitmap(imageView).execute(getItem(position).image);
        }
        //imageView.setImageResource(parent.getResources().getIdentifier(getItem(position).image,"drawable","pum.android.project"));
        TextView title = (TextView) convertView.findViewById(R.id.textView);
        title.setText(getItem(position).name);
        return  convertView;
    }
}
