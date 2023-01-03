package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Shape
{
    private double x, y, sideSize, height;
    private int shapesNumber;
    double[] X = new double[4];
    double[] Y = new double[4];
    ArrayList<Polygon> shapes = new ArrayList<>();
    public Shape(double x, double y, double sideSize)
    {
        shapesNumber = 1;
        height = 0;
        this.x = x;
        this.y= y;
        this.sideSize = sideSize;
    }
    public double getSideSize() {
        return sideSize;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setSideSize(double sideSize) {
        this.sideSize = sideSize;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void make(int n, Pane root)
    {
        if(n == 1)
            for(int i = 0; i < 4; i++)
            {
                Polygon polygon = new Polygon();
                if(i != 3)
                {
                    polygon.getPoints().addAll(x , y + Math.sqrt(3) * sideSize * i,
                            x - sideSize / 2, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i);
                    X[i] = x;
                    Y[i] = y + Math.sqrt(3) * sideSize * i;
                }

                else
                {
                    polygon.getPoints().addAll(this.x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize),
                            x - sideSize / 2 + 1.5 * sideSize, y + Math.sqrt(3) * sideSize / 2 + 1.5 * (Math.sqrt(3) * sideSize),
                            x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x + sideSize + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2,
                            x + sideSize + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize));
                    X[i] = this.x + 1.5 * sideSize;
                    Y[i] =  y + 1.5 * (Math.sqrt(3) * sideSize);
                }
                polygon.setFill(Color.rgb(199,142,255));
                polygon.setStroke(Color.WHITE);
                shapes.add(polygon);
                height = 3 * Math.sqrt(3) * sideSize;
            }
        if(n == 2)
            for(int i = 0; i < 4; i++)
            {
                Polygon polygon = new Polygon();
                if(i != 3)
                {
                    polygon.getPoints().addAll(x , y + Math.sqrt(3) * sideSize * i,
                            x - sideSize / 2, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i);
                    X[i] = x;
                    Y[i] =  y + Math.sqrt(3) * sideSize * i;
                }

                else
                {
                    polygon.getPoints().addAll(x - 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize),
                            x - 2 * sideSize, y + Math.sqrt(3) * sideSize / 2 + 1.5 * (Math.sqrt(3) * sideSize),
                            x - 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x - sideSize / 2, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2,
                            x - sideSize / 2, y + 1.5 * (Math.sqrt(3) * sideSize));
                    X[i] = x - 1.5 * sideSize;
                    Y[i] = y + 1.5 * (Math.sqrt(3) * sideSize);
                }
                polygon.setFill(Color.PINK);
                polygon.setStroke(Color.WHITE);
                shapes.add(polygon);
                height = 3 * Math.sqrt(3) * sideSize;
            }
        if(n == 3)
            for (int i = 0; i < 4; i++) {
                Polygon polygon = new Polygon();
                polygon.getPoints().addAll(x, y + Math.sqrt(3) * sideSize * i,
                        x - sideSize / 2, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                        x, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                        x + sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                        x + 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                        x + sideSize, y + Math.sqrt(3) * sideSize * i);
                X[i] = x;
                Y[i] =  y + Math.sqrt(3) * sideSize * i;
                polygon.setFill(Color.rgb(255, 255, 96));
                polygon.setStroke(Color.WHITE);
                shapes.add(polygon);
                height = 4 * Math.sqrt(3) * sideSize;
            }
        if(n == 4)
            for(int i = 0; i < 4; i++)
            {
                Polygon polygon = new Polygon();
                if(i != 3)
                {
                    polygon.getPoints().addAll(x , y + Math.sqrt(3) * sideSize * i,
                            x - sideSize / 2, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i);
                    X[i] = x;
                    Y[i] = y + Math.sqrt(3) * sideSize * i;
                }
                else
                {
                    polygon.getPoints().addAll(x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x - sideSize / 2 + 1.5 * sideSize, y + Math.sqrt(3) * sideSize / 2 + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize + Math.sqrt(3) * sideSize,
                            x + sideSize + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2 + Math.sqrt(3) * sideSize,
                            x + sideSize + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize);
                    X[i] = x + 1.5 * sideSize;
                    Y[i] = y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize;
                }
                polygon.setFill(Color.rgb(108,182,255));
                polygon.setStroke(Color.WHITE);
                shapes.add(polygon);
                height = 3.5 * Math.sqrt(3) * sideSize;
            }
        if(n == 5)
            for(int i = 0; i < 4; i++)
            {
                Polygon polygon = new Polygon();
                if(i <= 1)
                {
                    polygon.getPoints().addAll(x , y + Math.sqrt(3) * sideSize * i,
                            x - sideSize / 2, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i);
                    X[i] = x;
                    Y[i] =  y + Math.sqrt(3) * sideSize * i;
                }
                else
                {
                    polygon.getPoints().addAll(x - 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i - Math.sqrt(3) * sideSize / 2,
                            x - sideSize / 2 - 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2 - Math.sqrt(3) * sideSize / 2,
                            x - 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize - Math.sqrt(3) * sideSize / 2,
                            x + sideSize - 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize - Math.sqrt(3) * sideSize / 2,
                            x + 1.5 * sideSize - 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2 - Math.sqrt(3) * sideSize / 2,
                            x + sideSize - 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i - Math.sqrt(3) * sideSize / 2);
                    X[i] = x - 1.5 * sideSize;
                    Y[i] =  y + Math.sqrt(3) * sideSize * i - Math.sqrt(3) * sideSize / 2;
                }
                polygon.setFill(Color.rgb(121,255,121));
                polygon.setStroke(Color.WHITE);
                shapes.add(polygon);
                height = 3.5 * Math.sqrt(3) * sideSize;
            }
        if(n == 6)
            for(int i = 0; i < 4; i++)
            {
                Polygon polygon = new Polygon();
                if(i <= 1)
                {
                    polygon.getPoints().addAll(x , y + Math.sqrt(3) * sideSize * i,
                            x - sideSize / 2, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i);
                    X[i] = x;
                    Y[i] =  y + Math.sqrt(3) * sideSize * i;
                }
                if(i == 2)
                {
                    polygon.getPoints().addAll(x - 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize),
                            x - 2 * sideSize, y + Math.sqrt(3) * sideSize / 2 + 1.5 * (Math.sqrt(3) * sideSize),
                            x - 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x - sideSize / 2, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2,
                            x - sideSize / 2, y + 1.5 * (Math.sqrt(3) * sideSize));
                    X[i] = x - 1.5 * sideSize;
                    Y[i] = y + 1.5 * (Math.sqrt(3) * sideSize);
                }
                if(i == 3)
                {
                    polygon.getPoints().addAll(x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize),
                            x + sideSize, y + Math.sqrt(3) * sideSize / 2 + 1.5 * (Math.sqrt(3) * sideSize),
                            x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x + 2.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize,
                            x + 3 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2,
                            x + 2.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize));
                    X[i] = x + 1.5 * sideSize;
                    Y[i] = y + 1.5 * (Math.sqrt(3) * sideSize);
                }
                polygon.setFill(Color.rgb(255,130,130));
                polygon.setStroke(Color.WHITE);
                shapes.add(polygon);
                height = 2 * Math.sqrt(3) * sideSize;

            }
        if(n == 7)
            for(int i = 0; i < 4; i++)
            {
                Polygon polygon = new Polygon();
                if(i <= 1)
                {
                    polygon.getPoints().addAll(x , y + Math.sqrt(3) * sideSize * i,
                            x - sideSize / 2, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + Math.sqrt(3) * sideSize * i + Math.sqrt(3) * sideSize / 2,
                            x + sideSize, y + Math.sqrt(3) * sideSize * i);
                    X[i] = x;
                    Y[i] = y + Math.sqrt(3) * sideSize * i;
                }
                if(i == 2)
                {
                    polygon.getPoints().addAll(x - 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize,
                            x - 2 * sideSize, y + Math.sqrt(3) * sideSize / 2 + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize,
                            x - 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize - Math.sqrt(3) * sideSize,
                            x - sideSize / 2,y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize - Math.sqrt(3) * sideSize,
                            x, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2 - Math.sqrt(3) * sideSize,
                            x - sideSize / 2, y + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize);
                    X[i] = x - 1.5 * sideSize;
                    Y[i] = y + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize;
                }
                if(i == 3)
                {
                    polygon.getPoints().addAll(x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize,
                            x + sideSize, y + Math.sqrt(3) * sideSize / 2 + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize,
                            x + 1.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize - Math.sqrt(3) * sideSize,
                            x + 2.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize - Math.sqrt(3) * sideSize,
                            x + 3 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2 - Math.sqrt(3) * sideSize,
                            x  + 2.5 * sideSize, y + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize);
                    X[i] = x + 1.5 * sideSize;
                    Y[i] = y + 1.5 * (Math.sqrt(3) * sideSize) - Math.sqrt(3) * sideSize;
                }
                polygon.setFill(Color.rgb(255,182,108));
                polygon.setStroke(Color.WHITE);
                shapes.add(polygon);
                height = 2 * Math.sqrt(3) * sideSize;
            }
    }
    public int getShapesNumber()
    {
        return shapesNumber;
    }
    public void setShapesNumber(int n)
    {
        this.shapesNumber = n;
    }
    public double getHeight(int n)
    {
        if(n == 1)
            height = 3 * Math.sqrt(3) * sideSize;
        if(n == 2)
            height = 3 * Math.sqrt(3) * sideSize;
        if(n == 3)
            height = 4 * Math.sqrt(3) * sideSize;
        if(n == 4)
            height = 3.5 * Math.sqrt(3) * sideSize;
        if(n == 5)
            height = 3.5 * Math.sqrt(3) * sideSize;
        if(n == 6)
            height = 2 * Math.sqrt(3) * sideSize;
        if(n == 7)
            height = 2 * Math.sqrt(3) * sideSize;
        return height;
    }
    public void moveRight(Pane root)
    {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            arrayList.add(shapes.get(i));
        for(int i = 0; i < 4; i++)
        {
            root.getChildren().remove(this.shapes.get(i));
        }
        this.shapes.clear();
        for(int i = 0; i < 4; i++)
        {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(arrayList.get(i).getBoundsInParent().getCenterX() + sideSize, arrayList.get(i).getBoundsInParent().getCenterY(),
                    arrayList.get(i).getBoundsInParent().getCenterX() + sideSize / 2, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2,
                    arrayList.get(i).getBoundsInParent().getCenterX() + sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                    arrayList.get(i).getBoundsInParent().getCenterX() + 2 * sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                    arrayList.get(i).getBoundsInParent().getCenterX() + 2.5 * sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2,
                    arrayList.get(i).getBoundsInParent().getCenterX() + 2 * sideSize, arrayList.get(i).getBoundsInParent().getCenterY());
            if(getShapesNumber() == 1)polygon.setFill(Color.rgb(199,142,255));
            if(getShapesNumber() == 2)polygon.setFill(Color.PINK);
            if(getShapesNumber() == 3)polygon.setFill(Color.rgb(255, 255, 96));
            if(getShapesNumber() == 4)polygon.setFill(Color.rgb(108,182,255));
            if(getShapesNumber() == 5)polygon.setFill(Color.rgb(121,255,121));
            if(getShapesNumber() == 6)polygon.setFill(Color.rgb(255,130,130));
            if(getShapesNumber() == 7)polygon.setFill(Color.rgb(255,182,108));
            polygon.setStroke(Color.WHITE);
            arrayList.set(i, polygon);
        }
        for (int i = 0; i < 4; i++)
        {
            X[i] = arrayList.get(i).getBoundsInParent().getCenterX() - sideSize / 2;
            Y[i] = arrayList.get(i).getBoundsInParent().getCenterY() - Math.sqrt(3) * sideSize / 2;
        }
        for(int i = 0; i < 4; i++)
            shapes.add(arrayList.get(i));
        for(int i = 0; i < 4; i++)
            root.getChildren().add(shapes.get(i));
    }
    public void moveLeft(Pane root)
    {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            arrayList.add(shapes.get(i));
        for(int i = 0; i < 4; i++)
        {
            root.getChildren().remove(this.shapes.get(i));
        }
        this.shapes.clear();
        for(int i = 0; i < 4; i++)
        {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(arrayList.get(i).getBoundsInParent().getCenterX() - 2 * sideSize, arrayList.get(i).getBoundsInParent().getCenterY(),
                    arrayList.get(i).getBoundsInParent().getCenterX() - 2.5 * sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2,
                    arrayList.get(i).getBoundsInParent().getCenterX() - 2 * sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                    arrayList.get(i).getBoundsInParent().getCenterX() - sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                    arrayList.get(i).getBoundsInParent().getCenterX() - sideSize / 2, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2,
                    arrayList.get(i).getBoundsInParent().getCenterX() - sideSize, arrayList.get(i).getBoundsInParent().getCenterY());
            if(getShapesNumber() == 1)polygon.setFill(Color.rgb(199,142,255));
            if(getShapesNumber() == 2)polygon.setFill(Color.PINK);
            if(getShapesNumber() == 3)polygon.setFill(Color.rgb(255, 255, 96));
            if(getShapesNumber() == 4)polygon.setFill(Color.rgb(108,182,255));
            if(getShapesNumber() == 5)polygon.setFill(Color.rgb(121,255,121));
            if(getShapesNumber() == 6)polygon.setFill(Color.rgb(255,130,130));
            if(getShapesNumber() == 7)polygon.setFill(Color.rgb(255,182,108));
            polygon.setStroke(Color.WHITE);
            arrayList.set(i, polygon);
        }
        for (int i = 0; i < 4; i++)
        {
            X[i] = arrayList.get(i).getBoundsInParent().getCenterX() - sideSize / 2;
            Y[i] = arrayList.get(i).getBoundsInParent().getCenterY() - Math.sqrt(3) * sideSize / 2;
        }
        for(int i = 0; i < 4; i++)
            shapes.add(arrayList.get(i));
        for(int i = 0; i < 4; i++)
            root.getChildren().add(shapes.get(i));
    }
    public void rotate(Pane root)
    {
        for(int i = 0; i < 4; i++)
            root.getChildren().remove(this.shapes.get(i));
        for(int i = 0; i < 4; i++)
        {
            Rotate rotate = new Rotate(60.0, shapes.get(2).getBoundsInParent().getCenterX(), shapes.get(2).getBoundsInParent().getCenterY());
            shapes.get(i).getTransforms().add(rotate);
        }
        for (int i = 0; i < 4; i++)
        {
            X[i] = shapes.get(i).getBoundsInParent().getCenterX() - sideSize / 2;
            Y[i] = shapes.get(i).getBoundsInParent().getCenterY() - Math.sqrt(3) * sideSize / 2;
        }
        for(int i = 0; i < 4; i++)
            root.getChildren().add(this.shapes.get(i));
    }
    public void moveDown(Pane root)
    {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            arrayList.add(shapes.get(i));
        for(int i = 0; i < 4; i++)
        {
            root.getChildren().remove(this.shapes.get(i));
        }
        this.shapes.clear();
        for(int i = 0; i < 4; i++)
        {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(arrayList.get(i).getBoundsInParent().getCenterX() - sideSize / 2, arrayList.get(i).getBoundsInParent().getCenterY(),
                    arrayList.get(i).getBoundsInParent().getCenterX() - sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2,
                    arrayList.get(i).getBoundsInParent().getCenterX() - sideSize / 2, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                    arrayList.get(i).getBoundsInParent().getCenterX() + sideSize / 2, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                    arrayList.get(i).getBoundsInParent().getCenterX() + sideSize, arrayList.get(i).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2,
                    arrayList.get(i).getBoundsInParent().getCenterX() + sideSize / 2, arrayList.get(i).getBoundsInParent().getCenterY());
            if(getShapesNumber() == 1)polygon.setFill(Color.rgb(199,142,255));
            if(getShapesNumber() == 2)polygon.setFill(Color.PINK);
            if(getShapesNumber() == 3)polygon.setFill(Color.rgb(255, 255, 96));
            if(getShapesNumber() == 4)polygon.setFill(Color.rgb(108,182,255));
            if(getShapesNumber() == 5)polygon.setFill(Color.rgb(121,255,121));
            if(getShapesNumber() == 6)polygon.setFill(Color.rgb(255,130,130));
            if(getShapesNumber() == 7)polygon.setFill(Color.rgb(255,182,108));
            polygon.setStroke(Color.WHITE);
            arrayList.set(i, polygon);
        }
        for (int i = 0; i < 4; i++)
        {
            X[i] = arrayList.get(i).getBoundsInParent().getCenterX() - sideSize / 2;
            Y[i] = arrayList.get(i).getBoundsInParent().getCenterY() - Math.sqrt(3) * sideSize / 2;
        }
        for(int i = 0; i < 4; i++)
            shapes.add(arrayList.get(i));
        for(int i = 0; i < 4; i++)
            root.getChildren().add(shapes.get(i));
    }
}
