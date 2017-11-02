package data;

public class Bowler{
    String name;
    int pins;

    public Bowler(String name, int pins){
        this.name = name;
        this.pins = pins;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPins(){
        return this.pins;
    }

    public void setPins(int pins){
        this.pins = pins;
    }
}