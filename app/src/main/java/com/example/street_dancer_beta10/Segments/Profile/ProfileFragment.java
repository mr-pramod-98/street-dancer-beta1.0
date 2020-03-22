package com.example.street_dancer_beta10.Segments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.street_dancer_beta10.Segments.Profile.MenuFragments.AboutFragment;
import com.example.street_dancer_beta10.Segments.Profile.MenuFragments.HelpFragment;
import com.example.street_dancer_beta10.Segments.Profile.MenuFragments.PrivacyFragment;
import com.example.street_dancer_beta10.Segments.Profile.MenuFragments.SavedFragment;
import com.example.street_dancer_beta10.Segments.Profile.MenuFragments.SecurityFragment;
import com.example.street_dancer_beta10.HomeActivity;
import com.example.street_dancer_beta10.R;
import com.example.street_dancer_beta10.Segments.Profile.UserFollowersFollowingsComponents.ViewPagerSetupFragment;
import com.example.street_dancer_beta10.Segments.Profile.UserUploadComponents.ProfileUserUploadFragment;
import com.example.street_dancer_beta10.SharedComponents.Models.MediaObject;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private static final String TAG = "ProfileFragment";

    private RecyclerView recyclerView;
    private ProfileRecyclerViewAdapter adapter;
    private TextView followers_linearLayout;
    private TextView following_linearlayout;
    private Fragment fragment;

    private ArrayList<MediaObject> mediaObjects = new ArrayList<>();

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.saved:
                fragment = new SavedFragment();
                break;
            case R.id.security:
                fragment = new SecurityFragment();
                break;
            case R.id.help:
                fragment = new HelpFragment();
                break;
            case R.id.about:
                fragment = new AboutFragment();
                break;
            case R.id.privacy:
                fragment = new PrivacyFragment();
                break;
            case R.id.logout:
                Toast.makeText(getContext(), "Logout!", Toast.LENGTH_LONG).show();
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

        return true;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Log.d(TAG, "onViewCreated: inside on-created");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_profile);
        toolbar.inflateMenu(R.menu.my_menu);
        if(toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        Log.d(TAG, "onViewCreated: inside on-create-view");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: inside on-view-created");
        recyclerView = (RecyclerView) view.findViewById(R.id.profile_recycler_view);
        followers_linearLayout = (TextView) view.findViewById(R.id.layout_followers_id);
        following_linearlayout = (TextView) view.findViewById(R.id.layout_following_id);

        Log.d(TAG, "onViewCreated: before call");
        setMedia();
        setAdapter();
        Log.d(TAG, "onViewCreated: after call");

        //followers-following
        followers_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ViewPagerSetupFragment();

                HomeActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.container_fragment, fragment)
                        .commit();
            }
        });

        //followers-following
        following_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new ViewPagerSetupFragment();

                HomeActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.container_fragment, fragment)
                        .commit();
            }
        });


        // SET ON CLICK LISTENER
        adapter.setListener(new ProfileRecyclerViewAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.d(TAG, "onClick: ProfileFragment " + position);

                Toast.makeText(getContext(), " " + position, Toast.LENGTH_LONG).show();
                fragment = new ProfileUserUploadFragment(position);

                // MAKING CHANGES AND COMMITTING
                HomeActivity.fragmentManager
                        // BEGIN THE TRANSACTION
                        .beginTransaction()
                        // THE "fragment" WILL BE DISPLAYED IN THE "container_fragment"
                        .replace(R.id.container_fragment, fragment)

                        .addToBackStack(null)
                        // COMMITTING THE CHANGES
                        .commit();

                Log.d(TAG, "onClick: ProfileFragment " + position);
            }
        });

    }

    private void setMedia() {

        mediaObjects.add(new MediaObject("Sending Data to a New Activity with Intent Extras",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png",
                "Description for media object #1"));

        mediaObjects.add(new MediaObject("REST API, Retrofit2, MVVM Course SUMMARY",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API+Retrofit+MVVM+Course+Summary.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API%2C+Retrofit2%2C+MVVM+Course+SUMMARY.png",
                "Description for media object #2"));

        mediaObjects.add(new MediaObject("MVVM and LiveData",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/MVVM+and+LiveData+for+youtube.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/mvvm+and+livedata.png",
                "Description for media object #3"));

        mediaObjects.add(new MediaObject("Swiping Views with a ViewPager",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/SwipingViewPager+Tutorial.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Swiping+Views+with+a+ViewPager.png",
                "Description for media object #4"));

        mediaObjects.add(new MediaObject("Database Cache, MVVM, Retrofit, REST API demo for upcoming course",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Rest+api+teaser+video.mp4",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Rest+API+Integration+with+MVVM.png",
                "Description for media object #5"));
    }

    private void setAdapter() {

        // CREATE RECYCLER-VIEW ADAPTER OBJECT
        adapter = new ProfileRecyclerViewAdapter(getContext(), mediaObjects, initGlide());
        recyclerView.setHasFixedSize(true);

        // SETUP THE ADAPTER
        recyclerView.setAdapter(adapter);

        // SET THE LAYOUT TO "GRID-LAYOUT"
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.video_error)
                .error(R.drawable.video_error);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }

}
