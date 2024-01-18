package group.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;

import java.io.IOException;

public class HelloController {
    @FXML

    ImageView mainImage;
    Button switchButton;

    boolean newImage = true;
    boolean switched = false;
    Image currentOriginalImage;
    Image lastEditedImage;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void newImageCheck() {
        if (newImage) {
            currentOriginalImage = mainImage.getImage();
            newImage = false;
        }
    }

    public void negative(ActionEvent e) {
        newImageCheck();
        Image originalImage = mainImage.getImage();
        int width = (int) originalImage.getWidth();
        int height = (int) originalImage.getHeight();

        WritableImage newImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color originalColor = originalImage.getPixelReader().getColor(x, y);
                Color newColor = originalColor.invert();
                newImage.getPixelWriter().setColor(x, y, newColor);
            }
        }
        mainImage.setImage(newImage);
    }

    public void grayscale(ActionEvent e) {
        newImageCheck();
        Image originalImage = mainImage.getImage();
        int width = (int) originalImage.getWidth();
        int height = (int) originalImage.getHeight();

        WritableImage newImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color originalColor = originalImage.getPixelReader().getColor(x, y);
                Color newColor = originalColor.grayscale();
                newImage.getPixelWriter().setColor(x, y, newColor);
            }
        }
        mainImage.setImage(newImage);
    }

    public void red(ActionEvent e) {
        newImageCheck();
        Image originalImage = mainImage.getImage();
        int width = (int) originalImage.getWidth();
        int height = (int) originalImage.getHeight();

        WritableImage newImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color originalColor = originalImage.getPixelReader().getColor(x, y);
                Color newColor = Color.color(1, originalColor.getGreen(), originalColor.getBlue());
                newImage.getPixelWriter().setColor(x, y, newColor);
            }
        }
        mainImage.setImage(newImage);
    }

    public void green(ActionEvent e) {
        newImageCheck();
        Image originalImage = mainImage.getImage();
        int width = (int) originalImage.getWidth();
        int height = (int) originalImage.getHeight();

        WritableImage newImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color originalColor = originalImage.getPixelReader().getColor(x, y);
                Color newColor = Color.color(originalColor.getRed(), 1, originalColor.getBlue());
                newImage.getPixelWriter().setColor(x, y, newColor);
            }
        }
        mainImage.setImage(newImage);
    }

    public void blue(ActionEvent e) {
        newImageCheck();
        Image originalImage = mainImage.getImage();
        int width = (int) originalImage.getWidth();
        int height = (int) originalImage.getHeight();

        WritableImage newImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color originalColor = originalImage.getPixelReader().getColor(x, y);
                Color newColor = Color.color(originalColor.getRed(), originalColor.getGreen(), 1);
                newImage.getPixelWriter().setColor(x, y, newColor);
            }
        }
        mainImage.setImage(newImage);
    }

    public void exitProgram(ActionEvent e) {
        System.exit(0);
    }

    public void switchBack(ActionEvent e) {
        if (!(newImage)) {
            if (switched) {
                mainImage.setImage(lastEditedImage);
                switched = false;
            } else {
                lastEditedImage = mainImage.getImage();
                mainImage.setImage(currentOriginalImage);
                switched = true;
            }
        }
    }

    public void switchToAboutScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMainScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*
    public void blur(ActionEvent e) {
        newImageCheck();
        Image originalImage = mainImage.getImage();
        int width = (int) originalImage.getWidth();
        int height = (int) originalImage.getHeight();


        WritableImage newImage = new WritableImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int startX = Math.max((x - 1), 0);
                int startY = Math.max((y - 1), 0);
                int endX = Math.min((x + 1), width);
                int endY = Math.min((x + 1), height);

                int numOfLoops = 0;
                int newRed = 0;
                int newGreen = 0;
                int newBlue = 0;
                for (int xFlow = startX; xFlow < endX; xFlow++) {
                    for (int yFlow = startY; yFlow < endY; yFlow++) {
                        newRed += originalImage.getPixelReader().getColor(x+xFlow, y+yFlow).getRed();
                        newGreen += originalImage.getPixelReader().getColor(x+xFlow, y+yFlow).getGreen();
                        newBlue += originalImage.getPixelReader().getColor(x+xFlow, y+yFlow).getBlue();
                        numOfLoops++;
                    }
                }
                Color newColor;
                if (numOfLoops > 0) {

                    newColor = Color.color(newRed/numOfLoops, newGreen/numOfLoops, newBlue/numOfLoops);
                } else {
                    newColor = Color.color(1, 1, 1);
                }

                newImage.getPixelWriter().setColor(x, y, newColor);
            }
        }
        mainImage.setImage(newImage);
    }
    */
}