package com.hjsoft.affdelstaffdelapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hjsoft.affdelstaffdelapp.NavigationData;
import com.hjsoft.affdelstaffdelapp.R;
import com.hjsoft.affdelstaffdelapp.adapter.DrawerItemCustomAdapter;
import com.hjsoft.affdelstaffdelapp.adapter.RecyclerAdapter;
import com.hjsoft.affdelstaffdelapp.fragment.BookingHistoryFragment;
import com.hjsoft.affdelstaffdelapp.fragment.ChangePasswordFragment;
import com.hjsoft.affdelstaffdelapp.model.AllBookingsData;

import java.util.ArrayList;

/**
 * Created by hjsoft on 21/5/18.
 */
public class ChangePasswordActivity extends AppCompatActivity implements RecyclerAdapter.AdapterCallback{

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    DrawerItemCustomAdapter adapter;
    final static int REQUEST_LOCATION = 199;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "SharedPref";
    TextView tvName,tvMobile;
    RelativeLayout rLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTitle = mDrawerTitle = getTitle();
        //mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_view_drawer);
        tvName=(TextView)findViewById(R.id.ah_tv_name);
        tvMobile=(TextView)findViewById(R.id.ah_tv_mobile);
        rLayout=(RelativeLayout)findViewById(R.id.left_drawer);

        pref = getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

        String myString=pref.getString("name","xxx");

        String upperString = myString.substring(0,1).toUpperCase() + myString.substring(1);

        tvName.setText(upperString);
        tvMobile.setText(pref.getString("mobile","91xxxxxxxx"));

        setupToolbar();

        NavigationData[] drawerItem = new NavigationData[4];

        drawerItem[0] = new NavigationData(R.drawable.arrow, "All Bookings");
        drawerItem[1] = new NavigationData(R.drawable.arrow, "Transfer Items");
        drawerItem[2] = new NavigationData(R.drawable.arrow, "Change Password");
        drawerItem[3] = new NavigationData(R.drawable.arrow,"WLogout");
        /*drawerItem[4] = new NavigationData(R.drawable.arrow,"Rate Card");
        drawerItem[5] = new NavigationData(R.drawable.arrow,"Support");
        drawerItem[6] = new NavigationData(R.drawable.arrow,"Logout");*/


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        setupDrawerToggle();

        Fragment fragment=new ChangePasswordFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.content_frame, fragment,"book_a_ride").commit();
        setTitle("Change Password");
        adapter.setSelectedItem(2);

        /*getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    Fragment currentFragment = fragmentManager.findFragmentById(R.id.content_frame);

                    //System.out.println("******************"+currentFragment.getTag());

                    if(currentFragment.getTag().equals("confirm_ride")) {
                        mDrawerToggle.setDrawerIndicatorEnabled(false);//showing back button
                        setTitle("Confirm Ride");

                    }
                    else {
                        mDrawerToggle.setDrawerIndicatorEnabled(true);//showing back button
                        setTitle("Ride Details");

                    }

                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            FragmentManager fragmentManager = getSupportFragmentManager();
                            Fragment currentFragment = fragmentManager.findFragmentById(R.id.content_frame);

                            // onBackPressed();

                            if(currentFragment.getTag().equals("confirm_ride")) {
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.remove(getSupportFragmentManager().findFragmentByTag("confirm_ride"));
                                fragmentManager.popBackStackImmediate();
                            }
                            else {
                                mDrawerLayout.openDrawer(rLayout);
                            }


                        }
                    });
                }
                else
                {
                    mDrawerToggle.setDrawerIndicatorEnabled(true);
                    setTitle("PCS Cabs");

                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            //mDrawerLayout.openDrawer(mDrawerList);
                            mDrawerLayout.openDrawer(rLayout);
                        }
                    });
                }
            }
        });*/
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;
        adapter.setSelectedItem(position);

        switch (position) {
            case 0:Intent i=new Intent(ChangePasswordActivity.this,BookingHistoryActivity.class);
                startActivity(i);
                finish();
                break;
            case 1:
                Intent j=new Intent(ChangePasswordActivity.this,TransferItemsActivity.class);
                startActivity(j);
                finish();
                break;
            case 2:
                Intent k=new Intent(ChangePasswordActivity.this,ChangePasswordActivity.class);
                startActivity(k);
                finish();
                break;
            case 3:
                Intent o=new Intent(ChangePasswordActivity.this,MainActivity.class);
                startActivity(o);
                finish();
                break;
           /* case 4:
                Intent l=new Intent(BookingHistoryActivity.this,BookingHistoryActivity.class);
                startActivity(l);
                finish();
                break;
            case 5:
                Intent m=new Intent(BookingHistoryActivity.this,BookingHistoryActivity.class);
                startActivity(m);
                finish();
                break;

            case 6:
                Intent n=new Intent(BookingHistoryActivity.this,BookingHistoryActivity.class);
                startActivity(n);
                finish();
                break;*/


            default:
                break;
        }

        if (fragment != null) {

            openFragment(fragment,position);

        } else {
            // Log.e("MainActivity", "Error in creating fragment");
        }
    }

    private void openFragment(Fragment fragment,int position){

        Fragment containerFragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (containerFragment.getClass().getName().equalsIgnoreCase(fragment.getClass().getName())) {
            mDrawerLayout.closeDrawer(mDrawerList);
            return;
        }

        else{
            /*
           FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            */
            mDrawerLayout.closeDrawer(mDrawerList);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        /*
        int titleId = getResources().getIdentifier("toolbar", "id", "android");
        TextView abTitle = (TextView) findViewById(titleId);
        abTitle.setTextColor(Color.parseColor("#000000"));*/
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();


        super.onBackPressed();

    }

    @Override
    public void onMethodCallback(final int position, ArrayList<AllBookingsData> data) {

    }



}
