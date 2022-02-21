/*
 */
package cintix.graphql.service.programs;

import cintix.graphql.service.programs.models.Collection;
import cintix.graphql.service.programs.models.Episode;
import cintix.graphql.service.programs.models.LiveEvent;
import cintix.graphql.service.programs.models.Program;
import cintix.graphql.service.programs.repository.ProgramRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author migo
 */
public class Query implements GraphQLQueryResolver {

    private ProgramRepository repository = new ProgramRepository();

    public Episode episode(int id) {
        return (Episode) repository.getEpisodes().stream()
                .filter(program -> program instanceof Program && program.id == id)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public LiveEvent event(int id) {
        return (LiveEvent) repository.getEvents().stream()
                .filter(liveEvent -> liveEvent instanceof LiveEvent && liveEvent.id == id)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public Collection collection() {
        return repository.getCollection();
    }

    public List<LiveEvent> events() {
        return repository.getEvents();
    }

    public List<Episode> episodes() {
        return repository.getEpisodes();
    }

    public Connection<Episode> list(int first, String after, DataFetchingEnvironment env) {  
        String cursorID = new String(Base64.getDecoder().decode(after));
        System.out.println("cursorID : " + cursorID);
        
        List<Episode> episodes = new ArrayList<>();
        episodes.addAll(repository.getEpisodes());
        episodes.addAll(repository.getCollection().episodes);   
        
        return new SimpleListConnection<>(episodes).get(env);
    }

}
