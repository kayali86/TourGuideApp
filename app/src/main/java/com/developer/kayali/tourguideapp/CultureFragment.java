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

public class CultureFragment extends Fragment {
    // Constructor
    public CultureFragment() {
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
        events.add(new Event(R.drawable.kiz,R.mipmap.ic_kiz, "KiZ (Kultur im Zentrum)", "Südanlage 3a\n" +
                "35390 Gießen","Veranstaltungsort für Kunst und Kultur in der ehemaligen Stadtbibliothek (Südanlage 3a)\n" +
                "Das KiZ befindet sich im hinteren Bauteil der Kongresshalle (Südanlage 3a, Eingang über den Parkplatz Kongresshalle erreichbar). Der Ausstellungs- und Veranstaltungsraum, der sich über zwei Etagen erstreckt, beherbergte früher die Stadtbibliothek, bevor diese im Rathaus ihr neues Domizil fand."));
        // Event 2
        events.add(new Event(R.drawable.literarisches_zentrum,R.mipmap.ic_literarisches_zentrum, "Literarisches Zentrum Gießen", "Südanlage 3a\n" +
                "35390 Gießen","Das Literarische Zentrum Gießen e.V. ist ein im November 2009 gegründeter Verein zur Pflege und Förderung der literarischen Tradition und Kultur der Universitätsstadt Gießen und ihrer Region.\n" +
                "Gießen verfügt über eine ausgeprägte literarische Infrastruktur: Neben literarischen Traditionen (begründet etwa von Nikolaus von Gießen, Johann Balthasar Schupp(ius), Friedrich Maximilian Klinger, Georg Büchner, Alfred Bock oder Ernst Eckstein), die auf vielfache Weise aktualisiert werden, besitzt Gießen ein breit gefächertes Angebot zur Gegenwartsliteratur. Hier spielen auch engagierte Autoren aus der Region eine entscheidende Rolle."));
        // Event 3
        events.add(new Event(R.drawable.literatur,R.mipmap.ic_literatur, "Literatur in allen Facetten - das neue LZG-Programm ist da!", "Keine Adresse","Das Programm des Literarischen Zentrums Gießen für das erste Quartal 2018\n" +
                "„Der Abend kommt von weit gegangen durch den verschneiten, leisen Tann. Dann presst er seine Winterwangen an alle Fenster lauschend an.“\n" +
                "Passend zur Jahreszeit begleiten die Worte von Rainer Maria Rilke die LZG-Termine von Januar bis März."));
        // Event 4
        events.add(new Event(R.drawable.osterzeit,R.mipmap.ic_osterzeit, "Osterzeit in den Gießener Kantoreien", "Johanneskirche & Petruskirche & St. Bonifatius","Die drei KantorInnen der Gießener Kantoreien tragen mit der von ihnen gestalteten Kirchenmusik in Gießen nicht unwesentlich zum kulturellen Angebot der Stadt bei.\n" +
                "Das ganze Jahr über – besonders aber in der Oster- und Weihnachtszeit – stellen die drei Kantoren ein hochkarätiges Programm zusammen.\n" +
                "Bereits ab Februar kann man wieder musikalisch gestaltete Gottesdienste mit den Musikern und Chören der Kantoreien und Gästen und natürlich die Passionskonzerte großer Komponisten besuchen."));
        // Event 5
        events.add(new Event(R.drawable.literarisches_zentrum,R.mipmap.ic_literarisches_zentrum, "Literarisches Zentrum Gießen", "Südanlage 3a\n" +
                "35390 Gießen","Das Literarische Zentrum Gießen e.V. ist ein im November 2009 gegründeter Verein zur Pflege und Förderung der literarischen Tradition und Kultur der Universitätsstadt Gießen und ihrer Region.\n" +
                "Gießen verfügt über eine ausgeprägte literarische Infrastruktur: Neben literarischen Traditionen (begründet etwa von Nikolaus von Gießen, Johann Balthasar Schupp(ius), Friedrich Maximilian Klinger, Georg Büchner, Alfred Bock oder Ernst Eckstein), die auf vielfache Weise aktualisiert werden, besitzt Gießen ein breit gefächertes Angebot zur Gegenwartsliteratur. Hier spielen auch engagierte Autoren aus der Region eine entscheidende Rolle."));
        // Event 6
        events.add(new Event(R.drawable.kiz,R.mipmap.ic_kiz, "KiZ (Kultur im Zentrum)", "Südanlage 3a\n" +
                "35390 Gießen","Veranstaltungsort für Kunst und Kultur in der ehemaligen Stadtbibliothek (Südanlage 3a)\n" +
                "Das KiZ befindet sich im hinteren Bauteil der Kongresshalle (Südanlage 3a, Eingang über den Parkplatz Kongresshalle erreichbar). Der Ausstellungs- und Veranstaltungsraum, der sich über zwei Etagen erstreckt, beherbergte früher die Stadtbibliothek, bevor diese im Rathaus ihr neues Domizil fand."));
        // Declare an Adapter
        EventAdapter adapter = new EventAdapter(getActivity(), events, R.color.cultureColor);
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
