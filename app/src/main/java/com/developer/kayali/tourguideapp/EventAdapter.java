package com.developer.kayali.tourguideapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {
    // A variable to store background color
    private int backgroundColorId;
    // Constructor
    public EventAdapter(Activity context, ArrayList<Event> events, int backgroundColorId) {
        super(context, 0,events);
        this.backgroundColorId = backgroundColorId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            // Inflate a view to use
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Specifies the current Event
        Event currentEvent = getItem(position);
        // Setting the background color
        LinearLayout textContainer = listItemView.findViewById(R.id.item_container);
        int color = ContextCompat.getColor(getContext(), backgroundColorId);
        textContainer.setBackgroundColor(color);
        // Setting Event Information to the Views
        ImageView imageView = listItemView.findViewById(R.id.icon_image_view);
        imageView.setImageResource(currentEvent.getEventIconID());
        TextView eventNameView = listItemView.findViewById(R.id.event_name_view);
        eventNameView.setText(currentEvent.getEventName());
        TextView eventAddressView = listItemView.findViewById(R.id.address_image_view);
        eventAddressView.setText(currentEvent.getAddress());
        return listItemView;
    }
}
