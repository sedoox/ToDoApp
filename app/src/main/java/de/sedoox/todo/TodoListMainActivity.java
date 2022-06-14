package de.sedoox.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;


public class TodoListMainActivity extends AppCompatActivity {

    public static final String EXTRA_TODO_LISTE = "de.sedoox.todo.TodoListe";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list_main);

        Bundle data = getIntent().getExtras();
        TodoListe todoListe = (TodoListe) data.getParcelable(EXTRA_TODO_LISTE);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        TextView textView = findViewById(R.id.todo_name);
        textView.setText(todoListe.getName());
        textView = findViewById(R.id.todo_date_created);
        textView.setText("erstellt am: " + format.format(todoListe.getDate_created()));
        textView = findViewById(R.id.todo_date_valid_until);
        textView.setText("gültig bis: " + format.format(todoListe.getDate_valid_until()));
        textView = findViewById(R.id.todo_max_todos);
        textView.setText(String.valueOf(todoListe.getMax_todos()));

        findViewById(R.id.todo_add_todo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TodoListMainActivity.this, AddTodo.class);
                startActivityForResult(intent, 0);
            }
        });


    }

}