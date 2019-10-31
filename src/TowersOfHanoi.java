public class TowersOfHanoi {
    public static void main(String[] args) {
        playGame(10, "A", "B", "C");
    }

    public static void playGame(int n, String start, String end, String reserve) {
        if (n == 1) moveDisk(start, end);

        if (n > 1) {
            playGame(n -1, start, end, reserve);
            moveDisk(start, reserve);
            playGame(n - 1, end, reserve, start);

        }
    }

    public static void moveDisk(String start, String end) {
        System.out.println("Moving disk from " + start + " to " + end);
    }
}
