package firebasestorage.itideology.com.hereyago;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import firebasestorage.itideology.com.hereyago.slider_menu_items.CommunityFragment;
import firebasestorage.itideology.com.hereyago.slider_menu_items.DiscountVoucherFragment;
import firebasestorage.itideology.com.hereyago.slider_menu_items.HowToShareFragment;
import firebasestorage.itideology.com.hereyago.slider_menu_items.LeaderBoardFragment;
import firebasestorage.itideology.com.hereyago.slider_menu_items.MyProfileFragment;

public class HomeScreenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar_Home;
    TextView tvToolBarTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        toolbar_Home = (Toolbar) findViewById(R.id.toolbar_homeScreen);
        tvToolBarTitle = (TextView) toolbar_Home.findViewById(R.id.tv_tool_title);
        tvToolBarTitle.setText(getString(R.string.app_name));
        setSupportActionBar(toolbar_Home);
        getSupportActionBar().setTitle(null);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar_Home, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_my_profile:
                // Handle my profile action
                tvToolBarTitle.setText(getString(R.string.my_profile));
                replaceFragment(new MyProfileFragment());

                break;
            case R.id.nav_big_picture:
                // Handle the big picture action
                tvToolBarTitle.setText(getString(R.string.big_pic));
                replaceFragment(new MyProfileFragment());
                break;
            case R.id.nav_community:
                // Handle the community action
                tvToolBarTitle.setText(getString(R.string.community));
                replaceFragment(new CommunityFragment());
                break;
            case R.id.nav_leaderboard:
                // Handle the leaderboard action
                tvToolBarTitle.setText(getString(R.string.leader_board));
                replaceFragment(new LeaderBoardFragment());
                break;
            case R.id.nav_dis_voucher:
                // Handle discount voucher action
                tvToolBarTitle.setText(getString(R.string.disc_voucher));
                replaceFragment(new DiscountVoucherFragment());
                break;
            case R.id.nav_share:
                // Handle how to share action
                tvToolBarTitle.setText(getString(R.string.how_to_share));
                replaceFragment(new HowToShareFragment());
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        fragTrans.replace(R.id.frag_container, fragment);
        fragTrans.commit();
    }

}
