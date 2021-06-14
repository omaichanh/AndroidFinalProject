package com.example.finalproject.fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAlarm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAlarm extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText editText, editTextMessage;
    private Button bt;
    int notificationId = 1;
    final String CHANNEL_ID = "101";
    private View v;

    public FragmentAlarm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAlarm.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAlarm newInstance(String param1, String param2) {
        FragmentAlarm fragment = new FragmentAlarm();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("This is notification channel");
            NotificationManager manager = getContext().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_alarm, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createNotificationChannel();
        editText = v.findViewById(R.id.e1);
        editTextMessage = v.findViewById(R.id.editText_message);
        bt = v.findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                final String time = editText.getText().toString();
                String[] tmp = time.split(":");
                final int tmpHour, tmpMinute, tmpSecond;
                tmpHour = Integer.parseInt(tmp[0]);
                tmpMinute = Integer.parseInt(tmp[1]);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            Calendar c = Calendar.getInstance();
                            int hour, minute, second;
                            hour = c.get(Calendar.HOUR_OF_DAY);
                            minute = c.get(Calendar.MINUTE);
                            if (hour == tmpHour && minute == tmpMinute) {
                                NotificationCompat.Builder builder =
                                        new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                                                .setSmallIcon(R.drawable.ic_launcher_background)
                                                .setContentText(message)
                                                .setColor(Color.RED)
                                                .setPriority(NotificationCompat.PRIORITY_HIGH)
                                                .setAutoCancel(true);
                                NotificationManagerCompat notificationManagerCompat =
                                        NotificationManagerCompat.from(getContext());
                                notificationManagerCompat.notify(notificationId, builder.build());
                                break;
                            }
                        }
                    }
                }).start();
            }
        });
    }
}
