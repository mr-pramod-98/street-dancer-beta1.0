package com.example.street_dancer_beta10.Segments.Profile.UserFollowersFollowingsComponents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.street_dancer_beta10.R;
import com.example.street_dancer_beta10.Segments.Profile.Model.ProfileFollowersFollowingsModel;

import java.util.List;

public class ProfileRecyclerViewFollowersFollowingAdapter extends RecyclerView.Adapter<ProfileRecyclerViewFollowersFollowingAdapter.MyViewHolder> {

    Context context;
    private List<ProfileFollowersFollowingsModel> profileFollowersFollowingsModels;
    private boolean isFollowersFocused;


    public ProfileRecyclerViewFollowersFollowingAdapter(Context context, List<ProfileFollowersFollowingsModel> profileFollowersFollowingsModels, boolean isFollowersFocused) {
        this.context = context;
        this.profileFollowersFollowingsModels = profileFollowersFollowingsModels;
        this.isFollowersFocused = isFollowersFocused;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_profile_followers_followings_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        if (isFollowersFocused) {
            holder.button.setText("following");
        } else {
            holder.button.setText("remove");
        }
        holder.username.setText(profileFollowersFollowingsModels.get(position).getUserName());
        holder.username_name.setText(profileFollowersFollowingsModels.get(position).getName());
        holder.profile.setImageResource(profileFollowersFollowingsModels.get(position).getUserProfile());

        /*holder.followers_followings_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked on " + profileFollowersFollowingsModels.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return profileFollowersFollowingsModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView username;
        private TextView username_name;
        private TextView button;
        private ImageView profile;
        private RelativeLayout followers_followings_item;

        public MyViewHolder(View itemView) {
            super(itemView);

            profile = (ImageView) itemView.findViewById(R.id.followers_following_profile);
            username = (TextView) itemView.findViewById(R.id.followers_following_username);
            button = (TextView) itemView.findViewById(R.id.button);
            username_name = (TextView) itemView.findViewById(R.id.followers_following_name);
            //followers_followings_item = (RelativeLayout) itemView.findViewById(R.id.followers_followings_item);

        }
    }
}
