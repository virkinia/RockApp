package com.example.rockapp;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer player;


    private String url = "http://www.radio-espana.es/25f74170-9dcb-463a-b102-a78f205a3ffa";
    Button btn_rne1;
    Button btn_rne3;
    Button btn_rne5;

    ImageButton btn_play;
    ImageButton btn_pause;
    ImageButton btn_stop;


    public RadioFragment() {
        // Required empty public constructor
    }

    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_radio, container, false);
        // Inicializo el objeto MediaPlayer
        initializeMediaPlayer();

        // Inicio el streaming de radio
        // startPlaying();

        btn_rne1 = v.findViewById(R.id.btn_rne_1);
        btn_rne3 = v.findViewById(R.id.btn_rne_3);
        btn_rne5 = v.findViewById(R.id.btn_rne_5);

        btn_play = v.findViewById(R.id.btn_play);
        btn_pause = v.findViewById(R.id.btn_pause);
        btn_stop = v.findViewById(R.id.btn_stop);

        btn_rne1.setOnClickListener(this);
        btn_rne3.setOnClickListener(this);
        btn_rne5.setOnClickListener(this);

        btn_play.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
        btn_stop.setOnClickListener(this);


        return v;


    }

    private void initializeMediaPlayer() {
        player = new MediaPlayer();

        player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {

            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                Log.i("Buffering", "" + percent);
            }
        });
    }

    public void startPlaying() {

        try {

            Toast.makeText(getContext(),
                    "Conectando con la radio, espere unos segundos...",
                    Toast.LENGTH_LONG).show();

            player.reset();
            player.setDataSource(url);
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);

            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp) {

                    player.start();

                }
            });

            player.prepareAsync();

        } catch (IllegalArgumentException | SecurityException
                | IllegalStateException | IOException e) {
            Toast.makeText(getContext(),
                    "Error al conectar con la radio", Toast.LENGTH_LONG).show();
        }

    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void stop() {

            player.stop();

            player.seekTo(0);

    }


    @Override
    public void onPause() {
        super.onPause();
        this.pause();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_play:
                //Iniciamos el audio
                startPlaying();
                break;
            case R.id.btn_pause:
                //Pausamos el audio
                pause();
                break;
            case R.id.btn_stop:
                //Paramos el audio y volvemos a inicializar
                stop();
                break;
            case R.id.btn_rne_1:
                //Iniciamos el audio

                setUrl("http://radio3.rtveradio.cires21.com/radio3.mp3");
                startPlaying();
                break;
            case R.id.btn_rne_3:
                //Pausamos el audio
                pause();
                break;
            case R.id.btn_rne_5:
                //Paramos el audio y volvemos a inicializar
                stop();
                break;

        }
    }

}

