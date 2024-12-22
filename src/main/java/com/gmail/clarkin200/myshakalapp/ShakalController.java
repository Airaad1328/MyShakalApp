package com.gmail.clarkin200.myshakalapp;

import com.gmail.clarkin200.filedialog.FileDialogLoad;
import com.gmail.clarkin200.filedialog.FileDialogSaveAs;
import com.gmail.clarkin200.service.Shakalizator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


import java.io.*;

public class ShakalController {
    @FXML
    public Button shakalImage;
    @FXML
    private ImageView mainImage;

    @FXML
    private Text myText;

    @FXML
    private ImageView resultImage;

    @FXML
    private Slider shakalSlider;

    @FXML
    private Slider compressionLevel;

    @FXML
    private CheckBox toNegative;

    public void loadFile(ActionEvent actionEvent) throws FileNotFoundException {
        FileDialogLoad fileDialogLoad = new FileDialogLoad();
        mainImage.setImage(fileDialogLoad.loadFile());
    }

    @FXML
    void shakalOnClick(ActionEvent event) {
        Shakalizator shakalizator = new Shakalizator();
        Image returnImage = shakalizator.shakalImage(mainImage.getImage(),
                shakalSlider.getValue() / 10,
                compressionLevel.getValue());

        if (toNegative.isSelected()) {
            returnImage = shakalizator.toNegative(returnImage);
        }
        resultImage.setImage(returnImage);


    }


    public void saveFileAs(ActionEvent actionEvent) {
        FileDialogSaveAs fileSave = new FileDialogSaveAs();
        fileSave.saveNodeAsImage(resultImage.getImage());
    }

    public void exitApplication(ActionEvent actionEvent) {

    }
}