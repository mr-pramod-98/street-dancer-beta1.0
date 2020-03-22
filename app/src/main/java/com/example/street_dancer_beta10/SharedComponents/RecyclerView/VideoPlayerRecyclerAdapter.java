package com.example.street_dancer_beta10.SharedComponents.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.street_dancer_beta10.R;
import com.example.street_dancer_beta10.SharedComponents.Models.MediaObject;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class VideoPlayerRecyclerAdapter extends RecyclerView.Adapter<VideoPlayerRecyclerAdapter.VideoPlayerViewHolder> {

    private ArrayList<MediaObject> mediaObjects;
    private RequestManager requestManager;
    private Context context;

    public VideoPlayerRecyclerAdapter(Context context, ArrayList<MediaObject> mediaObjects, RequestManager requestManager) {
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoPlayerRecyclerAdapter.VideoPlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_video_item, parent, false);
        VideoPlayerViewHolder videoPlayerViewHolder = new VideoPlayerViewHolder(view);
        return videoPlayerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoPlayerViewHolder holder, int position) {
        holder.onBind(mediaObjects.get(position), requestManager);

       /* // SET A LISTENER TO TRACK THE CHANGE OF STATE OF THE TOGGLE-BUTTON
        holder.like_post.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(context, "post liked", Toast.LENGTH_LONG).show();
                    buttonView.setChecked(true);
                }else {
                    Toast.makeText(context, "post un-liked", Toast.LENGTH_LONG).show();
                    buttonView.setChecked(false);
                }
            }
        });*/

        // SET A LISTENER TO TRACK THE CHANGE OF STATE OF THE TOGGLE-BUTTON
        holder.bookmark_post.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    Snackbar.make(holder.coordinatorLayout, "Saved", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .setActionTextColor(Color.parseColor("#F7330C"))
                            .show();
                    buttonView.setChecked(true);
                } else {
                    buttonView.setChecked(false);
                }
            }
        });

        // SET A LISTENER TO TRACK THE CLICK EVENT ON THE "send" IMAGE-VIEW
        holder.send_post.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, mediaObjects.get(position).getMedia_url());
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(context, shareIntent, null);

        });
    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }


    // SETTING-UP OF VIEW-HOLDER
    public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {

        FrameLayout media_container;
        ImageView thumbnail, volumeControl;
        ProgressBar progressBar;
        View parent;
        RequestManager requestManager;
        ImageView send_post;
        ToggleButton bookmark_post;
        CoordinatorLayout coordinatorLayout;

        public VideoPlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView;
            send_post = itemView.findViewById(R.id.send);
            media_container = itemView.findViewById(R.id.media_container);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            progressBar = itemView.findViewById(R.id.progressBar);
            volumeControl = itemView.findViewById(R.id.volume_control);
            bookmark_post = itemView.findViewById(R.id.bookmark);
            coordinatorLayout = itemView.findViewById(R.id.coordinator);
        }

        public void onBind(MediaObject mediaObject, RequestManager requestManager) {
            this.requestManager = requestManager;
            parent.setTag(this);
            this.requestManager
                    .load(mediaObject.getThumbnail())
                    .into(thumbnail);
        }
    }
}
