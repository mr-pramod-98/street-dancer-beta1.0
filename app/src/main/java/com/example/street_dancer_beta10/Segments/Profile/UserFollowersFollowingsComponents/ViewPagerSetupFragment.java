package com.example.street_dancer_beta10.Segments.Profile.UserFollowersFollowingsComponents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.street_dancer_beta10.HomeActivity;
import com.example.street_dancer_beta10.R;
import com.example.street_dancer_beta10.Segments.Profile.Model.ProfileFollowersFollowingsModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerSetupFragment extends Fragment {
    private static final String TAG = "ViewPagerSetupFragment";

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private List<ProfileFollowersFollowingsModel> profileFollowersFollowingsModels;
    private Toolbar toolbar;

    public ViewPagerSetupFragment() {
        Log.d(TAG, "ViewPagerSetupFragment: opened");
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_view_page_setup, container, false);
        toolbar = view.findViewById(R.id.followers_following_toolbar_id);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = view.findViewById(R.id.view_pager);
        tableLayout = view.findViewById(R.id.tab_layout);

        setObjects();
        setAdapter();
    }

    private void setObjects(){

        profileFollowersFollowingsModels = new ArrayList<>();

        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("First person", "first status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Second person", "second status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Third person", "third status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fourth person", "fourth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fifth person", "fifth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("First person", "first status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Second person", "second status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Third person", "third status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fourth person", "fourth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fifth person", "fifth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("First person", "first status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Second person", "second status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Third person", "third status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fourth person", "fourth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fifth person", "fifth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("First person", "first status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Second person", "second status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Third person", "third status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fourth person", "fourth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("Fifth person", "fifth status", R.drawable.video_profile_image));
        profileFollowersFollowingsModels.add(new ProfileFollowersFollowingsModel("First person", "first status", R.drawable.video_profile_image));

    }

    private void setAdapter(){

        adapter = new ViewPagerAdapter(HomeActivity.fragmentManager);

        adapter.addFragment(new ProfileFollowersFollowingInfoFragment(profileFollowersFollowingsModels, true), "FOLLOWERS " + profileFollowersFollowingsModels.size());
        adapter.addFragment(new ProfileFollowersFollowingInfoFragment(profileFollowersFollowingsModels, false), "FOLLOWING");


        //adapter.addFragment(new ProfileFollowersFollowingInfoFragment(true), "FOLLOWERS " + profileFollowersFollowingsModels.size());
        //adapter.addFragment(new ProfileFollowersFollowingInfoFragment(false), "FOLLOWING");

        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);


    }
}
