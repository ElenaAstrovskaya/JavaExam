package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Figure{

    private double radius;

    public Circle(double cx, double cy, double lineWidth, Color color, double radius) {
        super(FIGURE_TYPE_CIRCLE, cx, cy, lineWidth, color);
        this.radius = radius < 10 ? 10 : radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append("radius=").append(radius);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}