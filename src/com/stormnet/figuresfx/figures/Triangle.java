package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Figure{

    private double height;
    private double base;

    public Triangle(double cx, double cy, double lineWidth, Color color, int height, int base) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
        this.height = height < 10 ? 10 : height;
        this.base = base < 10 ? 10 : base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx, cx - base / 2, cx + base / 2},
                new double[]{cy - height, cy + height / 2, cy + height / 2},
                3);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("height=").append(height);
        sb.append(", base=").append(base);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}