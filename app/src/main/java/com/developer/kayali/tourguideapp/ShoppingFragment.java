package com.developer.kayali.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ShoppingFragment extends Fragment {
    // Declare an ArrayList to store the Objects
    ArrayList<Event> events;

    // Constructor
    public ShoppingFragment() {
        // Required empty public constructor
    }

    // When Fragment and View Created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate a Root View
        View rootView = inflater.inflate(R.layout.events_list, container, false);
        // Initializing ArrayList
        events = new ArrayList<Event>();
        // Adding Objects to ArrayList
        // Event 1
        addEventInfo(R.drawable.bid_katharinenviertel, R.mipmap.ic_bid_katharinenviertel, R.array.shopping_event1);
        // Event 2
        addEventInfo(R.drawable.bid_marktquartier, R.mipmap.ic_bid_marktquartier, R.array.shopping_event2);
        // Event 3
        addEventInfo(R.drawable.bid_seltersweg, R.mipmap.ic_bid_seltersweg, R.array.shopping_event3);
        // Event 4
        addEventInfo(R.drawable.galerie, R.mipmap.ic_galerie, R.array.shopping_event4);
        // Event 5
        addEventInfo(R.drawable.giessener_wochenmarkt, R.mipmap.ic_giessener_wochenmarkt, R.array.shopping_event5);
        // Event 6
        addEventInfo(R.drawable.bid_marktquartier, R.mipmap.ic_bid_marktquartier, R.array.shopping_event6);

        // Declare an Adapter
        EventAdapter adapter = new EventAdapter(getActivity(), events, R.color.shoppingColor);
        // Initialize a ListView
        ListView listView = rootView.findViewById(R.id.list_view);
        // Set the Adapter to ListView
        listView.setAdapter(adapter);
        // When an Item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event currentWord = events.get(position);
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("eventImageID", currentWord.getEventImageID());
                intent.putExtra("eventName", currentWord.getEventName());
                intent.putExtra("eventAddress", currentWord.getAddress());
                intent.putExtra("eventDescription", currentWord.getDescription());
                getActivity().startActivity(intent);
            }
        });
        return rootView;
    }

    /**
     * get details of each Event from strings resource file according to tow parameters
     *
     * @param myStringResource Event ID (The name of String Array) in strings resource file
     * @param i                Index of each String in this Strung Array (0= Event Name, 1= Event Address, 2= Event Description)
     * @return Return Event Name, address, description from strings resource file to store in events ArrayList
     */
    private String getMyString(int myStringResource, int i) {
        String myString = getResources().getStringArray(myStringResource)[i];
        return myString;
    }

    /**
     * This Method is to add Event Details to events ArrayList according to three parameters
     *
     * @param eventImageID    Resource Id of Event Image
     * @param eventIconID     Resource Id of Event Icon
     * @param eventResourceID Resource Id of Event in strings resource file
     */
    private void addEventInfo(int eventImageID, int eventIconID, int eventResourceID) {
        events.add(new Event(eventImageID, eventIconID, getMyString(eventResourceID, 0), getMyString(eventResourceID, 1), getMyString(eventResourceID, 2)));
    }
}
