package aptitude.com.sqliteasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class ViewList extends AppCompatActivity {

    data da;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        da = new data(getApplicationContext());

        l = findViewById(R.id.listView);

        ArrayList<String> a1 = da.showValues();
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,a1);
        l.setAdapter(ad);
    }
}
