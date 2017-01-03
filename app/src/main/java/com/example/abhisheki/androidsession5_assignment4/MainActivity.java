package com.example.abhisheki.androidsession5_assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static String [] Contacts={"Gaurish","Preetika","Rama","Santosh"};
    public static String [] Phones={"567456788","544566788","457890677","678976540"};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeList();

    }

    public void MakeList()
    {
        CustomList customList = new CustomList(this, Contacts, Phones);
        listView = (ListView) findViewById(R.id.MyList);
        listView.setAdapter(customList);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Context Menu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

          Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_LONG).show();
          return true;
    }
}
