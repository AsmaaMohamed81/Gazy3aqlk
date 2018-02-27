package com.farida.fareda.gazy3aqlk.Activitiess;

/**
 * Created by anupamchugh on 19/10/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.farida.fareda.gazy3aqlk.DB.DBManager;
import com.farida.fareda.gazy3aqlk.R;

public class AddActivity extends Activity implements OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText;
    private EditText descEditText,cat;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Item");

        setContentView(R.layout.activity_add_record);

        subjectEditText = (EditText) findViewById(R.id.title_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);
     //   cat = (EditText) findViewById(R.id.cat);


        addTodoBtn = (Button) findViewById(R.id.add_item);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_item:

                final String name = subjectEditText.getText().toString();
                final String desc = descEditText.getText().toString();
           //     final String catt = cat.getText().toString();


                dbManager.insert(name, desc,MainActivity.nameTable);

                Intent main = new Intent(AddActivity.this, ListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

}