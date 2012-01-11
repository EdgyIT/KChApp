package com.KnowledgeChannel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper {
    public static final String KEY_ID = "_id";
    public static final String KEY_CATEGORY = "category";
    private static final String TAG = "DBHelper";
    
    private static final String DATABASE_NAME = "CategoryDB";
    private static final String DATABASE_CL = "cl";
    private static final String DATABASE_TE = "te";
    private static final String DATABASE_FLE = "fle";
    private static final String DATABASE_M = "m";
    private static final String DATABASE_ST = "st";
    private static final String DATABASE_SSV = "ssv";
    private static final String DATABASE_NCA = "nca";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE1 =
        "create table cl (_id integer primary key autoincrement, "
        + "category text not null);";
    
    private static final String DATABASE_CREATE2 =
        "create table te (_id integer primary key autoincrement, "
        + "category text not null);";
    
    private static final String DATABASE_CREATE3 =
        "create table fle (_id integer primary key autoincrement, "
        + "category text not null);";
        
    private static final String DATABASE_CREATE4 =
        "create table m (_id integer primary key autoincrement, "
        + "category text not null);";
        
    private static final String DATABASE_CREATE5 =
        "create table st (_id integer primary key autoincrement, "
        + "category text not null);";
            
    private static final String DATABASE_CREATE6 =
        "create table ssv (_id integer primary key autoincrement, "
        + "category text not null);";
    
    private static final String DATABASE_CREATE7 =
        "create table nca (_id integer primary key autoincrement, "
        + "category text not null);";
        
    private final Context context;  
    // -- end initializers
    
    private Helper DBH;
    private SQLiteDatabase db;
    public DBHelper(Context ctx) 
    {
        this.context = ctx;
        DBH = new Helper(context);
    }
    private static class Helper extends SQLiteOpenHelper 
    {
        Helper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE1);
            db.execSQL(DATABASE_CREATE2);
            db.execSQL(DATABASE_CREATE3);
            db.execSQL(DATABASE_CREATE4);
            db.execSQL(DATABASE_CREATE5);
            db.execSQL(DATABASE_CREATE6);
            db.execSQL(DATABASE_CREATE7);
            
            ContentValues initialValues = new ContentValues();
            
            initialValues.put(KEY_CATEGORY, "Alikabuk");
            db.insert(DATABASE_CL, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Gab To Go");
            db.insert(DATABASE_CL, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Karen's World");
            db.insert(DATABASE_CL, null, initialValues);
            
            initialValues.put(KEY_CATEGORY, "Faculty Room");
            db.insert(DATABASE_TE, null, initialValues);
            initialValues.put(KEY_CATEGORY, "The Power To Empower");
            db.insert(DATABASE_TE, null, initialValues);
            
            initialValues.put(KEY_CATEGORY, "Estudyantipid");
            db.insert(DATABASE_FLE, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Estudyantipid 2");
            db.insert(DATABASE_FLE, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Estudyantipid 3");
            db.insert(DATABASE_FLE, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Negosyo Ko, Asenso Ko");
            db.insert(DATABASE_FLE, null, initialValues);
            
            initialValues.put(KEY_CATEGORY, "K-High Math");
            db.insert(DATABASE_M, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Solved");
            db.insert(DATABASE_M, null, initialValues);
            
            initialValues.put(KEY_CATEGORY, "Agham Aralin");
            db.insert(DATABASE_ST, null, initialValues);
            initialValues.put(KEY_CATEGORY, "K-Hub");
            db.insert(DATABASE_ST, null, initialValues);
            initialValues.put(KEY_CATEGORY, "K-High Science");
            db.insert(DATABASE_ST, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Mi Isla");
            db.insert(DATABASE_ST, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Web Works");
            db.insert(DATABASE_ST, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Why?");
            db.insert(DATABASE_ST, null, initialValues);
            
            initialValues.put(KEY_CATEGORY, "Kasaysayan TV");
            db.insert(DATABASE_SSV, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Pamana");
            db.insert(DATABASE_SSV, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Salam (Elementary)");
            db.insert(DATABASE_SSV, null, initialValues);
            initialValues.put(KEY_CATEGORY, "Salam (High School)");
            db.insert(DATABASE_SSV, null, initialValues);
            initialValues.put(KEY_CATEGORY, "WOW!");
            db.insert(DATABASE_SSV, null, initialValues);
            
            initialValues.put(KEY_CATEGORY, "K-Now");
            db.insert(DATABASE_NCA, null, initialValues);
            initialValues.put(KEY_CATEGORY, "RLB Hour");
            db.insert(DATABASE_NCA, null, initialValues);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
                              int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                  + " to "
                  + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }    
    
    //---opens the database---
    public DBHelper open() throws SQLException 
    {
        db = DBH.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBH.close();
    }
    
    //---insert a quote into the database---
    /*public long insertQuote(String quote) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_CATEGORY, quote);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    
    //---deletes a particular quotes---
    /public boolean deleteQuote(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ID + "=" + rowId, null) > 0;
    }*/
    
    //---retrieves all the quotes---
    public Cursor getAllCL() 
    {
        return db.query(DATABASE_CL, new String[] {
        		KEY_ID, 
        		KEY_CATEGORY}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    public Cursor getAllTE() 
    {
        return db.query(DATABASE_TE, new String[] {
        		KEY_ID, 
        		KEY_CATEGORY}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    public Cursor getAllFLE() 
    {
        return db.query(DATABASE_FLE, new String[] {
        		KEY_ID, 
        		KEY_CATEGORY}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    public Cursor getAllM() 
    {
        return db.query(DATABASE_M, new String[] {
        		KEY_ID, 
        		KEY_CATEGORY}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    public Cursor getAllST() 
    {
        return db.query(DATABASE_ST, new String[] {
        		KEY_ID, 
        		KEY_CATEGORY}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    public Cursor getAllSSV() 
    {
        return db.query(DATABASE_SSV, new String[] {
        		KEY_ID, 
        		KEY_CATEGORY}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    public Cursor getAllNCA() 
    {
        return db.query(DATABASE_NCA, new String[] {
        		KEY_ID, 
        		KEY_CATEGORY}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    
    //---retrieves a particular quote---
    /*public Cursor getQuote(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ID,
                		KEY_CATEGORY
                		}, 
                		KEY_ID + "=" + rowId, 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    //---updates an quote---
    public boolean updateQuote(long rowId, String quote) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_CATEGORY, quote);
        return db.update(DATABASE_TABLE, args, 
                         KEY_ID + "=" + rowId, null) > 0;
    }*/
}
