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

public class MuseumsFragment extends Fragment {
    // Constructor
    public MuseumsFragment() {
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
        events.add(new Event(R.drawable.badenburg,R.mipmap.ic_badenburg, "Badenburg", "Inselweg 122\n" +
                "35396 Gießen","Badenburg\n" +
                "Essen und Trinken wie die alten Ritter\n" +
                "Die Badenburg liegt in idyllischer Lage an der Lahn. Sie wurde um 1530 als Herrensitz erbaut. Bereits um 1760 nahm man den Schankbetrieb auf und schon damals galt die Badenburg als beliebtes Ausflugsziel für Gießener Bürger und Studenten. Umstürzlerischen Kreisen diente die Badenburg gar als konspirativer Treffpunkt."));
        // Event 2
        events.add(new Event(R.drawable.giesskannenmuseum,R.mipmap.ic_giesskannenmuseum, "Neuigkeiten aus dem Gießkannenmuseum", "Keine Adresse","Öffentliche Führung am neuen Ort, Rückkehrer aus Österreich, neue Pflanzenlieferung von botanoadopt\n" +
                "Über regen Zuspruch freut sich das Team des Gießkannenmuseums seit Ende September: Die neue Bleibe des Museums bewährt sich als echter Glücksgriff und die Besucherzahlen sind seit dem Umzug sprunghaft angestiegen. Insbesondere an Samstagen geben sich Gießkannenfreunde in der Sonnenstraße die Klinke in die Hand. Aufgrund der regen Nachfrage bietet das GiKaMu nun noch vor dem Jahreswechsel eine öffentliche Führung an."));
        // Event 3
        events.add(new Event(R.drawable.kloster_arnsburg,R.mipmap.ic_kloster_arnsburg, "Kloster Arnsburg", "Kloster Arnsburg\n" +
                "Lich","Ein sehr bedeutendes Baudenkmal ist die Ruine des Zisterzienserklosters Arnsburg. Der eigentliche Gründer des Zisterzienserordens Bernhard von Clairvaux begrüßt in Stein gehauen mit Buch und Krummstab in der Hand die Besucher vom barocken Pfortenbau (1774-1777). Die Hinausziehenden segnet Maria mit Halbmond und Schlange."));
        // Event 4
        events.add(new Event(R.drawable.mathematikum,R.mipmap.ic_mathematikum, "Mathematikum", "Liebigstraße 8\n" +
                "35390 Gießen","Das einzigartige Mathematik-Mitmachmuseum\n" +
                "Hier dürfen große und kleine Besucher selbst experimentieren. Sie knobeln und puzzeln, sie bauen Brücken, experimentieren mit Seifenblasen und Spiegeln, erproben an sich den Goldenen Schnitt… und haben vor allem eins: Spaß an der Mathematik!"));
        // Event 5
        events.add(new Event(R.drawable.oberhessisches_museum,R.mipmap.ic_oberhessisches_museum, "Oberhessisches Museum - Wallenfels'sches Haus", "Kirchenplatz 6\n" +
                "35390 Gießen","Das Oberhessische Museum ist auf drei historische Gebäude verteilt, die die jeweiligen Abteilungen bzw. Sammlungen des Museums beherbergen:\n" +
                "1. Altes Schloss\n" +
                "Abteilung Gemäldegalerie und Kunsthandwerk sowie Sitz der Verwaltung und Museumsleitung\n" +
                "2.  Leib’sches Haus\n" +
                "Abteilung für Stadtgeschichte und Volkskunde\n" +
                "(hinter dem Stadtkirchenturm, unmittelbar neben dem Wallenfels´schen Haus gelegen)"));
        // Event 6
        events.add(new Event(R.drawable.badenburg,R.mipmap.ic_badenburg, "Badenburg", "Inselweg 122\n" +
                "35396 Gießen","Badenburg\n" +
                "Essen und Trinken wie die alten Ritter\n" +
                "Die Badenburg liegt in idyllischer Lage an der Lahn. Sie wurde um 1530 als Herrensitz erbaut. Bereits um 1760 nahm man den Schankbetrieb auf und schon damals galt die Badenburg als beliebtes Ausflugsziel für Gießener Bürger und Studenten. Umstürzlerischen Kreisen diente die Badenburg gar als konspirativer Treffpunkt."));
        // Declare an Adapter
        EventAdapter adapter = new EventAdapter(getActivity(), events, R.color.museumsColor);
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
