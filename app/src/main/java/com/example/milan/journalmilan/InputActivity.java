package com.example.milan.journalmilan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void addEntry(View view) {
//      adds entry into SQL database
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());

        EditText title = findViewById(R.id.TitleIn);
        EditText mood = findViewById(R.id.MoodIn);
        EditText content = findViewById(R.id.EntryIn);

        JournalEntry journalEntry = new JournalEntry(title.getText().toString(),
                content.getText().toString(), mood.getText().toString());

        db.insert(journalEntry);

        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
