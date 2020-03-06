package aptitude.com.sqliteasic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class data extends SQLiteOpenHelper {
    Context c;
    static final int ver = 2;
    static final String dbName = "mydb";


    public data(@Nullable Context context) {
        super(context, dbName, null, ver);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String s = "create table myinfo(name text,Phnum integer)";
        db.execSQL(s);
    }

    void insertData(String name, long phnum)
    {
        SQLiteDatabase sd = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("name",name);
        v.put("Phnum",phnum);
        sd.insert("myinfo",null, v);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void check()
    {
        SQLiteDatabase sd1 = getReadableDatabase();
        String s = "select * from myinfo";

        Cursor cr = sd1.rawQuery(s,null);
        String name ="";
        long p=0;
        while(cr.moveToNext())
        {
            name = cr.getString(0);
            p = cr.getLong(1);// Query passed says about column number
        }
        Toast.makeText(c, "Name: " + name + "\nPhone num:" + p, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<String> showValues()
    {
        Toast.makeText(c, "Inside Show Values", Toast.LENGTH_SHORT).show();
        SQLiteDatabase sq = getReadableDatabase();
        String s = "select * from myinfo";
        Cursor cr = sq.rawQuery(s, null);
        ArrayList<String> a1 = new ArrayList<>();
        while(cr.moveToNext())
        {
            String s1 = cr.getString(0);
            long l = cr.getLong(1);
            String s3 = "Name is: " + s1 +"\n Mobile number is: " + l;

            a1.add(s3);
        }
        return a1;
    }
    void Update(String name, long ph)
    {
        SQLiteDatabase sd = getWritableDatabase();
        String n = "name = ?";
        ContentValues cv = new ContentValues();
        cv.put("Phnum", ph);
        String[] sr = {name};
        sd.update("myinfo", cv, n, sr);
        Toast.makeText(c, "Data Updated", Toast.LENGTH_SHORT).show();
    }

    void deleteData(String name)
    {
        SQLiteDatabase sd = getWritableDatabase();
        String n = "name = ?";
        String[] sr = {name};
        sd.delete("myinfo",n,sr);
        Toast.makeText(c, name + " name's Data deleted", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<String> searchData(String name)
    {
        SQLiteDatabase sd = getReadableDatabase();
        String sr = "Select * from myinfo where name = ? ";
        String ar[] = {name};
        ArrayList<String> al = new ArrayList<>();
        Cursor cr = sd.rawQuery(sr,ar);
        while(cr.moveToNext())
        {
            String n = cr.getString(0);
            long pn = cr.getLong(1);
            String all = "name: " + n + "Phone number is: " + pn;
            al.add(all);
        }

        return al;
    }

}
