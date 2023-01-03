package sample;
import com.sun.prism.Image;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
public class Main extends Application {
    public double sideSize = 15;//the size of polygon's sides
    public double hight = Math.sqrt(3) * 21 * sideSize, width = 23 * sideSize;//hieght & width of panel
    ArrayList fullX = new ArrayList();
    ArrayList fullY = new ArrayList();
    ArrayList colors = new ArrayList();
    ArrayList<Polygon> polygonsToBeRemoved= new ArrayList<>();
    ArrayList<Polygon> allShapes = new ArrayList<>();
    int score = 0;
    int timeDuration = 500;
    int continu = 0;
    public static Timeline tl;
    @Override
    public void start(Stage stage) throws Exception{
        Pane root = new Pane();
        root.setId("pane");
        Text scoreText = new Text();
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        Scene scene = new Scene(root ,width, hight);
        scene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        GamePanel gamePanel = new GamePanel(hight, width, sideSize);
        double x =((int) (3 + Math.random() * 7)) * 1.5 * sideSize + 2 * sideSize,y = 0;
        Shape shape = new Shape(x, y, sideSize);
        shape.setShapesNumber((int) (Math.random() * 7 + 1));
        //Background background = new Background();
        Button startButton = new Button("Start game");
        Font font = Font.font("Courier New", FontWeight.EXTRA_BOLD, 15);
        startButton.setStyle("-fx-text-fill: white; -fx-background-color: DarkBlue");
        startButton.setFont(font);
        startButton.setPrefSize(150, 30);
        startButton.setTranslateX((width - 150) / 2);
        startButton.setTranslateY(hight / 2 - 150);
        root.getChildren().add(startButton);
        Button easy = new Button("Easy");
        easy.setStyle("-fx-text-fill: white; -fx-background-color: DarkBlue");
        easy.setFont(font);
        easy.setPrefSize(150, 30);
        easy.setTranslateX((width - 150) / 2);
        easy.setTranslateY(hight / 2 - 150);
        Button normal = new Button("Normal");
        normal.setStyle("-fx-text-fill: white; -fx-background-color: DarkBlue");
        normal.setFont(font);
        normal.setPrefSize(150, 30);
        normal.setTranslateX((width - 150) / 2);
        normal.setTranslateY(hight / 2 - 150 + 30);

        Button hard = new Button("Hard");
        hard.setStyle("-fx-text-fill: white; -fx-background-color: DarkBlue");
        hard.setFont(font);
        hard.setPrefSize(150, 30);
        hard.setTranslateX((width - 150) / 2);
        hard.setTranslateY(hight / 2 - 150 + 60);

        Button levelChanging = new Button("Level setting");
        levelChanging.setStyle("-fx-text-fill: White; -fx-background-color: DarkBlue");
        levelChanging.setFont(font);
        levelChanging.setPrefSize(150, 30);
        levelChanging.setTranslateX((width - 150) / 2);
        levelChanging.setTranslateY(hight / 2 - 150 + 30);
        Button exit = new Button("Exit");
        exit.setStyle("-fx-text-fill: Black; -fx-background-color: White");
        exit.setFont(font);
        exit.setPrefSize(70, 30);
        exit.setTranslateX((width - 70) / 2);
        exit.setTranslateY(415);
        root.getChildren().add(levelChanging);
        root.getChildren().add(easy);
        root.getChildren().add(normal);
        root.getChildren().add(hard);
        easy.setVisible(false);
        normal.setVisible(false);
        hard.setVisible(false);
        startButton.setOnAction(value ->  {
            root.setId("");
            root.setStyle("-fx-background-image:url(\"file:3.jpg\"); -fx-background-size:345 545");
            gamePanel.makeGamePanel(root);
            shape.make(shape.getShapesNumber(), root);
            shape.shapes.clear();
            shape.setY((-1) * shape.getHeight(shape.getShapesNumber()));
            shape.make(shape.getShapesNumber(), root);
            for(int i = 0; i < 4; i++)
                root.getChildren().add(shape.shapes.get(i));
            tl = new Timeline(new KeyFrame(new Duration(timeDuration),
                    new EventHandler<ActionEvent>()
                    {
                        double y = (-1) * shape.getHeight(shape.getShapesNumber());;
                        int ans = 0;
                        int number = 0;

                        @Override
                        public void handle(ActionEvent event)
                        {
                            int a = 0;
                            boolean notStop = true;
                            shape.moveDown(root);
                            if(continu == 1)
                                for (int i = 0; i < 4; i++)
                                    root.getChildren().remove(shape.shapes.get(i));
                            for(int i = 0; i < fullY.size(); i++)
                            {
                                for(int j = 0; j < 4; j++)
                                {
                                    if((Math.abs((int)(shape.Y[j] + Math.sqrt(3) * sideSize) - (int) fullY.get(i)) <= 2) && (Math.abs(((int) shape.X[j] - (int)fullX.get(i))) <= 2))
                                    {
                                        for (int k = 0; k < 4; k++)
                                            fullY.add((int) (shape.shapes.get(k).getBoundsInParent().getCenterY() - Math.sqrt(3) * sideSize / 2));
                                        for (int k = 0; k < 4; k++)
                                            fullX.add((int) (shape.shapes.get(k).getBoundsInParent().getCenterX() - sideSize / 2));
                                        for (int k = 0; k < 4; k++)
                                            allShapes.add(shape.shapes.get(k));
                                        for (int k = 0; k < 4; k++)
                                            colors.add(shape.getShapesNumber());
                                        for(int k = 0; k < 4; k++)
                                        {
                                            if(shape.Y[k] <= 0)
                                            {
                                                root.getChildren().clear();
                                                root.setStyle("-fx-background-image:url(\"file:4.jpg\"); -fx-background-size:345 545");
                                                scoreText.setFont(font);
                                                scoreText.setX(90);
                                                scoreText.setY(380);
                                                scoreText.setText("Your score is : " + score);
                                                scoreText.setEffect(r);
                                                scoreText.setFill(Color.WHITE);
                                                root.getChildren().add(scoreText);
                                                stage.setTitle("Tetris");
                                                root.getChildren().add(exit);
                                                tl.stop();
                                                continu = 1;
                                                break;
                                            }
                                        }
                                        for (int k = 0; k < 20; k++)
                                        {
                                            number = 0;
                                            for(int z = 0; z < allShapes.size(); z++)
                                                if(Math.abs((int)(allShapes.get(z).getBoundsInParent().getCenterY() - (int)(hight - (1.5 * Math.sqrt(3) * sideSize + k * Math.sqrt(3) * sideSize)))) <= 5
                                                        || Math.abs((int)(allShapes.get(z).getBoundsInParent().getCenterY() - (int)(hight - (2 * Math.sqrt(3) * sideSize + k * Math.sqrt(3) * sideSize)))) <= 5)
                                                    number++;
                                            if(number == 13)
                                            {
                                                score += 10;
                                                for(int z = allShapes.size() - 1; z >= 0 ; z--)
                                                    if(Math.abs((int)(allShapes.get(z).getBoundsInParent().getCenterY() - (int)(hight - (1.5 * Math.sqrt(3) * sideSize + k * Math.sqrt(3) * sideSize)))) <= 5
                                                            || Math.abs((int)(allShapes.get(z).getBoundsInParent().getCenterY() - (int)(hight - (2 * Math.sqrt(3) * sideSize + k * Math.sqrt(3) * sideSize)))) <= 5)
                                                    {
                                                        root.getChildren().remove(allShapes.get(z));
                                                        allShapes.remove(z);
                                                        colors.remove(z);
                                                    }
                                                for(int z = 0; z < allShapes.size(); z++)
                                                {
                                                    if((int) allShapes.get(z).getBoundsInParent().getCenterY() < (int)(hight - (2 * Math.sqrt(3) * sideSize + k * Math.sqrt(3) * sideSize)) - 5)
                                                    {
                                                        root.getChildren().remove(allShapes.get(z));
                                                        Polygon polygon = new Polygon();
                                                        polygon.getPoints().addAll(allShapes.get(z).getBoundsInParent().getCenterX() - sideSize / 2, allShapes.get(z).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2,
                                                                allShapes.get(z).getBoundsInParent().getCenterX() - sideSize, allShapes.get(z).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                                                                allShapes.get(z).getBoundsInParent().getCenterX() - sideSize / 2, allShapes.get(z).getBoundsInParent().getCenterY() + 1.5 * Math.sqrt(3) * sideSize,
                                                                allShapes.get(z).getBoundsInParent().getCenterX() + sideSize / 2, allShapes.get(z).getBoundsInParent().getCenterY() + 1.5 * Math.sqrt(3) * sideSize,
                                                                allShapes.get(z).getBoundsInParent().getCenterX() + sideSize, allShapes.get(z).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize,
                                                                allShapes.get(z).getBoundsInParent().getCenterX() + sideSize / 2, allShapes.get(z).getBoundsInParent().getCenterY() + Math.sqrt(3) * sideSize / 2);
                                                        if((int) colors.get(z) == 1)polygon.setFill(Color.rgb(199,142,255));
                                                        if((int) colors.get(z) == 2)polygon.setFill(Color.PINK);
                                                        if((int) colors.get(z) == 3)polygon.setFill(Color.rgb(255, 255, 96));
                                                        if((int) colors.get(z) == 4)polygon.setFill(Color.rgb(108,182,255));
                                                        if((int) colors.get(z) == 5)polygon.setFill(Color.rgb(121,255,121));
                                                        if((int) colors.get(z) == 6)polygon.setFill(Color.rgb(255,130,130));
                                                        if((int) colors.get(z) == 7)polygon.setFill(Color.rgb(255,182,108));
                                                        polygon.setStroke(Color.WHITE);
                                                        allShapes.set(z, polygon);
                                                        root.getChildren().add(allShapes.get(z));
                                                    }
                                                }
                                                fullY.clear();
                                                fullX.clear();
                                                for(int z = 0;  z < allShapes.size() + 13; z++)
                                                {
                                                    if(z <= 12)
                                                    {
                                                        if(z % 2 == 0)
                                                            fullY.add((int)(hight - Math.sqrt(3) * 1.5 * sideSize));
                                                        else
                                                            fullY.add((int)(hight - Math.sqrt(3) * sideSize));
                                                        fullX.add((int)(z * 1.5 * sideSize + 2 * sideSize));

                                                    }
                                                    else
                                                    {
                                                        fullX.add((int) (allShapes.get(z - 13).getBoundsInParent().getCenterX() - sideSize / 2));
                                                        fullY.add((int) (allShapes.get(z - 13).getBoundsInParent().getCenterY() - Math.sqrt(3) * sideSize / 2));

                                                    }
                                                }
                                            }
                                        }
                                        y = (-1) * shape.getHeight(shape.getShapesNumber());
                                        shape.shapes.clear();
                                        shape.setShapesNumber((int) (Math.random() * 7 + 1));
                                        shape.setX(((int) (3 + Math.random() * 7)) * 1.5 * sideSize + 2 * sideSize);
                                        shape.setY(y);
                                        shape.make(shape.getShapesNumber(), root);
                                        for(int k = 0; k < 4; k++)
                                            root.getChildren().add(shape.shapes.get(k));
                                        if(continu == 1)
                                            for (int z = 0; z < 4; z++)
                                                root.getChildren().remove(shape.shapes.get(z));
                                        stage.setTitle("Tetris         your score is : " + score);
                                        ans = 1;
                                        break;
                                    }
                                    if(ans == 1)
                                    {
                                        ans = 0;
                                        break;
                                    }
                                }
                            }
                        }
                    }));
            tl.setCycleCount(Timeline.INDEFINITE);
            tl.play();
            startButton.setVisible(false);
            levelChanging.setVisible(false);
        });
        levelChanging.setOnAction(value ->  {
            startButton.setVisible(false);
            levelChanging.setVisible(false);
            easy.setVisible(true);
            normal.setVisible(true);
            hard.setVisible(true);
        });
        easy.setOnAction(value ->  {
            timeDuration = 500;
            startButton.setVisible(true);
            levelChanging.setVisible(true);
            easy.setVisible(false);
            normal.setVisible(false);
            hard.setVisible(false);
        });
        normal.setOnAction(value ->  {
            timeDuration = 300;
            startButton.setVisible(true);
            levelChanging.setVisible(true);
            easy.setVisible(false);
            normal.setVisible(false);
            hard.setVisible(false);

        });
        hard.setOnAction(value ->  {
            timeDuration = 200;
            startButton.setVisible(true);
            levelChanging.setVisible(true);
            easy.setVisible(false);
            normal.setVisible(false);
            hard.setVisible(false);
        });
        exit.setOnAction(value ->  {
            stage.close();
        });
        for(int i = 0; i <= 12; i++)
        {
            if(i % 2 == 0)
                fullY.add((int)(hight - Math.sqrt(3) * 1.5 * sideSize));
            else
                fullY.add((int)(hight - Math.sqrt(3) * sideSize));
        }
        for(int i = 0; i <= 12; i++)
                fullX.add((int)(i * 1.5 * sideSize + 2 * sideSize));
        scene.setOnKeyPressed(e ->{
            int ans = 0;
            if(e.getCode() == KeyCode.D)
            {
                int k = 0;
                for(int j = 0; j < 4; j++)
                {
                    if((int) (shape.X[j]) <= (int) (width - 3.5 * sideSize))
                        k++;
                }
                if(k == 4)
                    shape.moveRight(root);
            }
            if(e.getCode() == KeyCode.A)
            {
                int k = 0;
                for(int j = 0; j < 4; j++)
                {
                    if((int) (shape.X[j]) >= (int) (3.5 * sideSize))
                        k++;
                }
                if (k == 4)
                    shape.moveLeft(root);
            }
            if(e.getCode() == KeyCode.S)
            {
                shape.moveDown(root);
            }
            if(e.getCode() == KeyCode.W)
            {
                shape.rotate(root);
            }
            if (e.getCode() == KeyCode.P)
                    tl.stop();

        });
        stage.setTitle("Tetris");
        stage.setScene(scene);
        scene.setFill(Color.WHITE);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
