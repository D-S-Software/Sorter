import javax.swing.*;
import java.util.Scanner;

public class Main {

    private BlockList blockList;
    private GUI gui;
    private Timer clock;

    public Main()
    {
        blockList = new BlockList(500,5, 15);
        gui = new GUI(blockList);
       // gui.getBlockListPanel().repaint();

        clock = new Timer(10, gui.getBlockListPanel());
        //clock.start();

    }


    public static void main(String[] args)
    {
        Main main  = new Main();

        System.out.println("Type: start");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if("start".equals(input))
        {
            Main m2 = new Main();
            System.out.println(m2);
        }
    }
}
