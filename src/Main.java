import javax.swing.*;
import java.util.Scanner;

public class Main {

    private BlockList blockList;
    private GUI gui;
    private Timer clock;

    public Main()
    {
        blockList = new BlockList(500,2, 20);
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
            main.blockList.bubbleSort();
            main.gui.getBlockListPanel().repaint();
            System.out.println("success");
            System.out.println(main.blockList.getOperationCount());
        }
    }
}
