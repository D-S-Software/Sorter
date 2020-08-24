import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class BlockListPanel extends JPanel implements ActionListener, WindowStateListener {

    private BlockList blockList;

    public BlockListPanel(BlockList blockList)
    {
        super();
        this.blockList = blockList;

        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        System.out.println("block panel height: " + getHeight());
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)(g);
        //g.setColor(getBackground());
        //g.fillRect(0, 0, getWidth(), getWidth());

        blockList.draw(g2D);
    }

    public void actionPerformed(ActionEvent e)
    {
        repaint();

    }

    public void windowStateChanged(WindowEvent we)
    {
        repaint();
    }

    public BlockList getBlockList()
    {
        return blockList;
    }

}
