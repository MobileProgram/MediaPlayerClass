package com.mblhcmute.mediaplayerclass;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tạo một đối tượng MediaPlayer để phát lại âm thanh
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music_file);

        // đăng ký tất cả các nút bấm bằng các ID tương ứng của chúng
        Button bPlay = (Button) findViewById(R.id.playButton);
        Button bPause = (Button) findViewById(R.id.pauseButton);
        Button bStop = (Button) findViewById(R.id.stopButton);

        // xử lý sự kiện khi nhấn nút "Play" để bắt đầu phát lại âm thanh
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start method is used to start
                // playing the audio file
                mediaPlayer.start();
            }
        });

        // xử lý sự kiện khi nhấn nút "Pause" để tạm dừng phát lại âm thanh
        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pause() method can be used to
                // pause the mediaplyer instance
                mediaPlayer.pause();
            }
        });

        // xử lý sự kiện khi nhấn nút "Stop" để dừng phát lại âm thanh và chuẩn bị cho lần phát tiếp theo
        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stop() method is used to completely
                // stop playing the mediaplayer instance
                mediaPlayer.stop();

                // after stopping the mediaplayer instance
                // it is again need to be prepared
                // for the next instance of playback
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
