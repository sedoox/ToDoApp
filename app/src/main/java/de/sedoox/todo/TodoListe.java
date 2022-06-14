package de.sedoox.todo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class TodoListe implements Parcelable {

    private String name;
    private Date date_created;
    private Date date_valid_until;
    private int max_todos;


    public TodoListe(String name, Date date_created, Date date_valid_until) {
        this.name = name;
        this.date_created = date_created;
        this.date_valid_until = date_valid_until;
        this.max_todos = -1;
    }

    public TodoListe(String name, Date date_created, Date date_valid_until, int max_todos) {
        this.name = name;
        this.date_created = date_created;
        this.date_valid_until = date_valid_until;
        this.max_todos = max_todos;
    }

    protected TodoListe(Parcel in) {
        name = in.readString();
        date_created = (Date) in.readSerializable();
        date_valid_until = (Date) in.readSerializable();
        max_todos = in.readInt();
    }

    public static final Creator<TodoListe> CREATOR = new Creator<TodoListe>() {
        @Override
        public TodoListe createFromParcel(Parcel in) {
            return new TodoListe(in);
        }

        @Override
        public TodoListe[] newArray(int size) {
            return new TodoListe[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_valid_until() {
        return date_valid_until;
    }

    public void setDate_valid_until(Date date_valid_until) {
        this.date_valid_until = date_valid_until;
    }

    public int getMax_todos() {
        return max_todos;
    }

    public void setMax_todos(int max_todos) {
        this.max_todos = max_todos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeSerializable(date_created);
        parcel.writeSerializable(date_valid_until);
        parcel.writeInt(max_todos);
    }
}
