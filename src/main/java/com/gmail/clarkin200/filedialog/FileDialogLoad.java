package com.gmail.clarkin200.filedialog;


import javafx.scene.image.Image;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileDialogLoad {
    private JFileChooser fileChooser;
    private FileNameExtensionFilter filter;

    public FileDialogLoad() {
        fileChooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Только файлы изображений", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
    }

    public Image loadFile() throws FileNotFoundException {
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File myFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            InputStream inputStream = new FileInputStream(myFile);
            return new Image(inputStream);
        } else {
            System.out.println("Выбор файла отменен.");
            throw new FileNotFoundException("Файл не знайдено");
        }
    }
}
