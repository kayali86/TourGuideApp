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

public class OutsideFragment extends Fragment {
    // Constructor
    public OutsideFragment() {
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
        events.add(new Event(R.drawable.botanische_garten, R.mipmap.ic_botanische_garten, "Der Botanische Garten in Gießen", "Sonnenstraße\n" +
                "35390 Gießen","Der Botanische Garten der Justus-Liebig-Universität öffnet vom 17. März bis 20. Oktober für Besucher\n" +
                "Im Herzen der Gießener Bürgerinnen und Bürger hat der Botanische Garten einen besonderen Platz. Mitten in der Stadt gelegen, bildet der knapp 4 ha große Garten mit seinen interessanten Pflanzen und den zahlreichen alten Bäumen eine grüne Oase der Ruhe für Erholungssuchende in der Mittagspause und Spaziergänger."));
        // Event 2
        events.add(new Event(R.drawable.der_giessener_wochenmarkt,R.mipmap.ic_der_giessener_wochenmarkt, "Der Gießener Wochenmarkt", "Brandplatz\n" +
                "35390 Gießen","Auf dem Gießener Wochenmarkt bieten rund 70 Händler und Selbsterzeuger an jedem Mittwoch und Samstag von 7.00 bis 14.00 Uhr ihre Produkte an, die durch Qualität und Frische überzeugen."));
        // Event 3
        events.add(new Event(R.drawable.lahnfenster_hessen,R.mipmap.ic_lahnfenster_hessen, "Lahnfenster Hessen - Ein Blick in den Fluss werfen", "Bootshausstraße 8\n" +
                "35390 Gießen","Meteorologisch hat der Frühling bereits begonnen. Ob dies auch unter Wasser der Fall ist, lässt sich anhand eines Blickes durch das Lahnfenster in Gießen feststellen. Denn dort schwimmen vor allem im Frühjahr Fische auf der Wanderung zu ihren Laichgebieten an den großen Beobachtungsscheiben vorbei, wenn Sie das Wehr passieren wollen. Ab und zu kann auch ein Schwarm Jungfische entdeckt werden, der im dort platzierten Totholz Unterschlupf sucht."));
        // Event 4
        events.add(new Event(R.drawable.marine_verein_giessen,R.mipmap.ic_marine_verein_giessen, "Marine-Verein Gießen e. V.", "Wißmarer Weg 31\n" +
                "35396 Gießen","Der Marine-Verein Gießen 1892 e.V.\n" +
                "Lust auf eine gemütliche Bootsfahrt auf der Lahn? Dann sind Sie beim Marine-Verein genau richtig, denn hier können Sie mit den Ausflugsbooten eine Fahrt auf der Lahn genießen. Die Boote des Marine-Vereins kann man zu verschiedenen Anlässen chartern und einen Ausflug auf der Lahn genießen."));
        // Event 5
        events.add(new Event(R.drawable.schlittschuhlaufe,R.mipmap.ic_schlittschuhlaufe, "Schlittschuhlaufen zu Studienzwecken", "Kischenplatz\n" +
                "Gießen","JLU-Seminarteilnehmer üben Praxis mit Gießener Schülern auf der Eisbahn am Kirchenplatz\n" +
                "\n" +
                "„Rollen, gleiten, fahren“ – so heißt ein Seminar im Fachbereich 06 Sportwissenschaften der Justus-Liebig-Universität Gießen unter der Leitung von Thorsten Bringmann. In dem Seminar lernen angehende Lehrkräfte – Gymnasiallehrer, Förderschullehrer, aber auch Grundschullehrer – in unterschiedlichen Anwendungsfeldern Bewegungsübungen für Schulklassen zu entwickeln. Die Theorie aus dem Seminar setzten Kursteilnehmer am Freitag auf der Eisbahn am Kirchenplatz nun in die Praxis um: Für die Schüler der 9C der Gesamtschule Gießen-Ost hatten sich die Studierenden einen Übungsparcours überlegt, um ihnen mehr Sicherheit auf dem Eis zu vermitteln."));
        // Event 6
        events.add(new Event(R.drawable.stadtpark_wieseckaue,R.mipmap.ic_stadtpark_wieseckaue, "Stadtpark Wieseckaue", "Ringallee\n" +
                "35390 Gießen","Stadtpark Wieseckaue\n" +
                "Ein Park für alle, für Freizeit und Bewegung mitten in der Stadt – das ist die Grundidee des Stadtpark Wieseckaue, Gießens größter Grünanlage. Im Stadtpark Wieseckaue finden alle zueinander und kommen gemeinsam in Bewegung."));
        // Declare an Adapter
        EventAdapter adapter = new EventAdapter(getActivity(), events, R.color.outsideColor);
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
