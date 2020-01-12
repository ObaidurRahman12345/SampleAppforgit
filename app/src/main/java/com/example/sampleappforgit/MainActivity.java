package com.example.sampleappforgit;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sampleappforgit.Fragment.DashboardFragment;
import com.example.sampleappforgit.Fragment.DatePickerFragment;
import com.example.sampleappforgit.database.DatabaseOpenHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private BottomNavigationView bottomNavigationView;
    private ImageView profileIV, settingsIV, rateusIV, aboutusIV;
    private TextView signinTV, settingsTV, rateusTV, aboutusTV;
    private FrameLayout frameLayout;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private DatabaseOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        FloatingActionButton floatingActionButton = findViewById(R.id.fabbtn);

        // Calender start
        Button buttoncln = (Button)findViewById(R.id.calanderBtn);

        buttoncln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(),"Date");
            }
        }); //Calender end

        //Floating Action Button

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });
        //Please add your fragment here.

        init();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.navigation_dashboard:
                        DashboardFragment dashboardFragment = new DashboardFragment();
                        loadFragment(dashboardFragment);
                        Toast.makeText(MainActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

    }

    private void init()
    {
        profileIV = findViewById(R.id.profileIV);
        signinTV = findViewById(R.id.signinTV);
        settingsIV = findViewById(R.id.settingsIV);
        settingsTV = findViewById(R.id.settingsTV);
        rateusIV = findViewById(R.id.rateusIV);
        rateusTV = findViewById(R.id.rateusTV);
        aboutusIV = findViewById(R.id.aboutusIV);
        aboutusTV = findViewById(R.id.aboutusTV);
        bottomNavigationView = findViewById(R.id.nav_view);
        frameLayout = findViewById(R.id.frame_container);
    }
    public void loadFragment(Fragment fragment) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView date = (TextView) findViewById(R.id.dateTV);
        date.setText(currentDateString);
    }
}
