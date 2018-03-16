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
        // Declare an ArrayList to store the Objects
        final ArrayList<Event> events = new ArrayList<Event>();
        // Adding Objects to ArrayList
        // Event 1
        events.add(new Event(R.drawable.bid_katharinenviertel,R.mipmap.ic_bid_katharinenviertel, "BID Katharinenviertel e. V.", "Katharinenviertel\n" +
                "Gießen","Willkommen im Katharinenviertel, der Bühne der Stadt und geselliger Treffpunkt – nicht zuletzt für Familien!\n" +
                "\n" +
                "Hier trifft sich die Familie: Im Katharinenviertel, dem Wohlfühlquartier mit überschaubarer Center-Struktur. Neben der Angebotsvielfalt der Galaria Kaufhof finden sich in den feingliedrigen Verästelungen des City-Centers und den Seitenstraßen niveauvolle Boutiquen, Parfümerien, Wohnaccesoires und viel, viel Entdeckenswertes. In den vielen inhabergeführten Fachgeschäften werden Sie kompetent und freundlich beraten. Service und Auswahl wird hier „groß“-geschrieben."));
        // Event 2
        events.add(new Event(R.drawable.bid_marktquartier,R.mipmap.ic_bid_marktquartier, "BID Marktquartier", "Marktquartier\n" +
                "Gießen","Marktquartier e.V. – Der Verein für das Herz Gießens\n" +
                "Was macht das Marktquartier zu etwas ganz Besonderem? Als his\u00ADtorischer Kern der Stadt kann das Viertel für sich in Anspruch nehmen, seit jeher die Wiege des Gießener Einzelhandels zu sein. Die große Breite auch an ausgefallenen Angeboten und die persönliche Beratung mit vielen Gelegenheiten für ein kleines Schwätzchen. Die Sicherheit, Servicequalität und das Qualitätsversprechen, das ein\u00ADgesessene Unternehmen mit Gießener Wurzeln bieten können. Die Bequemlichkeit kurzer Wege im Quartier sowie die Atmosphäre einer gewachsenen Stadtstruktur prägen diesen Ort für Entdeckungen, die sich über die Kaskaden der Plätze bis in all ihre Verästelungen wiederfinden."));
        // Event 3
        events.add(new Event(R.drawable.bid_seltersweg,R.mipmap.ic_bid_seltersweg, "BID Seltersweg", "Seltersweg\n" +
                "Gießen","Der Seltersweg – Boulevard der Marken!\n" +
                "Wir heißen Sie herzlich Willkommen auf dem urbanen Laufsteg der Region. Eingebettet in historische Fassaden flanieren täglich zahlreiche bummelnde Menschen durch Mittelhessens Einkaufsmeile Nr.1."));
        // Event 4
        events.add(new Event(R.drawable.galerie,R.mipmap.ic_galerie, "Galerie Neustädter Tor", "Neustadt 28\n" +
                "35390 Gießen","Entdecken Sie einen bunten Mietermix: Ob Mode, Accessoires, Elektronik, Sport oder Gastronomie – hier bleiben keine Wünsche offen. H&M, Müller, Reno, tegut, Media Markt, Intersport, Apollo Optik, Claire’s, Jack&Jones, O2, Penny, Subway, Vero Moda und viele andere Mieter warten auf Ihren Besuch."));
        // Event 5
        events.add(new Event(R.drawable.giessener_wochenmarkt,R.mipmap.ic_giessener_wochenmarkt, "Der Gießener Wochenmarkt", "Brandplatz\n" +
                "35390 Gießen","Auf dem Gießener Wochenmarkt bieten rund 70 Händler und Selbsterzeuger an jedem Mittwoch und Samstag von 7.00 bis 14.00 Uhr ihre Produkte an, die durch Qualität und Frische überzeugen."));
        // Event 6
        events.add(new Event(R.drawable.bid_marktquartier,R.mipmap.ic_bid_marktquartier, "BID Marktquartier", "Marktquartier\n" +
                "Gießen","Marktquartier e.V. – Der Verein für das Herz Gießens\n" +
                "Was macht das Marktquartier zu etwas ganz Besonderem? Als his\u00ADtorischer Kern der Stadt kann das Viertel für sich in Anspruch nehmen, seit jeher die Wiege des Gießener Einzelhandels zu sein. Die große Breite auch an ausgefallenen Angeboten und die persönliche Beratung mit vielen Gelegenheiten für ein kleines Schwätzchen. Die Sicherheit, Servicequalität und das Qualitätsversprechen, das ein\u00ADgesessene Unternehmen mit Gießener Wurzeln bieten können. Die Bequemlichkeit kurzer Wege im Quartier sowie die Atmosphäre einer gewachsenen Stadtstruktur prägen diesen Ort für Entdeckungen, die sich über die Kaskaden der Plätze bis in all ihre Verästelungen wiederfinden."));
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

}
