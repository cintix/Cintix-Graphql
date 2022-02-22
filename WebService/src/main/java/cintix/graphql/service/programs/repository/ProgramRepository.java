/*
 */
package cintix.graphql.service.programs.repository;

import cintix.graphql.service.programs.models.Collection;
import cintix.graphql.service.programs.models.Episode;
import cintix.graphql.service.programs.models.LiveEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author migo
 */
public class ProgramRepository {

    private final List<Episode> episodes = new LinkedList<>();
    private final List<LiveEvent> events = new LinkedList<>();
    private final Collection friends = new Collection();

    public ProgramRepository() {

        episodes.add(new Episode(1, "Badehotelet afsnit 1", "Vi mødes alle sammen for første gang", new Date().toString()));
        episodes.add(new Episode(2, "Badehotelet afsnit 2", "Når vandet er for koldt", new Date().toString()));
        episodes.add(new Episode(3, "Badehotelet afsnit 3", "Knapperne foran eller bagved", new Date().toString()));
        episodes.add(new Episode(4, "Badehotelet afsnit 4", "Skal vi drikke dus", new Date().toString()));
        episodes.add(new Episode(5, "Badehotelet afsnit 5", "Tidevandet fjerner alle spor", new Date().toString()));
        episodes.add(new Episode(6, "Badehotelet afsnit 6", "Midsommernat", new Date().toString()));
        episodes.add(new Episode(7, "Badehotelet afsnit 7", "Fra korn til Ørken", new Date().toString()));
        episodes.add(new Episode(8, "Badehotelet afsnit 8", "Krig - fra radio til vindu", new Date().toString()));

        events.add(new LiveEvent(1, "Batman:ton - Kamp 1:6 (Bane)", "Fight for rights!", "Gotham City"));
        events.add(new LiveEvent(2, "Batman:ton - Kamp 2:6 (Riddler)", "Fight for rights!", "Gotham City"));
        events.add(new LiveEvent(3, "Batman:ton - Kamp 3:6 (PVIN)", "Fight for rights!", "Gotham City"));
        events.add(new LiveEvent(4, "Batman:ton - Kamp 4:6 (Catwoman)", "Fight for rights!", "Gotham City"));
        events.add(new LiveEvent(5, "Batman:ton - Kamp 5:6 (Deadshot)", "Fight for rights!", "Gotham City"));
        events.add(new LiveEvent(6, "Batman:ton - Kamp 6:6 (Joker)", "Fight for rights!", "Gotham City"));
        
        List<Episode> friendsEpisodes = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            Episode episode = new Episode(index + 100, "Friends #" + (index + 100), "episode #" + (index + 100), new Date().toString());
            friendsEpisodes.add(episode);
        }
       
        friends.setEpisodes(friendsEpisodes);

    }

    public Collection getFriends() {
        return friends;
    }
    
    

    public Collection getCollection() {
        return friends;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public List<LiveEvent> getEvents() {
        return events;
    }

}
