
package se07.smart_ble;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CommandActivity extends AppCompatActivity {

    private Context _context = this;
    private String _TITLE = "LOCK DEMO";

    private Button  button_unlock,
                    button_share,
                    button_history,
                    button_changePass,
                    button_infomation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        setTitle(_TITLE);

        button_share = (Button) findViewById(R.id.button_share);
        button_history = (Button) findViewById(R.id.button_history);
        button_changePass = (Button) findViewById(R.id.button_changePass);
        button_infomation = (Button) findViewById(R.id.button_information);

        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_context, ShareActivity.class);
                startActivity(intent);
            }
        });

        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        button_changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_loginChangePin();
            }
        });

        button_infomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void showDialog_loginChangePin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(_context);
        builder.setTitle("Change Lock PIN");

        View viewInflated = LayoutInflater.from(_context).inflate(R.layout.dialog_change_pincode_01, null);

        builder.setView(viewInflated);
        final AlertDialog dialog = builder.create();

        //Remove Button
        Button button_changePinNext = (Button) viewInflated.findViewById(R.id.button_changePinNext);
        button_changePinNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(_TITLE,"SAVED!!!");
                Toast.makeText(_context, "Saved Successfully!",
                        Toast.LENGTH_LONG).show();
                showDialog_changePin();
                dialog.dismiss();
            }
        });

        Button button_changePinCancel = (Button) viewInflated.findViewById(R.id.button_changePinCancel);
        button_changePinCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showDialog_changePin(){

        AlertDialog.Builder builder = new AlertDialog.Builder(_context);
        builder.setTitle("Change Lock PIN");

        View viewInflated = LayoutInflater.from(_context).inflate(R.layout.dialog_change_pincode_02, null);

        final EditText editText_newPin = (EditText) viewInflated.findViewById(R.id.editText_newPIN);
        EditText editText_newPinAgain = (EditText) viewInflated.findViewById(R.id.editText_againPIN);

        builder.setView(viewInflated);
        final AlertDialog dialog = builder.create();

        //Remove Button
        Button button_newPinSave = (Button) viewInflated.findViewById(R.id.button_newPinSave);
        button_newPinSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(_TITLE,"Change to:"+editText_newPin.getText().toString());
                Toast.makeText(_context, "Changed Successfully!",
                        Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        Button button_newPinCancel = (Button) viewInflated.findViewById(R.id.button_newPinCancel);
        button_newPinCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
