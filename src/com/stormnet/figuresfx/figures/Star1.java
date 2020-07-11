package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star1 extends Figure {

    private double a;

    public Star1(double cx, double cy, double lineWidth, Color color, double a, double b) {
        super(FIGURE_TYPE_STAR1, cx, cy, lineWidth, color);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx + a*3, cx,         cx - a*3, cx - a * 1.5, cx - a * 4, cx - a, cx,         cx + a, cx + a * 4, cx + a * 1.5},
                new double[]{cy + a*4, cy + a * 2, cy + a*4, cy + a,       cy - a,     cy - a, cy - a * 4, cy - a, cy - a,     cy + a},
                10);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Star{");
        sb.append("a=").append(a);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}