package com.example.rockapp;



import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFileFragment extends Fragment implements View.OnClickListener {
    VideoView videoView;

    public VideoFileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_videofile, container, false);

        Button btnPlay= (Button)v.findViewById(R.id.playFile);
        videoView = (VideoView) v.findViewById(R.id.video_view);


        //Y les asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        return v;
    }




    @Override
    public void onClick(View v) {
        //Basic of video
        //1. get video view


        //2. point to video resource
        String uriPath = "android.resource://"+ getActivity().getPackageName()+ "/" + R.raw.testvideocam;

        //3. Parseamos el string
        Uri uri = Uri.parse(uriPath);

        videoView.setVideoURI(uri);
        videoView.requestFocus();


        //add media Control
        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        //run it
        videoView.start();

    }

}
