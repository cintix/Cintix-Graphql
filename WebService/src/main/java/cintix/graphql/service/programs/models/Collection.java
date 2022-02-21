/*
 */
package cintix.graphql.service.programs.models;

import java.util.List;

/**
 *
 * @author migo
 */
public class Collection {
    public List<Episode> episodes;

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
    
}
