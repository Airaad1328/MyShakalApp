package com.gmail.clarkin200.myshakalapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HelloController {
    @FXML
    private ImageView mainImage;

    @FXML
    private Text myText;

    @FXML
    private ImageView resultImage;

    @FXML
    private Button shakalImage;

    @FXML
    private Slider shakalSlider;

    public void loadFile(ActionEvent actionEvent) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        // Устанавливаем фильтр для отображения только файлов определенного типа
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Только файлы изображений", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        // Открываем диалоговое окно выбора файла
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File myFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            InputStream inputStream = new FileInputStream(myFile);
            // Получаем выбранный файл
            mainImage.setImage(new Image(inputStream));
        } else {
            System.out.println("Выбор файла отменен.");
        }
    }
}