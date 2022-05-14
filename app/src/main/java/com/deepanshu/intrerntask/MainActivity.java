package com.deepanshu.intrerntask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    listView = findViewById(R.id.listView);

    // create data
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));

        arrayList.add(new Person(R.drawable.smile,"NGuyen Thi A","sshe is 18 yrs old"));
/////////// custom Adapter made///////////

        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,arrayList);
        listView.setAdapter(personAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


    }
}