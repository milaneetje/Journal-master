package com.example.milan.journalmilan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        JournalEntry entry = (JournalEntry) intent.getSerializableExtra("entry");
        String Datetxt = intent.getStringExtra("date");

        TextView title = findViewById(R.id.Title);
        title.setText(entry.getTitle());

        TextView mood = findViewById(R.id.Mood);
        mood.setText(entry.getMood());

        TextView content = findViewById(R.id.EntryOut);
        content.setText(entry.getContent());

        TextView date = findViewById(R.id.DateOut);
        date.setText(Datetxt);
    }
}
