public class Sheep  extends Animal{
    private Gender gender;
    public Sheep(Position position, int unitMovement, Gender gender) {
        super(position, unitMovement);
        this.gender=gender;
    }
}
