package com.example.fixtergeek.remotebound;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Handler;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import android.os.Messenger;


public class RemoteService extends Service {
    public RemoteService() {
    }

    class IncomingHanler extends Handler {
        @Override
        public void handleMessage(Message msg){
            Bundle data = msg.getData();
            String dataString = data.getString("MyString");
            Toast.makeText(getApplicationContext(),
                    dataString, Toast.LENGTH_SHORT).show();
        }
    }

    final Messenger myMessenger = new Messenger(new IncomingHanler());

    @Override
    public IBinder onBind(Intent intent) {
        return myMessenger.getBinder();
    }
}
