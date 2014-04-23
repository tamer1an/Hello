package com.tyco.visonic.interactive.fragmentapp.listadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tyco.visonic.interactive.R;

import java.util.List;

public class DetectorsListAdapter<T> extends ArrayAdapter<String> {

    public String[] Items;

    public DetectorsListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public DetectorsListAdapter(Context context, int resource, View view,
                     String[] strings) {
        super(context, resource, strings);

        Items = strings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //        View row = convertView;

        LayoutInflater inf = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inf.inflate(R.layout.detectors_list_item_2, parent, false);

        try {
            TextView tw = (TextView) row.findViewById(R.id.detectors_list_text_2);
            tw.setText("Testing...");
        }catch (NullPointerException ignored){

        }

        return row;  // return super.getView(position, convertView, parent);
    }
}

/*    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inf.inflate(R.layout.list_item, parent, false);
        String[] items = getResources().getStringArray(R.array.countries);

        ImageView iw = (ImageView) row.findViewById(R.id.imageView7);
        TextView tw = (TextView) row.findViewById(R.id.textView7);

        tw.setText(items[position]);

        if (items[position].equals("United State")){
            iw.setImageResource(R.drawable.usa);
        }else if(items[position].equals("Brazil")){
            iw.setImageResource(R.drawable.brazil);
        }else if(items[position].equals("Russia")){
            iw.setImageResource(R.drawable.russia);
        }else if(items[position].equals("Japan")){
            iw.setImageResource(R.drawable.japan);
        }else if(items[position].equals("Egypt")){
            iw.setImageResource(R.drawable.france);
        }

        return row; //			return super.getView(position, convertView, parent);
    }
}*/
