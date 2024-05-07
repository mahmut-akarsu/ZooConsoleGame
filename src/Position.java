import java.util.Random;

public class Position {
    private static final int MAX_X = 500;
    private static final int MIN_X = 0;
    private static final int MAX_Y = 500;
    private static final int MIN_Y = 0;
    private int x,y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static Position RandomPositionGenerator(){
        Random random=new Random();
        int random_startX_pos= random.nextInt(501);
        int random_startY_pos=random.nextInt(501);
        Position position = new Position(random_startX_pos,random_startY_pos);
        return position;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x >= MIN_X && x <= MAX_X) {
            this.x = x;
        } else if (x < MIN_X) {
            this.x = MIN_X;
        } else {
            this.x = MAX_X;
        }
    }

    public void setY(int y) {
        if (y >= MIN_Y && y <= MAX_Y) {
            this.y = y;
        } else if (y < MIN_Y) {
            this.y = MIN_Y;
        } else {
            this.y = MAX_Y;
        }
    }
}
