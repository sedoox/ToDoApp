package de.sedoox.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_todo_lists);

        TextView name = findViewById(R.id.add_name);
        EditText date_created = findViewById(R.id.add_date_created);
        EditText date_valid_until = findViewById(R.id.add_date_valid_until);
        EditText max_todos = findViewById(R.id.add_max_todos);


        Button button = findViewById(R.id.add_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("date_created", date_created.getText().toString());
                System.out.println(date_created.getText().toString());
                intent.putExtra("date_valid_until", date_valid_until.getText().toString());
                intent.putExtra("max_todos", max_todos.getText().toString());
                setResult(RESULT_OK, intent);
                onBackPressed();
            }
        });
    }
}
