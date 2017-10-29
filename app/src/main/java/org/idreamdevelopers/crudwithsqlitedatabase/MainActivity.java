package org.idreamdevelopers.crudwithsqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapters.ContactListAdapter;
import entities.Contact;
import database.*;
import android.view.View;
import android.widget.*;
import android.content.*;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    // Declaring variable name by using their id

    private  Button buttonAdd;
    private ListView listViewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // finding the ids
        this.buttonAdd = (Button) findViewById(R.id.buttonAdd);
        this.buttonAdd.setOnClickListener(new View.OnClickListener(){ // Add Button  Click Listener
                @Override
             public void onClick(View view) {
                    Intent intent1 = new Intent(MainActivity.this,AddContactActivity.class);
                    startActivity(intent1); // moving one page to another
                }
        });

            ContactDB contactDB = new ContactDB(this);
            this.listViewContacts = (ListView) findViewById(R.id.listViewContacts);
            this.listViewContacts.setAdapter(new ContactListAdapter(this,
                    contactDB.findAll()));



    }
}
