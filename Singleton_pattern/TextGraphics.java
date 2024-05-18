package Singleton_pattern;
public class TextGraphics {
    private int width;
    private int height;
    public char[][]buffer;
    public TextGraphics(){
        buffer=new char[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                buffer[i][j]=' ';
            }
        }
    }
    public TextGraphics getInstance(){
        return this;
    }
    public void init(int width,int height){
        buffer=new char[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                buffer[i][j]=' ';
            }
        }
    }
    public void drawPoint(char c,int x,int y){
        buffer[x][y]=c;
    }
    public void drawLine(char c,int x1,int y1,int x2,int y2){
        if(Math.abs(x1-x2)!=Math.abs(y1-y2)){
            buffer[x1][y1]=c;
            buffer[x2][y2]=c;
        }
        else{
            if(x1==x2){
                for(int i=Math.min(y1,y2);i<=Math.max(y1,y2);i++){
                    buffer[x1][i]=c;
                }
            }
            else{
                double a=(y1-y2)/(x1-x2);
                double b=(x1*y2-y1*x2)/(x1-x2);
                for(int i=Math.min(x1,x2);i<=Math.max(x1,x2);i++){
                    for(int j=Math.min(y1,y2);j<=Math.max(y1,y2);j++){
                        if(i*a+b==j){
                            buffer[i][j]=c;
                        }
                    }
                }
            }
        }
    }
    public void fillRect(char c,int x,int y,int width,int height){
        int Rect_x=x+width;
        int Rect_y=y+height;
        for(int i=x;i<=Rect_x;i++){
            for(int j=y;j<=Rect_y;j++){
                buffer[i][j]=c;
            }
        }
    }
    public void render(){
        for(int i=0;i<buffer.length;i++){
            for(int j=0;j<buffer[i].length;j++){
                System.out.print(buffer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
