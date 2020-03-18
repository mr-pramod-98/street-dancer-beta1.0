package com.example.street_dancer_beta10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.street_dancer_beta10.Segments.Home.HomeFragment;
import com.example.street_dancer_beta10.Segments.Notification.NotificationFragment;
import com.example.street_dancer_beta10.Segments.Profile.ProfileFragment;
import com.example.street_dancer_beta10.Segments.Search.SearchFrgment;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class HomeActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    private SpaceNavigationView spaceNavigationView;
    private Fragment fragment;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            int count = fragmentManager.getBackStackEntryCount();
            Toast.makeText(this, "count: " + count, Toast.LENGTH_SHORT).show();
        } else {
            finish();
            //super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);

        fragmentManager = getSupportFragmentManager();

        // SETTING HOME PAGE AS THE DEFAULT PAGE
        fragment = new HomeFragment();
        // MAKING CHANGES AND COMMITTING
        HomeActivity.fragmentManager
                // BEGIN THE TRANSACTION
                .beginTransaction()
                // THE "fragment" WILL BE DISPLAYED IN THE "container_fragment"
                .replace(R.id.container_fragment, fragment)

                .addToBackStack(null)
                // COMMITTING THE CHANGES
                .commit();

        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.setElevation((float) 1.5);

        // ADDING ITEM'S TO BOTTOM NAVIGATION BAR
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.nav_home_button));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.nav_search_button));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.nav_favorite_button));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.nav_profile_button));

        // SETTING ON CLICK LISTENER TO THE ITEM'S IN BOTTOM NAVIGATION BAR
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {

            @Override
            public void onCentreButtonClick() {

                spaceNavigationView.setCentreButtonSelectable(true);

                // WHEN CENTER BUTTON IS CLICKED
                fragment = new ProfileFragment();
                // MAKING CHANGES AND COMMITTING
                HomeActivity.fragmentManager
                        // BEGIN THE TRANSACTION
                        .beginTransaction()
                        // THE "fragment" WILL BE DISPLAYED IN THE "container_fragment"
                        .replace(R.id.container_fragment, fragment)

                        .addToBackStack(null)
                        // COMMITTING THE CHANGES
                        .commit();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

                // GENERATING THE FRAGMENT ACCORDING TO THE ITEM CLICKED FROM THE BOTTOM NAVIGATION BAR
                switch (itemIndex){
                    case 0: // GENERATING HOME FRAGMENT
                        fragment = new HomeFragment();
                        break;
                    case 1: // GENERATING SEARCH FRAGMENT
                        fragment = new SearchFrgment();
                        break;
                    case 2: // GENERATING NOTIFICATION FRAGMENT
                        fragment = new NotificationFragment();
                        break;
                    case 3: // GENERATING PROFILE FRAGMENT
                        fragment = new ProfileFragment();
                        break;
                }

                // MAKING CHANGES AND COMMITTING
                HomeActivity.fragmentManager
                        // BEGIN THE TRANSACTION
                        .beginTransaction()
                        // THE "fragment" WILL BE DISPLAYED IN THE "container_fragment"
                        .replace(R.id.container_fragment, fragment)

                        .addToBackStack(null)
                        // COMMITTING THE CHANGES
                        .commit();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(HomeActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });



    }

}
