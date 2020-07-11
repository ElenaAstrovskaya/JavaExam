package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Figure{

    private  double width;
    private double height;

    public Rectangle(double cx, double cy, double lineWidth, Color color, double width, double height) {
        super(FIGURE_TYPE_RECTANGLE, cx, cy, lineWidth, color);
        this.width = width < 10 ? 10 : width;
        this.height = height < 10 ? 10 : height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeRect(cx - width / 2, cy - height / 2, width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}