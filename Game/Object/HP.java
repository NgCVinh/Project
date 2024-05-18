package Game.Object;

public class HP {
    private double Max_HP;
    private double current_HP;

    public double getCurrent_HP() {
        return current_HP;
    }

    public void setCurrent_HP(double current_HP) {
        this.current_HP = current_HP;
    }

    public double getMax_HP() {
        return Max_HP;
    }

    public void setMax_HP(double max_HP) {
        Max_HP = max_HP;
    }
    public HP(double current_HP,double max_HP){
        this.current_HP=current_HP;
        this.Max_HP=max_HP;
    }
}
