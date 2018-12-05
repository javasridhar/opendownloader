package opendownloader.com.opendownloader.lib;

import android.view.View;

public class CustomMessage {
    private String URL;
    private View view;
    public CustomMessage(String URL, View view) {
        this.URL = URL;
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public String getURL() {
        return URL;
    }
}
