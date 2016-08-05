package com.demo22;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    String designation[];

    DataBaseHelper mydb;
    Spinner spinner_designation;
    EditText edt_name;
    EditText edt_Join_date;
    EditText edt_surname;
    Button addUSer;
    RadioGroup radio_g;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_Join_date = (EditText) findViewById(R.id.edt_Join_date);
        addUSer = (Button) findViewById(R.id.addUser);
        edt_surname = (EditText) findViewById(R.id.edt_surname);
        spinner_designation = (Spinner) findViewById(R.id.spinner_designation);
        radio_g = (RadioGroup) findViewById(R.id.radioGroup);


        designation=getResources().getStringArray(R.array.designation_name);
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,designation);
        spinner_designation.setAdapter(adapter);


        mydb = new DataBaseHelper(this);
        AddData();

    }

    public void AddData()
    {
        addUSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.insertData(edt_name.getText().toString(),edt_Join_date.getText().toString(), spinner_designation.getSelectedItem().toString(), edt_surname.getText().toString());

                if(isInserted = true)
                    Toast.makeText(MainActivity.this,"DATA IS INSERTED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"DATA IS NOT INSERTED",Toast.LENGTH_LONG).show();
            }
        });

    }


    }

