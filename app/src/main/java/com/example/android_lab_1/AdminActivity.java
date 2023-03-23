package com.example.android_lab_1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class AdminActivity extends AppCompatActivity {

    ArrayList<String> accounts = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView accountsList;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        dbHelper = new DBHelper(this);

        Collections.addAll(accounts);

        accountsList = findViewById(R.id.acc_table);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, accounts);

        accountsList.setAdapter(adapter);
    }

    @Override
    protected void onStop(){
        super.onStop();

    }
    @Override
    protected void onStart(){
        restoreTable();
        super.onStart();

    }
    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }

    @Override
    protected void onRestart(){
        super.onRestart();

    }

    public void removeAccount(View view){
        EditText accountET = findViewById(R.id.adm_acc_entrie);
        String login  = accountET.getText().toString();
        if(dbHelper.deleteUser(login))
            Toast.makeText(this,
                    "Пользователь " + login + " успешно удалён", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,
                    "Ошибка удаления", Toast.LENGTH_SHORT).show();
        restoreTable();
    }

    private void restoreTable()
    {
        ArrayList<String> list = dbHelper.getDateList();
        adapter.clear();
        accounts.clear();
        for(int i=0; i < list.size(); i = i + 2)
        {
            accounts.add(list.get(i) + " " + list.get(i+1));
        }
    }
}