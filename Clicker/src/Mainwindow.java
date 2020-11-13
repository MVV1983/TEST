import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class Mainwindow extends JPanel {
    //создаю игровые поля(параметры)
    private final int PERS_SIZE = 16;//размер в пикселях объектов
    int width = 16;
    int heigth = 16;
    int margin = 5;//расстояни емежду кваратиками
    private final int SIZE = 256;
    int[][] mas = new int[16][16];


    public Mainwindow() {

        System.out.println(mas.length);
        for (int i = 0; i < mas.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = 0;
                System.out.print(mas[i][j]);
            }
        }
        setBackground(Color.DARK_GRAY);
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int column = mouseEvent.getX() / (margin + width);
                int row = mouseEvent.getY() / (margin + heigth);
                System.out.println("\n" + "Координаты по Х: " + mouseEvent.getX() + " Координаты по Y: " + mouseEvent.getY());
                System.out.println("Строка:" + row + " " + "Столбец:" + column);
                mas[row][column] ^= 1;
                for (int[] ma : mas) {
                    System.out.print("\n");
                    for (int j = 0; j < mas.length; j++) {
                        System.out.print(ma[j]);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });


        setFocusable(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < SIZE/PERS_SIZE; row++) {
            for (int col = 0; col < SIZE/PERS_SIZE; col++) {

                int y = row * heigth + (row + 1) * margin;//запиилил ряд квадратов
                int x = col * width + (col + 1) * margin;
                if (mas[row][col] == 1) {
                    g.setColor(Color.green);
                    g.fillRect(x, y, heigth, width);

                } else {
                    g.setColor(Color.red);
                    g.fillRect(x, y, width, heigth);

                }
            }
            repaint();
        }
    }
}