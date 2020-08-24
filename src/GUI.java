import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ComponentListener {
    private int width = 1000;
    private int height = 600;
    private JFrame frame;
    private JPanel containerPanel;
    private BlockListPanel blockListPanel;
    private BlockList blockList;
    private ControlPanel controlPanel;

    public GUI(BlockList blockList)
    {
        this.blockList = blockList;

        frame = new JFrame();

        containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(CustomColor.GUNMETAL);

        blockListPanel = new BlockListPanel(blockList);
        controlPanel = new ControlPanel(blockListPanel);


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(20,20,20,20);


        containerPanel.add(controlPanel, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 12;

        containerPanel.add(blockListPanel, gbc);

        frame.add(containerPanel);

        frame.getContentPane().setPreferredSize(new Dimension(width,height)); //sets size of actual space (excluding decorations)

        frame.getContentPane().addComponentListener(this);

        frame.setTitle("Sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);


        blockList.setPanelHeight(blockListPanel.getHeight());
        blockList.setPanelWidth(blockListPanel.getWidth());
    }

    public BlockListPanel getBlockListPanel()
    {
        return blockListPanel;
    }

    public void componentResized(ComponentEvent ce)
    {
        blockList.setPanelWidth(blockListPanel.getWidth());
        blockList.setPanelHeight(blockListPanel.getHeight());

        controlPanel.updateScaling();
        System.out.println("control panel height "+ controlPanel.getHeight());
    }

    public void componentMoved(ComponentEvent ce)
    {

    }

    public void componentShown(ComponentEvent ce)
    {

    }

    public void componentHidden(ComponentEvent ce)
    {

    }


}
