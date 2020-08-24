import java.awt.*;

public class Block {

    //TODO Comparable
    private int height;
    private Color color = Color.GRAY;

    public Block(int height)
    {
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }

    public Color getColor()
    {
        return color;
    }

}
