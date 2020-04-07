package aptitude.com.sqliteasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateData extends AppCompatActivity {

    EditText enterName1,editUp1,courseUp1,TypeUp1;
    Button bt;
    data d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        bt = findViewById(R.id.btnUp);
        enterName1= findViewById(R.id.enterName);
        editUp1= findViewById(R.id.editUp);
        courseUp1= findViewById(R.id.courseUp);
        TypeUp1= findViewById(R.id.TypeUp);


        d = new data(getApplicationContext());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = enterName1.getText().toString();
                String editUp2 = editUp1.getText().toString();
                String courseUp2 = courseUp1.getText().toString();
                String TypeUp2 = TypeUp1.getText().toString();
                d.Update(courseName,TypeUp2,courseUp2,editUp2);
            }
        });

    }
}
