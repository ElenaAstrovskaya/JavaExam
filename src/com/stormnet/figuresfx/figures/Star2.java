package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star2 extends Figure{

    private double a;

    public Star2(double cx, double cy, double lineWidth, Color color, double a, int i) {
        super(FIGURE_TYPE_STAR2, cx, cy, lineWidth, color);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx - a*2,   cx,       cx + a*2,   cx - a*3, cx + a*3},
                new double[]{cy + a*2.5, cy - a*4, cy + a*2.5, cy - a*2, cy - a*2},
                5);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Star2{");
        sb.append("a=").append(a);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}