package pum.android.project.seba;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pum.android.project.R;

/**
 * Created by seba on 08.05.15.
 */
public class IngridientAdapter extends BaseAdapter
{
    private List<String> ingList;
    private LayoutInflater inflater;

    public IngridientAdapter(Context context, List<String> ingList){
        this.ingList=ingList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ingList.size();
    }

    @Override
    public String getItem(int position) {
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
        imageView.setBackgroundColor(00000);
        TextView title = (TextView) convertView.findViewById(R.id.textView);
        title.setText(getItem(position));
        return  convertView;
    }
}
