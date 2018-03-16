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

public class RestaurantsFragment extends Fragment {
    // Constructor
    public RestaurantsFragment() {
        // Required empty public constructor
    }
    // When Fragment and View Created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate a Root View
        View rootView = inflater.inflate(R.layout.events_list, container, false);
        // Declare an ArrayList to store the Objects
        final ArrayList<Event> events = new ArrayList<Event>();
        // Adding Objects to ArrayList
        // Event 1
        events.add(new Event(R.drawable.bootshaus_restaurant,R.mipmap.ic_bootshaus_restaurant, "Bootshaus Restaurant & Biergarten", "Bootshausstr. 12\n" +
                "35390 Gießen","Bootshaus Restaurant & Biergarten\n" +
                "1877 als einfache Scheune von der Gießener Rudergesellschaft errichtet, erstrahlt das Bootshaus heute als modernes Restaurant in bester Lage an der Lahn. Im Verlauf der Jahrzehnte wechselte das Vereinsheim wiederholt sein Erscheinungsbild, bevor es 2006 dem heute zu sehenden Neubau wich. Ein besonderes Merkmal ist der bis zu 500 Gästen Platz bietende Biergarten am Flussufer."));
        // Event 2
        events.add(new Event(R.drawable.dachcafe,R.mipmap.ic_dachcafe, "Dachcafé", "Ludwigsplatz 11\n" +
                "35390 Gießen","In Sachen Ausblick über Gießen und das Umland ist ganz klar das Dachcafé die unangefochtene Nummer 1 in der Stadt. Nicht nur durch die Panoramafenster in Restaurant und Lounge-Bar genießt man einen herrlichen Ausblick über die Dächer der Stadt und das gesamte Umland. Eine Etage höher, auf der Sky-Bar, weht einem zusätzlich noch die frische Luft um die Nase. In einer der zahlreichen Sitznischen kann man im Sommer nicht nur die Köstlichkeiten aus der Dachcafé-Küche genießen, sondern auch einen der leckeren Cocktails schlürfen."));
        // Event 3
        events.add(new Event(R.drawable.lahngenuss_ruderclub,R.mipmap.ic_lahngenuss_ruderclub, "Lahngenuss im Ruderclub Hassia Gießen", "Uferweg 14\n" +
                "35398 Gießen","Lahngenuss im Ruderclub Hassia Gießen\n" +
                "Kenner wissen – das „Lahngenuss“ ist eine der besten Anlaufstellen, wenn es um Fleischgerichte und Gebratenes geht. Denn kaum einer versteht dieses Handwerk so gut wie Chef Erwin Schneider, der auch selber in der Küche steht. Und so erfreut sich das Lokal reger Beliebtheit – nicht nur bei den Mitgliedern des Ruderclubs Hassia, in dem das Speiselokal beheimatet ist."));
        // Event 4
        events.add(new Event(R.drawable.restaurant_kloster_schiffenberg,R.mipmap.ic_restaurant_kloster_schiffenberg, "Restaurant Kloster Schiffenberg", "Domäne Schiffenberg\n" +
                "35394 Gießen","Der beste Platz in Gießen – Ganz oben auf dem Berg\n" +
                "Rund fünf Kilometer südlich der Gießener Innenstadt erwartet Sie auf 281m Höhe ein gastlicher und geschichtsträchtiger Ort im Grünen, das Kloster Schiffenberg. Simone Dembeck & André Hohe sind Ihre Gastgeber. In und um seine alten Mauern ist das Kloster nicht nur ein Anziehungspunkt für alle geschichtlich Interessierten, sondern auch ein Freizeit- und Erholungsrevier zu allen Jahreszeiten."));
        // Event 5
        events.add(new Event(R.drawable.strand_cafe,R.mipmap.ic_strand_cafe, "Strand Café an der Lahn", "Zu den Mühlen 2a\n" +
                "35390 Gießen","Beach-Atmosphäre an der Lahn\n" +
                "Seit kurzem hat die beliebte Strandbar Gießen eine kleine Schwester bekommen. Direkt an der Lahn unterhalb der Sachsenhäuser Brücke und in fußläufiger Nähe zum Bahnhaltepunkt Oswaldsgarten betreibt Christian Trageser mit seinem Team nun zusätzlich das Strand Café. Bei kühlen Getränken und kleinen Speisen – die Karte ist an die der Strandbar angelehnt, bietet jedoch eine größere Eisauswahl und auch Kugeleis – kann man direkt am Fluss in Beachatmosphäre Verweilen und in den gemütlichen Liegestühlen einfach einmal die Seele baumeln lassen. Als Special werden leckere Flammkuchen gereicht."));
        // Event 6
        events.add(new Event(R.drawable.lahngenuss_ruderclub,R.mipmap.ic_lahngenuss_ruderclub, "Lahngenuss im Ruderclub Hassia Gießen", "Uferweg 14\n" +
                "35398 Gießen","Lahngenuss im Ruderclub Hassia Gießen\n" +
                "Kenner wissen – das „Lahngenuss“ ist eine der besten Anlaufstellen, wenn es um Fleischgerichte und Gebratenes geht. Denn kaum einer versteht dieses Handwerk so gut wie Chef Erwin Schneider, der auch selber in der Küche steht. Und so erfreut sich das Lokal reger Beliebtheit – nicht nur bei den Mitgliedern des Ruderclubs Hassia, in dem das Speiselokal beheimatet ist."));
        // Declare an Adapter
        EventAdapter adapter = new EventAdapter(getActivity(), events, R.color.restaurantsColor);
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

}
