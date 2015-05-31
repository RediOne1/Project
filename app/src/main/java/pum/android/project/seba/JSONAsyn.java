package pum.android.project.seba;

import android.util.Log;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pum.android.project.tools.JSONParser;
import pum.android.project.tools.displayingbitmaps.AsyncTask;

/**
 * Created by seba on 31.05.15.
 */
public class JSONAsyn extends AsyncTask<String,Void,Void> {
    JSONParser jsonP=new JSONParser();
    JSONObject jObj;
    JSONArray ingArray;
    public boolean rdy=false;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String ... params) {
        List<NameValuePair> param=new ArrayList<>();

        try {
            //jObj = jsonP.makeHttpRequest("http://vps170438.ovh.net:9090/getIngridientsList", "GET", param);
            jObj = jsonP.makeHttpRequest(params[0],"GET",param);
            Log.d("Response", jObj.toString());
            ingArray = jObj.getJSONArray(params[1]);
            //ingArray = jObj.getJSONArray("ingridientsList");
            rdy=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        rdy=true;
    }
    public JSONArray getJsonAsync(){
        return ingArray;
    }
}
