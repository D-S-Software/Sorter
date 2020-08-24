import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {

    private BlockList blockList;
    private BlockListPanel blockListPanel;
    private JButton bubbleSort;
    private JLabel operationCount;
    private GridBagConstraints gbc0, gbc1;
    private GridBagLayout layout;
    private int fontSize;
    private int temp;

    public ControlPanel(BlockListPanel blockListPanel)
    {
        super();
        this.blockListPanel = blockListPanel;
        this.blockList = blockListPanel.getBlockList();

        layout = new GridBagLayout();
        this.setLayout(layout);
        gbc0 = new GridBagConstraints();
        gbc1 = new GridBagConstraints();


        //insets are provided by updateScaling which is automatically called when window is resized (includes window construction)
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        gbc0.weightx = 1;
        gbc0.weighty = 1;
        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.anchor = GridBagConstraints.CENTER;

        setBackground(CustomColor.SILVER);

        bubbleSort = new JButton("Click to Bubble Sort");
        bubbleSort.setBackground(CustomColor.SAVOY_BLUE);
        bubbleSort.setFocusPainted(false);

        bubbleSort.addActionListener((ActionEvent e) -> {blockList.bubbleSort(); blockListPanel.repaint();} ); //lambda expression


        add(bubbleSort, gbc0);

        gbc1.gridx = 1;
        gbc1.gridy = 0;
        gbc1.weightx = 1;
        gbc1.weighty = 1;
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.anchor = GridBagConstraints.CENTER;

        operationCount = new JLabel("Operation Count: " + blockList.getOperationCount(), SwingConstants.CENTER);
        operationCount.setBorder(BorderFactory.createLineBorder(Color.BLACK ));
        //operationCount.setPreferredSize(new Dimension(100,50));
        add(operationCount,gbc1);
    }


    public void paintComponent(Graphics g)
    {
        System.out.println("h: " + getHeight());
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        operationCount.setText("Operation Count: " + blockList.getOperationCount());
    }


    public void updateScaling()
    {

        fontSize = (getHeight() + getWidth()) /35;
        bubbleSort.setFont( new Font("Roboto",Font.PLAIN, fontSize));
        operationCount.setFont(new Font("Roboto",Font.PLAIN, fontSize));

        gbc0.insets = new Insets(getHeight()/10, getWidth()/50, getHeight()/10,getWidth()/75 );
        gbc1.insets = new Insets(getHeight()/10, getWidth()/75, getHeight()/10,getWidth()/50 );


        layout.setConstraints(bubbleSort, gbc0);
        layout.setConstraints(operationCount, gbc1);

        this.revalidate();
        this.repaint();
        System.out.println("a");
    }

}
