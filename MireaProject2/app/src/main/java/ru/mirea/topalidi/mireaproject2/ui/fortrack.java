package ru.mirea.topalidi.mireaproject2.ui;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import ru.mirea.topalidi.mireaproject2.R;

public class fortrack extends Service {
    public fortrack() {
    }

    private MediaPlayer mediaPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        mediaPlayer=MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}