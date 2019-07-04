package com.example.rockapp;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class MP3Fragment extends Fragment  implements View.OnClickListener{
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private MediaPlayer mediaplayer;


    public MP3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mp3, container, false);

                mediaplayer = (MediaPlayer) MediaPlayer.create(getContext(), R.raw.sound1);

        //Obtenemos los tres botones de la interfaz
        btnPlay= (Button)view.findViewById(R.id.buttonPlay);
        btnStop= (Button)view.findViewById(R.id.buttonStop);
        btnPause= (Button)view.findViewById(R.id.buttonPause);

        //Y les asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch(v.getId()){
            case R.id.buttonPlay:
                //Iniciamos el audio
                mediaplayer.start();
                break;
            case R.id.buttonPause:
                //Pausamos el audio
                mediaplayer.pause();
                break;
            case R.id.buttonStop:
                //Paramos el audio y volvemos a inicializar
                try {
                    mediaplayer.stop();
                    mediaplayer.prepare();
                    mediaplayer.seekTo(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;

        }
    }
}
