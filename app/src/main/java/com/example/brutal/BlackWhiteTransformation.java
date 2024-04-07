package com.example.brutal;
import android.graphics.Bitmap;
import android.graphics.Color;

import com.squareup.picasso.Transformation;

public class BlackWhiteTransformation implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        // Convert the image to black and white
        Bitmap resultBitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), source.getConfig());
        // Iterate through each pixel in the bitmap
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                int pixel = source.getPixel(x, y);
                int gray = (int) (0.2989 * Color.red(pixel) + 0.5870 * Color.green(pixel) + 0.1140 * Color.blue(pixel));
                int newPixel = Color.rgb(gray, gray, gray);
                resultBitmap.setPixel(x, y, newPixel);
            }
        }
        source.recycle(); // Recycle the original bitmap
        return resultBitmap;
    }

    @Override
    public String key() {
        return "black_white_transformation";
    }
}