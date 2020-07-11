package com.stormnet.figuresfx.controller;

import com.stormnet.figuresfx.drawutils.Drawer;
import com.stormnet.figuresfx.figures.*;
import com.stormnet.figuresfx.figures.ShapeIncorrectException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.*;

public class MainScreenController implements Initializable {

    List<Figure> figures = new ArrayList<Figure>();
    private Random random;

    private static final Logger log = Logger.getLogger(MainScreenController.class);

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("App is initialized");
        figures = Arrays.asList(new Figure[1]);
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        if (figures.get(figures.size() - 1) == null) {
            figures.set(figures.size() - 1, figure);
            return;
        }
        Figure[] tmp = new Figure[figures.size() + 1];
        int index = 0;

        for (; index < figures.size(); index++) {
            tmp[index] = figures.get(index);
        }
        tmp[index] = figure;
        figures = Arrays.asList(tmp);
    }

    private Figure createFigure(double x, double y) throws ShapeIncorrectException {
        Figure figure = null;

        switch (random.nextInt(9)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(5), Color.PURPLE, random.nextInt(50));
                log.info("The circle is painted");
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(5), Color.BLUE, random.nextInt(70), random.nextInt(40));
                log.info("The rectangle is painted");
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(5), Color.CORAL, random.nextInt(50), random.nextInt(60));
                log.info("The triangle is painted");
                break;
            case Figure.FIGURE_TYPE_STAR1:
                figure = new Star1(x, y, random.nextInt(5), Color.YELLOW, random.nextInt(40), random.nextInt(40));
                log.info("The star1 is painted");
                break;
            case Figure.FIGURE_TYPE_STAR2:
                figure = new Star2(x, y, random.nextInt(5), Color.PINK, random.nextInt(30), random.nextInt(30));
                log.info("The star2 is painted");
                break;
            case Figure.FIGURE_TYPE_SQUARE:
                figure = new Square(x, y, random.nextInt(5), Color.RED, random.nextInt(50));
                log.info("The square is painted");
                break;
            case Figure.FIGURE_TYPE_RHOMBUS:
                figure = new Rhombus(x, y, random.nextInt(5), Color.GREEN, random.nextInt(40), random.nextInt(60));
                log.info("The rhombus is painted");
                break;
            case Figure.FIGURE_TYPE_ELLIPSE:
                figure = new Ellipse(x, y, random.nextInt(5), Color.ORANGE, random.nextInt(50), random.nextInt(80));
                log.info("The ellipse is painted");
                break;
            default:
                throw new ShapeIncorrectException("Unknown figure type");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getHeight(), canvas.getWidth());
        Drawer<Figure> drawer = new Drawer<Figure>(figures);
        drawer.draw(canvas.getGraphicsContext2D());

        for (Figure figure : figures) {
            if (figure != null) {
                figure.draw(canvas.getGraphicsContext2D());
            }
        }
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (ShapeIncorrectException e) {
            log.error(e.getMessage(), e);
        }
        repaint();
    }
}
