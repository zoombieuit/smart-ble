package se07.smart_ble;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddDeviceActivity extends AppCompatActivity {

    public Context _context = this;
    public String  _title = "Add New";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        setTitle(_title);

    }
}
