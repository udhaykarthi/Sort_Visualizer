import java.awt.*;


public class Bar {
    private int x,y,width,height;
    private Color color = Color.CYAN;
    public Bar(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public int getHeightValue(){
        return height;
    }
    public void setHeightValue(int height){
        this.height = height;
        this.y = 600-height;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
