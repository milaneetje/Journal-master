package com.example.milan.journalmilan;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {


    public EntryAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, layout, c, flags);
    }

    public void bindView(View view, Context context, Cursor cursor){

        String Titletxt = cursor.getString(cursor.getColumnIndex("title"));
        TextView title = view.findViewById(R.id.Title);
        title.setText(Titletxt);

        String Moodtxt = cursor.getString(cursor.getColumnIndex("mood"));
        String MoodtxtLow= Moodtxt.toLowerCase();
        TextView mood = view.findViewById(R.id.Mood);
        mood.setText(Moodtxt);

        String Contenttxt = cursor.getString(cursor.getColumnIndex("content"));
        TextView content = view.findViewById(R.id.Content);
        content.setText(Contenttxt);

        String Datetxt = cursor.getString(cursor.getColumnIndex("datestamp"));
        TextView date = view.findViewById(R.id.Date);
        date.setText(Datetxt);

        if (MoodtxtLow.equals("sad")) {
            title.setBackgroundColor(Color.BLUE);
        }
        else if (MoodtxtLow.equals("angry")) {
            title.setBackgroundColor(Color.RED);
        }
        else if (MoodtxtLow.equals("tired")) {
            title.setBackgroundColor(Color.GREEN);
        }
        else if (MoodtxtLow.equals("happy")) {
            title.setBackgroundColor(Color.YELLOW);
        }


    }

}
