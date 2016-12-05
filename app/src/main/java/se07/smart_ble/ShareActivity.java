package se07.smart_ble;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShareActivity extends AppCompatActivity {

    private Context _context = this;
    private String _TITLE = "SHARE MANAGEMENT";

    private ArrayList<String> listCurrentUser = new ArrayList<String>();

    private Button  button_search;
    private EditText editText_search;
    private ListView listView_currentUser;
    private TextView textView_result01, textView_result02;

    private static final String[] array_typeAccess = new String[]{"Owner", "Root"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        button_search = (Button) findViewById(R.id.button_search);
        editText_search = (EditText) findViewById(R.id.editText_search);
        listView_currentUser = (ListView) findViewById(R.id.listView_currentOwner);
        textView_result01 = (TextView) findViewById(R.id.textView_searchResult01);
        textView_result02 = (TextView) findViewById(R.id.textView_searchResult02);

        //Dummy data
        String[] dummy_data = new String[]{"user_01@example.com", "anivia@lol.com", "vayne@master.com"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(
                        _context,
                        android.R.layout.simple_list_item_1,
                        dummy_data);
        listView_currentUser.setAdapter(arrayAdapter);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        listView_currentUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialog_editUserPermission();
            }
        });

        textView_result01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_addNew();
            }
        });

        textView_result02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void showDialog_editUserPermission(){

        AlertDialog.Builder builder = new AlertDialog.Builder(_context);
        builder.setTitle("Add new owner - LOCK 01");

        final View viewInflated = LayoutInflater.from(_context).inflate(R.layout.dialog_edit_permission, null);

        builder.setView(viewInflated);

        //Spinner
        final Spinner spinner_typeAccess = (Spinner) viewInflated.findViewById(R.id.spinner_editTypeAccess);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        _context,
                        android.R.layout.simple_spinner_dropdown_item,
                        array_typeAccess);
        spinner_typeAccess.setAdapter(adapter);
        spinner_typeAccess.setSelection(1, true);

        final AlertDialog dialog = builder.create();

        //Remove Button
        Button button_removeOwner = (Button) viewInflated.findViewById(R.id.button_removeOwner);
        button_removeOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(_TITLE,"Remove Confirm!!!");
                new AlertDialog.Builder(_context)
                        .setTitle("Remove Owner")
                        .setMessage("Are you sure you want to remove this owner?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d(_TITLE,"Removed!!!");
                                Toast.makeText(_context, "Removed Successfully!",
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d(_TITLE,"Remove Canceling!!!");
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                dialog.dismiss();

            }
        });

        Button button_editSave = (Button) viewInflated.findViewById(R.id.button_editSave);
        button_editSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(_TITLE,"SAVED!!!");
                Toast.makeText(_context, "Updated Successfully!",
                        Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        Button button_editCancel = (Button) viewInflated.findViewById(R.id.button_editCancel);
        button_editCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();



    }

    private void showDialog_addNew(){
        AlertDialog.Builder builder = new AlertDialog.Builder(_context);
        builder.setTitle("Add new owner - LOCK 01");

        View viewInflated = LayoutInflater.from(_context).inflate(R.layout.dialog_add_new_owner, null);

        builder.setView(viewInflated);
        final Spinner spinner_typeAccess = (Spinner) viewInflated.findViewById(R.id.spinner_typeAccess);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        _context,
                        android.R.layout.simple_spinner_dropdown_item,
                        array_typeAccess);
        spinner_typeAccess.setAdapter(adapter);

        final AlertDialog dialog = builder.create();

        //Remove Button
        Button button_addSave = (Button) viewInflated.findViewById(R.id.button_addSave);
        button_addSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(_TITLE,"SAVED!!!");
                Toast.makeText(_context, "Saved Successfully!",
                        Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        Button button_addCancel = (Button) viewInflated.findViewById(R.id.button_addCancel);
        button_addCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
