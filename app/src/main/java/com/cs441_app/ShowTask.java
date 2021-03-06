package com.cs441_app;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShowTask extends AppCompatActivity {

    private Button btnGoToMain;

    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtLocation;
    private TextView txtTime;
    private TextView txtCategory;
    private TextView txtDate;

    private static Task task;

    InternalDatabase myDB;
    private ArrayList<String> colorArray;

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private UserManager um;


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                Intent intentAddTask = new Intent(ShowTask.this,
                        AddTask.class);
                startActivity(intentAddTask);
                return true;
            case R.id.action_nav_drawer:
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);

        um = UserManager.getInstance();

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Task");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setSupportActionBar(myToolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        um.populateNavList(ShowTask.this,getWindow().getDecorView().getRootView());
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, myToolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        myDB = new InternalDatabase(this);
        colorArray = new ArrayList<String>();

        int i = 0;
        Cursor data = myDB.getAllData();
        while (data.moveToNext()) {
            i++;
            colorArray = new ArrayList<>();
            String c0 = (data.getString(0));
            String c1 = (data.getString(1));
            String c2 = (data.getString(2));
            String c3 = (data.getString(3));

            colorArray.add(c0);
            colorArray.add(c1);
            colorArray.add(c2);
            colorArray.add(c3);

        }

        if (i==0) {
            colorArray.add("Work");
            colorArray.add("School");
            colorArray.add("Friends");
            colorArray.add("Family");
        }

        txtTitle = findViewById(R.id.txtTitleShowTask);
        txtDescription = findViewById(R.id.txtDescriptionShowTask);
        txtLocation = findViewById(R.id.txtLocationShowTask);
        txtTime = findViewById(R.id.txtTimeShowTask);
        txtCategory = findViewById(R.id.txtCategoryShowTask);
        txtDate = findViewById(R.id.txtDateShowTask);


        //Gets the time
        long startHour = task.getHour();
        long startMin = task.getMin();

        String TaskTime = (startHour + ":" + startMin);

        //Gets the day
        long dayTask = task.getDay();
        long monthTask = task.getMonth();
        long yearTask = task.getYear();

        String dateTask = (monthTask + "/" + dayTask + "/" + yearTask);

        //For the category
        String categoryOutput;
        long category = task.getCategory();

        if (category == 0) {
            categoryOutput = colorArray.get(0);
            txtTitle.setTextColor(getResources().getColor(R.color.red));
        } else if (category == 1) {
            categoryOutput = colorArray.get(1);
            txtTitle.setTextColor(getResources().getColor(R.color.blue));
        }
        else if (category == 2) {
            categoryOutput = colorArray.get(2);
            txtTitle.setTextColor(getResources().getColor(R.color.green));
        }
        else {
            categoryOutput = colorArray.get(3);
            txtTitle.setTextColor(getResources().getColor(R.color.yellow));

        }


        //setText functions
        txtDate.setText(dateTask);
        txtTitle.setText(task.getTitle());
        txtDescription.setText(task.getDescription());
        txtLocation.setText(task.getLocation());
        txtTitle.setText(task.getTitle());
        txtTime.setText(TaskTime);
        txtCategory.setText(categoryOutput);

        //-----------------------------------------------------------
        btnGoToMain = findViewById(R.id.btnBackToMain);
        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(ShowTask.this,
                        MainActivity.class);
                startActivity(intentHome);
            }
        });

    }

    public static void getTaskFromMain(Task t) {
        task = t;
    }
}
