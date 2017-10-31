package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;
/**
 * Created by pc-zhs on 2017/10/30.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";
    private String location_offset;
    private String primary_location;

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
        String mag = formatMagnitude(currentEarthquake.getMagnitude());
        ranke.setText(mag);

       //TextView location = (TextView) view.findViewById(R.id.location);
       //location.setText(currentEarthquake.getLocation());

        String twoLocations = currentEarthquake.getLocation();
        if(twoLocations.contains(LOCATION_SEPARATOR )) {
            String[] parts = twoLocations.split(LOCATION_SEPARATOR);
            location_offset = parts[0];
            primary_location =parts[1];

        } else {
            location_offset = getContext().getString(R.string.near_the);
            primary_location = twoLocations;
        }
        TextView location = (TextView) view.findViewById(R.id.location_offset);
        TextView primaryLocation = (TextView) view.findViewById(R.id.primary_location);
        location.setText(location_offset);
        primaryLocation.setText(primary_location);


        Date dateObject = new Date(currentEarthquake.getTime());
        String date= formatDate(dateObject);
        TextView date1= (TextView) view.findViewById(R.id.date);
        date1.setText(date);

        TextView time = (TextView) view.findViewById(R.id.time);
        String time1 = formatTime(dateObject);
        time.setText(time1);
        return  view;
    }

    private String  formatDate(Date dateObject) {
        SimpleDateFormat dateFormate  = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormate.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
