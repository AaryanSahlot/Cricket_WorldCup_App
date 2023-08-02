package com.mastercoding.worldcupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {

    private ArrayList<CountryModelClass> countryArrayList;
    Context context;

    public CustomAdapter(ArrayList<CountryModelClass> data, Context context){
        super(context, R.layout.ltem_list_layoout, data);
        this.countryArrayList = data;
        this.context = context;

    }

    //View lookup cache
    private static class ViewHolder{
        TextView textCountry;
        TextView textcupWins;
        ImageView flagImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // get the data item for this position
        CountryModelClass dataModel = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        final View result;

        if (convertView==null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.ltem_list_layoout,
                    parent,
                    false);

            viewHolder.textCountry = (TextView) convertView.findViewById(R.id.tVCountryName);
            viewHolder.textcupWins = (TextView) convertView.findViewById(R.id.tVwins);
            viewHolder.flagImage = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        //how to get the data from th country model class

        viewHolder.textCountry.setText(dataModel.getCountry_name());
        viewHolder.textcupWins.setText(dataModel.getCup_win_count());
        viewHolder.flagImage.setImageResource(dataModel.getFlag_img());


        return convertView;



    }
}
