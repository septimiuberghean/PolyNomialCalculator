package com.example.calculatorproject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class ViewManager {
    public static void initializeImages(ImageView bmoImageView, ImageView sodaImageView, ImageView cryImageView, ImageView stressImageView, ImageView danceImageView) {
        File bmoFile = new File("BMO/bmo.jpg");
        Image bmoImage = new Image(bmoFile.toURI().toString());
        bmoImageView.setImage(bmoImage);

        File bmosodaFile = new File("BMO/bmosoda.jpg");
        Image sodaImage = new Image(bmosodaFile.toURI().toString());
        sodaImageView.setImage(sodaImage);

        File cryFile = new File("BMO/bmocry.jpg");
        Image cryImage = new Image(cryFile.toURI().toString());
        cryImageView.setImage(cryImage);

        File stressFile = new File("BMO/bmoerror.jpg");
        Image stressImage = new Image(stressFile.toURI().toString());
        stressImageView.setImage(stressImage);

        File danceFile = new File("BMO/bmodance.jpg");
        Image danceImage = new Image(danceFile.toURI().toString());
        danceImageView.setImage(danceImage);
    }
}
