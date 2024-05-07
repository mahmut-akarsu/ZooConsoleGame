import java.util.Random;

public class Animal {
    private Position position;
    private int unitMovement;
    //Gender gender;


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getUnitMovement() {
        return unitMovement;
    }

    public void setUnitMovement(int unitMovement) {
        this.unitMovement = unitMovement;
    }



    public Animal(Position position,int unitMovement) {
        this.position=position;
        this.unitMovement=unitMovement;
    }


    protected void moveRandom(){
        Random random=new Random();
        int direction=random.nextInt(4);

        //0 down
        // 1 up
        // 2 right
        // 3 left represented

        switch (direction){
            case(0):
                position.setY(position.getY()-getUnitMovement());
                break;
            case(1):
                position.setY(position.getY()+getUnitMovement());
                break;
            case(2):
                position.setX(position.getX()+getUnitMovement());
                break;
            case(3):
                position.setX(position.getX()-getUnitMovement());
                break;

        }

    }


}
