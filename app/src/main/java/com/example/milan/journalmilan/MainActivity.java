package com.example.milan.journalmilan;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EntryDatabase db;
    EntryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);

        onListItemClick listener = new onListItemClick();
        onLongListItemClick longListener = new onLongListItemClick();

        listView.setOnItemClickListener(listener);
        listView.setOnItemLongClickListener(longListener);

        db = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();
        adapter = new EntryAdapter(this, R.layout.entry_row, cursor, 0);
        listView.setAdapter(adapter);
    }

    private class onListItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);

            TextView titleText = view.findViewById(R.id.Title);
            String title = titleText.getText().toString();

            TextView moodText = view.findViewById(R.id.Mood);
            String mood = moodText.getText().toString();

            TextView contentText = view.findViewById(R.id.Content);
            String content = contentText.getText().toString();

            TextView dateText = view.findViewById(R.id.Date);
            String date = dateText.getText().toString();

            JournalEntry entry = new JournalEntry(title, content, mood);

            intent.putExtra("entry", entry);
            intent.putExtra("date", date);

            startActivity(intent);
        }
    }

    private class onLongListItemClick implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            db = EntryDatabase.getInstance((getApplicationContext()));

            db.delete(id);
            updateData();
            return false;
        }
    }

    public void AddEntry(View v){
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    private void updateData(){
        adapter.swapCursor(db.selectAll());
    }
}
