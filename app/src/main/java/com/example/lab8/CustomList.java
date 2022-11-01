package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount() {
        return cities.size();
    }

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void addCity(City city) {
        cities.add(city);
    }

    /**
     * This returns whether or not the city belongs in the list
     *  @param city
     *  @return
     * Return true or false
     */
    public boolean hasCities(City city) {
        return false;
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List getCities() {
        return null;
    }

    /**
     * This checks if a city is present in the list. If it does then remove it from the list, if not then throw an exception
     * @param city
     */
    public void deleteCities(City city) {

    }

    /**
     * This returns how many cities are in the list
     * @return
     * Returns count
     */
    public int countCities() {
        return 0;
    }

}
