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
    static final int ver = 3;
    static final String dbName = "mydb";


    public data(@Nullable Context context) {
        super(context, dbName, null, ver);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String s = "create table myinfo(name text,type text,eName text,dateOn text)";
        db.execSQL(s);
    }

    void insertData(String name, String type, String examName, String date)
    {
        SQLiteDatabase sd = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("name",name);
        v.put("type", type);
        v.put("eName", examName);
        v.put("dateOn",date);
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
        String courseName ="";
        String  ExamType="";
        String ExamN="";
        String date ="";

        while(cr.moveToNext())
        {
            courseName = cr.getString(0);
            ExamType = cr.getString(1);
            ExamN = cr.getString(2);
            date = cr.getString(3);

        }
        Toast.makeText(c, "Exam Name: " + courseName + "\nExam Type:" + ExamType+ "\nCourse Name:" + ExamN+ "\nDate:" + date, Toast.LENGTH_SHORT).show();
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
            String s2 = cr.getString(1);
            String s3 = cr.getString(2);
            String l = cr.getString(3);
            String s4 = "Exam Name: " + s1 + "\n Exam Type:" + s2+ "\n Course Name:" + s3+ "\n Date:" + l;

            a1.add(s4);
        }
        return a1;
    }
    void Update(String name, String type, String examName, String date)
    {
        SQLiteDatabase sd = getWritableDatabase();
        String n = "name = ?";
        ContentValues cv = new ContentValues();
        cv.put("type", type);
        cv.put("eName", examName);
        cv.put("dateOn",date);
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
        Toast.makeText(c, name + " Exam name's Data deleted", Toast.LENGTH_SHORT).show();
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
            String s1 = cr.getString(0);
            String s2 = cr.getString(1);
            String s3 = cr.getString(2);
            String l = cr.getString(3);
            String all = "Course Name: " + s1 + "\nExam Type:" + s2+ "\nExam Name:" + s3+ "\nDate:\n" + l;
            al.add(all);
        }

        return al;
    }

}
