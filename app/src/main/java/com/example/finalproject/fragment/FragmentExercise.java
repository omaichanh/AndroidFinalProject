package com.example.finalproject.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.VideoViewUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentExercise#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentExercise extends Fragment {
    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;
    private Button buttonRaw;
    private View v;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentExercise() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentExercise.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentExercise newInstance(String param1, String param2) {
        FragmentExercise fragment = new FragmentExercise();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_exercise, container, false);
        return v;
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        this.videoView = v.findViewById(R.id.videoView);
//        this.buttonRaw = v.findViewById(R.id.button_raw);
//
//        // Set the media controller buttons
//        if (this.mediaController == null) {
//            this.mediaController = new MediaController(getContext());
//
//            // Set the videoView that acts as the anchor for the MediaController.
//            this.mediaController.setAnchorView(videoView);
//
//            // Set MediaController for VideoView
//            this.videoView.setMediaController(mediaController);
//        }
//
//        // When the video file ready for playback.
//        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//
//            public void onPrepared(MediaPlayer mediaPlayer) {
//
//                videoView.seekTo(position);
//                if (position == 0) {
//                    videoView.start();
//                }
//            }
//        });
//
//        this.buttonRaw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // "myvideo.mp4" in directory "raw".
//                String resName = VideoViewUtils.RAW_VIDEO_SAMPLE;
//                VideoViewUtils.playRawVideo(getContext(), videoView, resName);
//            }
//        });
//    }
    }
