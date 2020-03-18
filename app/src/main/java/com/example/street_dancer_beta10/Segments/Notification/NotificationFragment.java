package com.example.street_dancer_beta10.Segments.Notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.street_dancer_beta10.Segments.Notification.Model.NotificationModel;
import com.example.street_dancer_beta10.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {


    private RecyclerView recyclerView;
    private NotificationRecyclerViewAdapter adapter;
    List<NotificationModel> notificationModels;
    private androidx.appcompat.widget.Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        toolbar = view.findViewById(R.id.toolbar_notifications);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.notification_recycler_view);

        setObjects();
        setAdapter();
    }

    private void setAdapter() {

        adapter = new NotificationRecyclerViewAdapter(getContext(), notificationModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLinearLayoutManager);

    }

    private void setObjects() {
        notificationModels = new ArrayList<>();

        notificationModels.add(new NotificationModel("Sam",
                "Sam, some people you may know",
                "13.33pm"));
        notificationModels.add(new NotificationModel("Facebook",
                "A lot has happened on Facebook since",
                "16:04pm"));
        notificationModels.add(new NotificationModel("Google+",
                "Top suggested Google+ pages for you",
                "18:44pm"));
        notificationModels.add(new NotificationModel("Twitter",
                "James, some people you may know",
                "20:04pm"));
        notificationModels.add(new NotificationModel("Twitter",
                "James, some people you may know",
                "20:04pm"));
        notificationModels.add(new NotificationModel("Josh",
                "James, some people you may know",
                "01:04am"));
        notificationModels.add(new NotificationModel("Sam",
                "Sam, some people you may know",
                "13.33pm"));
        notificationModels.add(new NotificationModel("Facebook",
                "A lot has happened on Facebook since",
                "16:04pm"));
        notificationModels.add(new NotificationModel("Google+",
                "Top suggested Google+ pages for you",
                "18:44pm"));
        notificationModels.add(new NotificationModel("Twitter",
                "James, some people you may know",
                "20:04pm"));
        notificationModels.add(new NotificationModel("Twitter",
                "James, some people you may know",
                "20:04pm"));
        notificationModels.add(new NotificationModel("Josh",
                "James, some people you may know",
                "01:04am"));
        notificationModels.add(new NotificationModel("Sam",
                "Sam, some people you may know",
                "13.33pm"));
    }

}
