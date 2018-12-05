package opendownloader.com.opendownloader.lib.action;

import android.os.Message;

import java.util.concurrent.Callable;

import opendownloader.com.opendownloader.lib.AppConstants;
import opendownloader.com.opendownloader.lib.CustomMessage;
import opendownloader.com.opendownloader.lib.ImageDownloadHandler;

public class InformDownloadCompletion implements Callable<String> {
    private final ImageDownloadHandler handler;
    private String url;

    public InformDownloadCompletion(String url, ImageDownloadHandler handler) {
        this.url = url;
        this.handler = handler;
    }

    @Override
    public String call() throws Exception {
        CustomMessage customMessage = new CustomMessage(url, null);
        final Message msg = new Message();
        msg.what = AppConstants.DONE;
        msg.obj = customMessage;
        final InformDownloadCompletion that = this;
        handler.dispatchMessage(msg);
//        new Handler(this.handler.getLooper()).post(() -> that.handler.dispatchMessage(msg));
        return "";
    }
}
