package com.example.milan.journalmilan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.Map;

public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Entries (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, mood TEXT, datestamp DATETIME DEFAULT (datetime('now','localtime')))");
//        String create = ;
//        db.execSQL(create);

        String sampleItems = "INSERT INTO Entries (title, mood, content) VALUES" +
                "('The beginning', 'Happy', 'Welcome to our app. to add an entry simply press" +
                "the button in the lower left corner. To delete an entry hold it for a couple of" +
                "seconds. Please try deleting this message and replace with your first entry!')";
        db.execSQL(sampleItems);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Entries");
        onCreate(db);
    }

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    public static EntryDatabase getInstance(Context c) {
        if (instance == null) {
            instance = new EntryDatabase(c, "databaseJournal", null, 1);
        }
        return instance;
    }

    public Cursor selectAll() {
        SQLiteDatabase db = instance.getWritableDatabase();
        return db.rawQuery("SELECT * FROM Entries", null);
    }

    public void insert(JournalEntry journalEntry){
        SQLiteDatabase db = instance.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", journalEntry.getTitle());
        contentValues.put("mood", journalEntry.getMood());
        contentValues.put("content", journalEntry.getContent());

        db.insert("Entries", null, contentValues);
    }

    public void delete(long id) {
        SQLiteDatabase db = instance.getWritableDatabase();
        int intId = (int) id;
        db.delete("Entries", "_id=?", new String[]{Integer.toString(intId)});
    }
}
