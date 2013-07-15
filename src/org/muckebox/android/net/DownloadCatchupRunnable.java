package org.muckebox.android.net;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.muckebox.android.Muckebox;
import org.muckebox.android.utils.BufferUtils;

import android.os.Handler;
import android.util.Log;

public class DownloadCatchupRunnable implements Runnable {
    private final static String LOG_TAG = "DownloadCatchupRunnable";
    private final static long BUFFER_SIZE = 32 * 1024;
    
    public static final int MESSAGE_DATA_RECEIVED   = 10;
    public static final int MESSAGE_DATA_COMPLETE   = 11;
    public static final int MESSAGE_ERROR           = 12;
    
    private String mFilename;
    private int mTrackId;
    private Handler mHandler;
    private long mBytesToRead;
    
    public DownloadCatchupRunnable(String filename, long bytesToRead, int trackId, Handler handler) {
        mFilename = filename;
        mTrackId = trackId;
        mHandler = handler;
        mBytesToRead = bytesToRead;
    }

    @Override
    public void run() {
        try {
            FileInputStream input = Muckebox.getAppContext().openFileInput(mFilename);
            boolean eofSeen;
            
            do {
                ByteBuffer buf = ByteBuffer.allocate((int) Math.min(mBytesToRead, BUFFER_SIZE));
                
                eofSeen = BufferUtils.readIntoBuffer(input, buf);
                
                if (mHandler != null)
                    mHandler.sendMessage(mHandler.obtainMessage(
                        MESSAGE_DATA_RECEIVED, mTrackId, 0, buf));
                
                mBytesToRead -= buf.position();
            } while (mBytesToRead > 0 || eofSeen);
            
            if (mBytesToRead > 0)
                Log.e(LOG_TAG, "Could not read all bytes (" + mBytesToRead + " left)");
            
            if (mHandler != null)
                mHandler.sendMessage(mHandler.obtainMessage(
                    MESSAGE_DATA_COMPLETE, mTrackId, 0));
        } catch (IOException e) {
            Log.e(LOG_TAG, "failed to catch up!");
            
            e.printStackTrace();
            
            if (mHandler != null)
                mHandler.sendMessage(mHandler.obtainMessage(MESSAGE_ERROR, mTrackId));
        }
    }

}
