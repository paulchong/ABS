
public class Seat
{
    private boolean status;
    private int row;
    private char col;

    //constructor
    public Seat(int r, char c)
    {
        row = r;
        col = c;
        status = false;
    }

    //set and get methods
    public void setRow(int row)
    {
        this.row = row;
    }
    public void setCol(char col)
    {
        this.col = col;
    }
    public void setStatus()
    {
        status = true;
    }

    public int getRow()
    {
        return row;
    }
    public char getCol()
    {
        return col;
    }
    public boolean getStatus()
    {
        return status;
    }

    public String toString()
    {
        return ""+(row+1)+col;
    }

}