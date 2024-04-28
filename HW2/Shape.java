package New;
import java.util.Map;
import java.util.TreeMap;
public class Shape {
    private TreeMap<Double,Double> map;
    private double center_x;
    private double center_y;
    private Point center;
    private double radius;
    public Shape(String text){
            map=new TreeMap<>();
            double sum_x=0;
            double sum_y=0;
            String[]board=text.split("\\s+");
            for(int i=0;i<board.length;i=i+2){
                double x=Double.parseDouble(board[i]);
                double y=Double.parseDouble(board[i+1]);
                map.put(x,y);
                sum_x+=x;
                sum_y+=y;
            }
            center_x=sum_x/(map.size());
            center_y=sum_y/(map.size());
            center=new Point(center_x,center_y);
            radius=1e9;
            for(Map.Entry<Double,Double> entry: map.entrySet()){
                Point Nearest=new Point(entry.getKey(),entry.getValue());
                if(center.distanceTo(Nearest)<radius) radius=center.distanceTo(Nearest);
            }
    }
    public boolean crosses(Shape other){
        TreeMap<Double,Double> Map_A=new TreeMap<>(map);
        Point Center_other=other.center;
        boolean insite=false;
        boolean outsite=false;
        for(Map.Entry<Double,Double> entry: Map_A.entrySet()){
            Point currentPoint=new Point(entry.getKey(),entry.getValue());
            if(Center_other.distanceTo(currentPoint)<= other.radius) insite=true;
            else outsite=true;
            if(outsite==true&&insite==true)
                return true;
        }
        return false;
    }
    public int encircles(Shape other){
        Point Center_A=this.center;
        Point Center_other=other.center;
        if(Center_other.distanceTo(Center_A)<this.radius) return 2;
        else if(Center_other.distanceTo(Center_A)<= this.radius+ other.radius) return 1;
        else return 0;
    }
}


