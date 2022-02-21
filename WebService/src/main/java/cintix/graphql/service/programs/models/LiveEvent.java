/*
 */
package cintix.graphql.service.programs.models;

import java.time.LocalDate;

/**
 *
 * @author migo
 */
public class LiveEvent implements Program {

    public int id;
    public String title;
    public String description;
    public String location;

    public LiveEvent(int id, String title, String description, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public LiveEvent() {
    }

    
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
