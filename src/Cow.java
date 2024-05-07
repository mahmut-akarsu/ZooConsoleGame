public class Cow extends Animal{
    Gender gender;
    public Cow(Position position, int unitMovement, Gender gender) {
        super(position, unitMovement);
        this.gender=gender;
    }
}
