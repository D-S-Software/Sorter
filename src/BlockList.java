import java.awt.*;
import java.util.ArrayList;

public class BlockList extends ArrayList<Block> {

    int minHeight;
    int maxHeight;
    int frameWidth;
    int frameHeight;
    int blockWidth;
    int blockHeightMultiplier;
    int leftBuffer;

    private int operationCount = 0;

    public BlockList(int nBlocks, int minHeight, int maxHeight)
    {
        super();

        this.minHeight = minHeight;
        this.maxHeight = maxHeight;

        for(int i = 0; i < nBlocks; i++ )
        {
            this.add(new Block (minHeight, maxHeight) );
            System.out.println("Color " + get(i).getColorSum());
        }
    }

    public void draw(Graphics2D g2D)
    {
        for( int i = 0; i < this.size(); i++)
        {
            g2D.setColor(this.get(i).getColor());
            g2D.fillRect(blockWidth* i + leftBuffer, frameHeight -  blockHeightMultiplier * this.get(i).getHeight() , blockWidth, blockHeightMultiplier * this.get(i).getHeight());
            //System.out.println("" + blockHeightMultiplier);
        }


    }

    public void bubbleSort()
    {
        for(int i = size(); i >= 1; i--)
        {
            for(int j = 1; j < i; j++)
            {
                if(compareHeight(j, j-1) < 0)
                {
                    swap(j, j - 1);
                    operationCount++;
                }
                else if (compareColor(j, j-1) < 0)
                {
                    swap(j, j - 1);
                    operationCount++;
                }
            }
        }
    }

    /** @return positive if A > B. Returns 0 if same. Returns Neg if A < B */
    private int compareHeight(int indexA, int indexB)
    {
        return get(indexA).getHeight() - get(indexB).getHeight();
    }

    /** FOLLOWS RGB scale. red is low, violet is high, OYGB are in between.
     * @return positive if A > B. Returns 0 if same. Returns Neg if A < B */
    private long compareColor(int indexA, int indexB)
    {
       return get(indexA).getColorSum() - get(indexB).getColorSum();
    }

    private void swap(int indexA, int indexB)
    {
        Block temp = get(indexA);
        set(indexA, get(indexB));
        set(indexB, temp);
    }

    public void setPanelWidth(int w)
    {
        frameWidth = w;
        blockWidth = (int) Math.ceil( frameWidth/(1.0 * this.size()));
        System.out.println("Block Width" + blockWidth);
        leftBuffer = (frameWidth - size()*blockWidth)/2;
    }

    public void setPanelHeight(int h)
    {
        frameHeight = h;
        blockHeightMultiplier = (int)Math.ceil(4 * frameHeight / (5.0 * maxHeight));
    }

    public int getOperationCount()
    {
        return operationCount;
    }


}
