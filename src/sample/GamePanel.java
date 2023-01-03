package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class GamePanel
{
    private double hight, width, sideSize, rowY;
    public GamePanel(double hight, double width, double r)
    {
        this.sideSize = r;
        this.hight = hight;
        this.width = width;
        rowY = 0;
    }
    public void makeGamePanel(Pane root)//making game's panel
    {
        for(int i = 0; i < 22; i++)//making the left column
        {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(sideSize / 2, i * Math.sqrt(3) * sideSize,
                    0.0, i * Math.sqrt(3) * sideSize + Math.sqrt(3) * sideSize / 2,
                    sideSize / 2, (i + 1) * Math.sqrt(3) * sideSize,
                    1.5 * sideSize, (i + 1) * Math.sqrt(3) * sideSize,
                    2 * sideSize, i * Math.sqrt(3) * sideSize + Math.sqrt(3) * sideSize / 2,
                    1.5 * sideSize, i * Math.sqrt(3) * sideSize );
            polygon.setFill(Color.BLACK);
            polygon.setStroke(Color.WHITE);
            root.getChildren().add(polygon);
        }
        for(int i = 0; i < 22; i++)//making the right column
        {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(sideSize / 2 + width - 2 * sideSize, i * Math.sqrt(3) * sideSize,
                    width - 2 * sideSize, i * Math.sqrt(3) * sideSize + Math.sqrt(3) * sideSize / 2,
                    sideSize / 2 + width - 2 * sideSize, (i + 1) * Math.sqrt(3) * sideSize,
                    1.5 * sideSize + width - 2 * sideSize, (i + 1) * Math.sqrt(3) * sideSize,
                    2 * sideSize + width - 2 * sideSize, i * Math.sqrt(3) * sideSize + Math.sqrt(3) * sideSize / 2,
                    1.5 * sideSize + width - 2 * sideSize, i * Math.sqrt(3) * sideSize);
            polygon.setFill(Color.BLACK);
            polygon.setStroke(Color.WHITE);
            root.getChildren().add(polygon);
        }
        for(int i = 0; i < 13; i++)//making the row
        {
            Polygon polygon = new Polygon();
            if(i % 2 == 0)
            {
                polygon.getPoints().addAll(i * 1.5 * sideSize + 2 * sideSize, hight - (1.5 * Math.sqrt(3) * sideSize),
                        i * 1.5 * sideSize + 1.5 * sideSize, hight - (Math.sqrt(3) * sideSize),
                        i * 1.5 * sideSize + 2 * sideSize, hight - (Math.sqrt(3) * sideSize / 2),
                        i * 1.5 * sideSize + 3 * sideSize, hight - (Math.sqrt(3) * sideSize / 2),
                        i * 1.5 * sideSize + 3.5 * sideSize, hight - (Math.sqrt(3) * sideSize),
                        i * 1.5 * sideSize + 3 * sideSize, hight - (1.5 * Math.sqrt(3) * sideSize));
                rowY = hight - (1.5 * Math.sqrt(3) * sideSize);
            }

            else
            {
                polygon.getPoints().addAll(i * 1.5 * sideSize + 2 * sideSize, hight - (1.5 * Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2,
                        i * 1.5 * sideSize + 1.5 * sideSize, hight - (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2,
                        i * 1.5 * sideSize + 2 * sideSize, hight - (Math.sqrt(3) * sideSize / 2) + Math.sqrt(3) * sideSize / 2,
                        i * 1.5 * sideSize + 3 * sideSize, hight - (Math.sqrt(3) * sideSize / 2) + Math.sqrt(3) * sideSize / 2,
                        i * 1.5 * sideSize + 3.5 * sideSize, hight - (Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2,
                        i * 1.5 * sideSize + 3 * sideSize, hight - (1.5 * Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2);
                rowY =  hight - (1.5 * Math.sqrt(3) * sideSize) + Math.sqrt(3) * sideSize / 2;
            }

            polygon.setFill(Color.BLACK);
            polygon.setStroke(Color.WHITE);
            root.getChildren().add(polygon);

        }
    }
    public double getRowY()
    {
        return rowY;
    }
}
