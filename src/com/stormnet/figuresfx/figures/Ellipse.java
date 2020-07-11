package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Figure {

    private double width;
    private double height;

    public Ellipse(double cx, double cy, double lineWidth, Color color, double width, double height) {
        super(FIGURE_TYPE_ELLIPSE, cx, cy, lineWidth, color);
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
        gc.strokeOval(cx - width/2, cy -height/2, width, height);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ellipse{");
        sb.append("width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}