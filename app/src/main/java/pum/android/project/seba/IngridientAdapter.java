package pum.android.project.seba;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import java.util.List;

import pum.android.project.R;

/**
 * Created by seba on 08.05.15.
 */
public class IngridientAdapter extends BaseAdapter
{
    private LayoutInflater inflater;
    public IngridientAdapter(Context context){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public String getItem(int position) {
        return "0";
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return  convertView;
    }
}
