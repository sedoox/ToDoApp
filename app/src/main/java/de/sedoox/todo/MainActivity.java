package de.sedoox.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<TodoListe> exampleTodoLists;
    TodoListenAdapter todoListenAdapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date_created = null;
        Date date_valid_until = null;
        int max_todos = -1;
        try {
            date_created = format.parse(data.getStringExtra("date_created"));
            date_valid_until = format.parse(data.getStringExtra("date_valid_until"));
            max_todos = Integer.valueOf(data.getStringExtra("max_todos"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        exampleTodoLists.add(new TodoListe(data.getStringExtra("name"), date_created, date_valid_until, max_todos));
        todoListenAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleTodoLists = new ArrayList(Arrays.asList(new TodoListe("Aufgaben", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()), new TodoListe("Haus", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 3)));
        listView = findViewById(R.id.listView);
        todoListenAdapter = new TodoListenAdapter(this, exampleTodoLists);
        listView.setAdapter(todoListenAdapter);

        Intent intent = new Intent(this, AddListActivity.class);

        Button button = findViewById(R.id.todo_add_todo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, 0);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, TodoListMainActivity.class);
                intent.putExtra(TodoListMainActivity.EXTRA_TODO_LISTE, exampleTodoLists.get(i));
                startActivity(intent);
            }
        });


    }


}