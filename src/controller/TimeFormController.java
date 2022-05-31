package controller;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormController {
    public Label lbltime;
    public void initialize(){
        RunningTime();



    }

    private void RunningTime() {
        final Thread thread = new Thread(()->{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true){
                try {
                    Thread .sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(()-> {
                    lbltime.setText("Hora Atual: \n"+ time);
                });
            }


        });
        thread.start();
    }

    private class Date extends java.util.Date {
    }
}
