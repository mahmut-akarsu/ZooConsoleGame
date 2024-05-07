public class Wolf extends Animal{
    private  Gender gender;
    public Wolf(Position position, int unitMovement, Gender gender) {
        super(position, unitMovement);
        this.gender=gender;
    }

}
