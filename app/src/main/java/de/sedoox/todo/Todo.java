package de.sedoox.todo;

import java.util.Date;

public class Todo {
    private String name;
    private String description;
    private Date date_created;


    public Todo(String name, String description, Date date_created) {
        this.name = name;
        this.description = description;
        this.date_created = date_created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }
}
