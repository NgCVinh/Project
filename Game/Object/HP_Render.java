package Game.Object;


import Game.Object.HP;

public class HP_Render {
    public HP hp;
    public HP_Render(HP hp){
        this.hp=hp;
    }

    public boolean update(double decreaseHP){
        hp.setCurrent_HP(hp.getCurrent_HP()-decreaseHP);
        return hp.getCurrent_HP()>0;
    }
    public double getHp(){
        return hp.getCurrent_HP();
    }
    public void resetHp(){
        hp.setCurrent_HP(hp.getMax_HP());
    }

}
