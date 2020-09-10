import Class.Class;
import Class.Coach;
import Class.TrackCoach;

public class App {
    public static void main(String[] args) throws Exception {
        Coach a = new TrackCoach();

        System.out.println(a.training());
    }
}
