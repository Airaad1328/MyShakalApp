package com.gmail.clarkin200.service;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;


public class Shakalizator {

    public Image shakalImage(Image input, double noiseLevel, double blockSize) {
        int imageWidth = (int) input.getWidth();
        int imageHeight = (int) input.getHeight();
        WritableImage shakalizedImage = new WritableImage(imageWidth, imageHeight);
        PixelReader pixelReader = input.getPixelReader();
        PixelWriter pixelWriter = shakalizedImage.getPixelWriter();

        for (int y = 0; y < imageHeight; y += blockSize) {
            for (int x = 0; x < imageWidth; x += blockSize) {

                Color color = pixelReader.getColor(x, y);


                double red = clamp(color.getRed() + (Math.random() - 0.5) * noiseLevel);
                double green = clamp(color.getGreen() + (Math.random() - 0.5) * noiseLevel);
                double blue = clamp(color.getBlue() + (Math.random() - 0.5) * noiseLevel);
                Color noisyColor = new Color(red, green, blue, color.getOpacity());


                for (int dy = 0; dy < blockSize; dy++) {
                    for (int dx = 0; dx < blockSize; dx++) {
                        int px = x + dx;
                        int py = y + dy;
                        if (px < imageWidth && py < imageHeight) {
                            pixelWriter.setColor(px, py, noisyColor);
                        }
                    }
                }
            }
        }
        return shakalizedImage;
    }

    public Image toNegative(Image input) {
        int imageWidth = (int) input.getWidth();
        int imageHeight = (int) input.getHeight();
        WritableImage negativeImage = new WritableImage(imageWidth, imageHeight);
        PixelReader pixelReader = input.getPixelReader();
        PixelWriter pixelWriter = negativeImage.getPixelWriter();

        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {

                Color color = pixelReader.getColor(x, y);

                Color negativeColor = new Color(1 - color.getRed(), 1 - color.getGreen(), 1 - color.getBlue(), color.getOpacity());


                pixelWriter.setColor(x, y, negativeColor);

            }
        }
        return negativeImage;

    }


    private double clamp(double value) {
        return Math.min(1.0, Math.max(0.0, value));
    }
}
