package com.example.doptask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener {
    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    int p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText(getResources().getString(R.string.sen2));
        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        mainEditText = findViewById(R.id.main_edittext);
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mainTextView.setText(mainEditText.getText().toString()
                +" " + getResources().getString(R.string.sen));
        mNameList.add(mainEditText.getText().toString());
        Collections.sort(mNameList);
        mArrayAdapter.notifyDataSetChanged();
        ArrayList lst = new ArrayList(mNameList);
        mNameList.clear();
        Iterator iterator = lst.iterator();
        while (iterator.hasNext())
        {
            String o = (String) iterator.next();
            if(!mNameList.contains(o)) mNameList.add(o);
        }
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,mNameList);
        mainListView.setAdapter(mArrayAdapter);




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()
                +" " + getResources().getString(R.string.sen));
        p = position;

    }

    public void delete_my(View view) {
        mNameList.remove(p);
        mArrayAdapter.notifyDataSetChanged();

    }
}
