package aptitude.com.sqliteasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Delete extends AppCompatActivity {

    EditText nameDel;
    Button delNameData;
    data d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        nameDel = findViewById(R.id.nameDel);
        delNameData = findViewById(R.id.DeleteBtn);

        d = new data(getApplicationContext());

        delNameData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String delNameFin = nameDel.getText().toString();
                d.deleteData(delNameFin);

            }
        });

    }
}
