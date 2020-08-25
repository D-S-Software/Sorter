import java.awt.*;

public class Block {

    //TODO Comparable
    private int height;
    private Color color;
    private long colorSum;

    public Block(int minHeight, int maxHeight)
    {
        this((int) ((maxHeight - minHeight)*Math.random() + minHeight)) ;
    }

    public Block(int height, Color color)
    {
        this.height = height;
        this.color = color;
    }

    public Block(int height) //random Color with full brightness
    {
        this.height = height;

        int r = 0 , g = 0, b = 0;

        int n1 = (int)(3 * Math.random());
        int n2 = (int)(2 * Math.random());

        if(n1 < 1)
        {
            r = 255;

            if(n2 < 1)
            {
                g = 0;
                b = (int)(254* Math.random()); // two values of 255 creates problems
                colorSum = (long) r * 256*256*256 - b * 256*256; //no green, Red is "an octave up" one 255's place above blue instead of 2 places below
            }
            else
            {
               g = (int)(254* Math.random());
               b = 0;
               colorSum = r + g *256;
            }
        }
        else if(n1 < 2)
        {
            g = 255;

            if(n2 < 1)
            {
                r = 0;
                b = (int)(254* Math.random());
                colorSum = g*256 + b *256*256;
            }
            else
            {
                r = (int)(254* Math.random());
                b = 0;
                colorSum = g *256 - r;
            }
        }
        else
        {
            b = 255;

            if(n2 < 1)
            {
                r = 0;
                g = (int)(254* Math.random());
                colorSum = b*256*256 - g*256;
            }
            else
            {
                r = (int)(254* Math.random());
                g = 0;
                colorSum = (long) r * 256*256*256 + b * 256*256;
            }
        }


        color = new Color (r,g,b);
    }

    public int getHeight()
    {
        return height;
    }

    public Color getColor()
    {
        return color;
    }

    public long getColorSum()
    {
       return colorSum;
    }

}
