package opendownloader.com.opendownloader.lib.action;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import java.util.concurrent.Callable;

import opendownloader.com.opendownloader.lib.AppConstants;
import opendownloader.com.opendownloader.lib.CustomMessage;

public class FetchCachedImage implements Callable<Bitmap> {
    private final Bitmap bitmap;
    private final String url;
    private final Handler handler;

    public FetchCachedImage(String url, Bitmap bitmap, Handler handler) {
        this.bitmap = bitmap;
        this.url = url;
        this.handler = handler;
    }

    @Override
    public Bitmap call() throws Exception {
        Message msg = new Message();
        msg.what = AppConstants.DOWNLOAD_COMPLETE;
        msg.obj = new CustomMessage(url, null);
        handler.dispatchMessage(msg);
        return this.bitmap;
    }
}
