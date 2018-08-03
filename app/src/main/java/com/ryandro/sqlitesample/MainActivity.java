package com.ryandro.sqlitesample;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private RecyclerView rv_Listdata;
    private ListView lv_countryDetail;
    private DataBaseManager dataBaseManager;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[]{DataBaseHelper._ID,
            DataBaseHelper.SUBJECT, DataBaseHelper.DESC};
    private ArrayList<ListItemDo> dataArrayList;

    final int[] to = new int[]{R.id.tv_id, R.id.title, R.id.tv_desription};
    private Cursor cursor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_countryDetail = findViewById(R.id.lv_countryDetail);
        Button btn_addCountry = findViewById(R.id.btn_addCountry);
//        rv_Listdata = (RecyclerView) findViewById(R.id.rv_Listdata);
        cursor = getdata();
        adapter = new SimpleCursorAdapter(this, R.layout.listview_cell, cursor, from, to, 0);
        lv_countryDetail.setAdapter(adapter);

        btn_addCountry.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dataBaseManager = new DataBaseManager(MainActivity.this);
                        dataBaseManager.open();
                        dataBaseManager.insert("USA", "Chicago is great city");
                        dataBaseManager.close();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                cursor = getdata();
//                                refreshAdapter();
//                                adapter.swapCursor(cursor);
                                adapter.notifyDataSetChanged();

                            }
                        });
                    }
                }).start();

            }
        });


    }

    private void refreshAdapter() {
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        }, 2000);*/

    }

    private Cursor getdata() {

        dataBaseManager = new DataBaseManager(MainActivity.this);
        dataBaseManager.open();
        Cursor cursor = dataBaseManager.fetch();
        dataBaseManager.close();
       /**/ cursor.moveToFirst();
       /* while(cursor.moveToNext()){
            dataArrayList.add(cursor.getColumnIndex())
        }*/
        return cursor;
    }
}
