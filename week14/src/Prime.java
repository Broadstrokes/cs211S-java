public class Prime implements Runnable {

    private double number;

    public Prime(double number) {
        this.number = number;
    }

    @Override
    public void run() {
        boolean primeFlag = true;
        double upperLimit = (double) Math.sqrt(number);
        for (double i = 2; i <= upperLimit; i++) {
            if (number % i == 0) {
                primeFlag = false;
            }
        }
        String output = number + " is ";
        output += primeFlag ? "prime." : "not prime.";
        System.out.println(output);
    }
}