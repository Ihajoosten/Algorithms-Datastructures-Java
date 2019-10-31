public class SavingsInterest {

    public static void main(String[] args) {
        System.out.println(saveInterests(10, 0.50, 2));
    }

    public static double saveInterests(double start, double percentage, int years) {
        if (years > 0) {
            start *= (1.0 + percentage);
            return saveInterests(start, percentage, years - 1);
        } else {
            return start;
        }
    }
}
