public class Lion extends Animal{
    Gender gender;
    public Lion(Position position, int unitMovement, Gender gender) {
        super(position, unitMovement);
        this.gender=gender;
    }
}
