package br.com.anhembimorumbi.util;

import static java.awt.Image.SCALE_SMOOTH;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public final class Utils {

    private Utils() {
    }

    public static ImageIcon renderizandoIcone(String path) {
        URL imagePath = Utils.class.getResource(path);
        Image originalImage = new ImageIcon(imagePath).getImage().getScaledInstance(147, 112, SCALE_SMOOTH);
        return new ImageIcon(originalImage);
    }
}
