package in.geobullet.csci_4176_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import in.geobullet.csci_4176_project.Database.DBSeeder;
import in.geobullet.csci_4176_project.Database.DatabaseHandler;
import in.geobullet.csci_4176_project.Shared.SessionData;
import in.geobullet.csci_4176_project.Utils.NavMenuManager;
import in.geobullet.csci_4176_project.Utils.NavViewListener;

public class MainActivity extends AppCompatActivity {

    public static int boardId = -1;

    private static final int addPosterMenuItemIndex = 3;
    private NavMenuManager navManager;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DatabaseHandler dbHandler = new DatabaseHandler(this);
        dbHandler.dropAndRecreateTables();

        Log.d("Seeding", "************************************ Begin Database Seeding *******************************************");
        DBSeeder dbSeeder = new DBSeeder();
        dbSeeder.seedDatabase(dbHandler);
        Log.d("Seeding", "************************************ End Database Seeding *******************************************");


//        Board b = dbHandler.getFirstBoard();
        // coordinates for downtown halifax:
//        List<Board> searchedboards = dbHandler.searchAllBoardsWithinMetersOfGivenLatitudeLongitude(500, 44.6488, -63.5752);
//        Log.d("boards:", "Searched boards: " + searchedboards.toString());


        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Well, hello there!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navManager = new NavMenuManager();
        //Changed how nav view operates, listener has now been moved into its own class so repeat code is avoided
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavViewListener(this));

        View hView =  navigationView.getHeaderView(0);
        TextView welcome_menu = (TextView)hView.findViewById(R.id.nav_welcome);
        if(SessionData.currentUser != null) {
            welcome_menu.setText("Welcome: " + SessionData.currentUser.getFirstName() + " " + SessionData.currentUser.getLastName());
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


    }

    @Override
    public void onResume() {
        super.onResume();

        // Check if a user has logged in , if so show the hidden menu items
        if (navigationView != null) {
            if (SessionData.currentUser != null) {
                navManager.showUserMenuItems(navigationView);
            } else {
                navManager.hideUserMenuItem(navigationView);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_something1) {
            return true;
        } else if (id == R.id.action_something2) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
