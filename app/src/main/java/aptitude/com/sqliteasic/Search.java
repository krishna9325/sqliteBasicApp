package aptitude.com.sqliteasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    EditText edSearch;
    Button btnSe;
    ListView searchDataDisplay;
    data d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        edSearch = findViewById(R.id.searchNam);
        btnSe = findViewById(R.id.ButnSearch);
        searchDataDisplay = findViewById(R.id.listViewSearch);

        d = new data(getApplicationContext());
        btnSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameSearch = edSearch.getText().toString();

                ArrayList<String> a1 = d.searchData(nameSearch);
                ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.support_simple_spinner_dropdown_item,a1);

                searchDataDisplay.setAdapter(ad);
            }
        });
    }
}
