package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pc-zhs on 2017/10/30.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

   public EarthquakeAdapter(Context context,
                            List<Earthquake> objects) {
       super(context,0,objects);

   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View view = convertView;
        if(view==null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_listitem,parent,false);

        }
            Earthquake currentEarthquake = getItem(position);
        TextView ranke = (TextView) view.findViewById(R.id.rank);
        ranke.setText(currentEarthquake.getMagnitude());
        TextView location = (TextView) view.findViewById(R.id.location);
        location.setText(currentEarthquake.getLocation());
        TextView date = (TextView) view.findViewById(R.id.date);
        date.setText(currentEarthquake.getDate());
        return  view;
    }
}
