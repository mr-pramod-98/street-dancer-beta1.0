package com.example.street_dancer_beta10.Segments.Notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.street_dancer_beta10.Segments.Notification.Model.NotificationModel;
import com.example.street_dancer_beta10.R;

import java.util.List;

public class NotificationRecyclerViewAdapter extends RecyclerView.Adapter<NotificationRecyclerViewAdapter.MailViewHolder> {

    private List<NotificationModel> notificationModels;
    private Context context;

    public NotificationRecyclerViewAdapter(Context context, List notificationModels) {
        this.notificationModels = notificationModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_notification_items,
                parent, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MailViewHolder holder, int position) {

        holder.notification_profile.setText(notificationModels.get(position).getSender().substring(0, 1));
        holder.notification_sender.setText(notificationModels.get(position).getSender());
        holder.notification_details.setText(notificationModels.get(position).getDetails());
        holder.notification_time.setText(notificationModels.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return notificationModels.size();
    }

    public class MailViewHolder extends RecyclerView.ViewHolder {

        TextView notification_profile;
        TextView notification_sender;
        TextView notification_details;
        TextView notification_time;
        RelativeLayout relativeLayout;

        public MailViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.notifications_item_layout);
            notification_profile = itemView.findViewById(R.id.notification_profile);
            notification_sender = itemView.findViewById(R.id.notification_sender);
            notification_details = itemView.findViewById(R.id.notification_details);
            notification_time = itemView.findViewById(R.id.notification_time);
        }
    }
}
