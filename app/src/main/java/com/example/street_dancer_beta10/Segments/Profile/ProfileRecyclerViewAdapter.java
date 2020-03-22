package com.example.street_dancer_beta10.Segments.Profile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.street_dancer_beta10.R;
import com.example.street_dancer_beta10.SharedComponents.Models.MediaObject;

import java.util.ArrayList;

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.VideoViewHolder> {
    private static final String TAG = "ProfileRecyclerViewAdap";

    private Context context;
    private ArrayList<MediaObject> mediaObjects;
    private Listener listener;
    private RequestManager requestManager;

    public ProfileRecyclerViewAdapter(Context context, ArrayList<MediaObject> mediaObjects, RequestManager requestManager) {
        this.context = context;
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;
    }

  public interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.recycler_view_profile_user_upload_items,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, final int position) {
        this.requestManager
                .load(mediaObjects.get(position).getThumbnail())
                .into(holder.thumbnail);


        Log.d(TAG, "onClick: ProfileRecyclerViewAdap : pos -> " + position + " listener -> " + listener);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ProfileRecyclerViewAdap : pos -> " + position + " listener -> " + listener);

                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView thumbnail;

        public VideoViewHolder(View itemView){
            super(itemView);
            thumbnail = itemView.findViewById(R.id.post_thumbnail);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

}
