package aptitude.com.sqliteasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateData extends AppCompatActivity {

    EditText etPh,etnam2;
    Button bt;
    data d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        bt = findViewById(R.id.btnUp);
        etPh = findViewById(R.id.editUp);
        etnam2 = findViewById(R.id.editPhone);
        d = new data(getApplicationContext());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etnam2.getText().toString();
                long phNum = Long.parseLong(etPh.getText().toString());
                d.Update(name,phNum);
            }
        });

    }
}
