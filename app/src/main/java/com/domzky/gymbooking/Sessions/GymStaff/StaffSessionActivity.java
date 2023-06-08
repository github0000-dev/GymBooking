package com.domzky.gymbooking.Sessions.GymStaff;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.domzky.gymbooking.R;
import com.domzky.gymbooking.Sessions.GymStaff.pages.Account.AccountFragment;
import com.domzky.gymbooking.Sessions.GymStaff.pages.MembersList.MembersListFragment;
import com.domzky.gymbooking.Sessions.GymStaff.pages.TasksList.TasksListFragment;
import com.domzky.gymbooking.Sessions.GymStaff.pages.AboutGym.AboutGymFragment;
import com.google.android.material.navigation.NavigationView;

public class StaffSessionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_session);

        // Setting my component hooks
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);

        // This will be used when the menu is dynamic for different users
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.staff_nav_menu);

        // Implemented class for the navigation functionality
        navigationView.setNavigationItemSelectedListener(this);


        // Set the toolbar title first then the bring the entire toolbar to the front of the nav menu
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(navigationView.getMenu().getItem(0).toString());
        setSupportActionBar(toolbar);
        navigationView.bringToFront();

        // Set an initialized fragment when the menu activity starts to open
        changeFragmentMenu(new TasksListFragment(),navigationView.getMenu().getItem(0).toString());

        // Initialize highlighted menu item when the menu activity starts to open
        navigationView.setCheckedItem(navigationView.getMenu().getItem(0).getItemId());

        // Set navigation header values
        View headerView = navigationView.getHeaderView(0);
        TextView headUserName = headerView.findViewById(R.id.nav_account_name);
        TextView headUserType = headerView.findViewById(R.id.nav_account_type);
        headUserName.setText("Phil Adlaon");
        headUserType.setText("Staff");


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.staff_menu_tasks:
                changeFragmentMenu(new TasksListFragment(),item.toString());
                break;
            case R.id.staff_menu_members:
                changeFragmentMenu(new MembersListFragment(),item.toString());
                break;
            case R.id.staff_menu_about_gym:
                changeFragmentMenu(new AboutGymFragment(),item.toString());
                break;
            case R.id.staff_menu_account:
                changeFragmentMenu(new AccountFragment(),item.toString());
                break;
            default:
                changeFragmentMenu(new TasksListFragment(),item.toString());
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragmentMenu(Fragment fragment, String menuTitle) {
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,fragment).commit();
        toolbar.setTitle(menuTitle);
    }

}
