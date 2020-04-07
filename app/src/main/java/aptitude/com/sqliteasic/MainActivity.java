package aptitude.com.sqliteasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button b1, b2,b3,b4,b5,b6;
    EditText ed1,examType,edName,date1;
    data d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.addEntry);
        b2 = findViewById(R.id.remove);
        b3 = findViewById(R.id.viewlist);
        b4 = findViewById(R.id.Update);
        b5 = findViewById(R.id.Delete);
        b6 = findViewById(R.id.search);

        ed1 = findViewById(R.id.editData);
        edName = findViewById(R.id.edit);
        examType = findViewById(R.id.examType);
        date1 = findViewById(R.id.editLong);

        d = new data(getApplicationContext());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ExamName = ed1.getText().toString();
                String Type = examType.getText().toString();
                String EName = edName.getText().toString();
                String date = date1.getText().toString();
                d.insertData(ExamName,Type,EName,date);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.check();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(), ViewList.class);
               startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),UpdateData.class);
                startActivity(i);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),Delete.class);
                startActivity(i);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),Search.class);
                startActivity(i);
            }
        });
    }
}
