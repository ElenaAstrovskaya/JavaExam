package com.stormnet.figuresfx.drawutils;

import com.stormnet.figuresfx.controller.MainScreenController;
import com.stormnet.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Drawer<T extends Figure & Drawable> {

    private static final Logger log = Logger.getLogger(MainScreenController.class);

    List<Figure> figures = new ArrayList<Figure>();

    public Drawer(List<Figure> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext gc) {
        for (Figure figure : figures) {
            figure.draw(gc);
        }
    }
}