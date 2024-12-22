package com.gmail.clarkin200.filedialog;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileDialogSaveAs {

    JFileChooser fileChooser;

    public FileDialogSaveAs() {
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить изображение");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Изображения (*.png, *.jpg)", "png", "jpg"));
    }

    public void saveNodeAsImage(Image save) {
        BufferedImage image = SwingFXUtils.fromFXImage(save, null);
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getAbsolutePath().endsWith(".png") && !fileToSave.getAbsolutePath().endsWith(".jpg")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".png"); // По умолчанию .png
            }

            try {
                ImageIO.write(image, "png", fileToSave);
                System.out.println("Изображение сохранено: " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Ошибка при сохранении изображения: " + e.getMessage());
            }
        } else {
            System.out.println("Сохранение отменено пользователем.");
        }
    }

}
