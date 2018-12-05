package opendownloader.com.opendownloader.lib.bitmaputils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapUtils {

    public static Bitmap getBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public static Bitmap resizeTo(byte[] bytes, int maxHeightOrWidth) {
        Bitmap bitmap = getBitmap(bytes);
        int outWidth;
        int outHeight;
        int inWidth = bitmap.getWidth();
        int inHeight = bitmap.getHeight();
        if(inWidth > inHeight){
            outWidth = maxHeightOrWidth;
            outHeight = (inHeight * maxHeightOrWidth) / inWidth;
        } else {
            outHeight = maxHeightOrWidth;
            outWidth = (inWidth * maxHeightOrWidth) / inHeight;
        }

        return Bitmap.createScaledBitmap(bitmap, outWidth, outHeight, false);
    }
}
