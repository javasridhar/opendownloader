package opendownloader.com.opendownloader;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import opendownloader.com.opendownloader.lib.AppConstants;
import opendownloader.com.opendownloader.lib.CustomMessage;
import opendownloader.com.opendownloader.lib.ImageDownloadHandler;

public class MainActivity extends AppCompatActivity {

    private ImageDownloadHandler handler = new ImageDownloadHandler();
    private ImageView imageView, imageView2, imageView3, imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        imageView = findViewById(R.id.image_view);
        imageView2 = findViewById(R.id.image_view2);
        imageView3 = findViewById(R.id.image_view3);
        imageView4 = findViewById(R.id.image_view4);
        toolbar.setTitle(R.string.app_name);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageView3.setOnClickListener(view -> {
            String url3 = "http://home.bt.com/images/seven-reasons-to-have-a-cup-of-tea-136390815669103901-140604103004.jpg";
            loadImage(url3, imageView3);

            String url1 = "https://upload.wikimedia.org/wikipedia/commons/3/37/Nice_Cup_of_Tea.jpg";
            loadImage(url1, imageView);

            String url2 = "https://cbtl-images.s3.us-west-1.amazonaws.com/Production/Drupal/s3fs-public/styles/cafe_menu_item_teaser/public/cafe-menu/Hot-Black-Tea.jpg";
            loadImage(url2, imageView2);

            String url4 = "https://i1.wp.com/kalimirchbysmita.com/wp-content/uploads/2018/02/Gud-Ki-Chai-Insta-01.jpg";
            loadImage(url4, imageView4);
        });
    }

    private void loadImage(String URL, View view) {
        Message msg = new Message();
        msg.obj = new CustomMessage(URL, view);
        msg.what = AppConstants.LOAD;
        handler.dispatchMessage(msg);
    }
}
