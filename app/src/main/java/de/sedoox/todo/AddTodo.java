package de.sedoox.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTodo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_todo);

        Button button = findViewById(R.id.add_todo_submit);
        EditText name = findViewById(R.id.add_todo_name);
        EditText description = findViewById(R.id.add_todo_description);
        EditText date_created = findViewById(R.id.add_todo_date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("description", description.getText().toString());
                intent.putExtra("date_created", date_created.getText().toString());
                setResult(RESULT_OK, intent);
                onBackPressed();
            }
        });
    }


}
