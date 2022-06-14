package de.sedoox.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TodoListenAdapter extends ArrayAdapter<TodoListe> {
    ArrayList<TodoListe> list;

    public TodoListenAdapter(Context context, ArrayList<TodoListe> list) {
        super(context, 0, list);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View element = inflater.inflate(R.layout.todo_list_row, null);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");


        TextView textView = element.findViewById(R.id.name);
        textView.setText(list.get(position).getName());
        textView = element.findViewById(R.id.date_created);
        if (list.get(position).getDate_created() != null) {
            textView.setText("erstellt am: " + format.format(list.get(position).getDate_created()));
        } else {
            textView.setText("erstellt am: -");
        }
        textView = element.findViewById(R.id.date_valid_until);
        if (list.get(position).getDate_created() != null) {
            textView.setText("gültig bis: " + format.format(list.get(position).getDate_valid_until()));
        } else {
            textView.setText("gültig bis: -");
        }

        return element;
    }
}
