import java.text.DecimalFormat;
import java.util.Random;

public class MontyHall {

   private double                     switchingWins    = 0;
   private double                     notSwitchingWins = 0;
   private static final DecimalFormat twoDp            = new DecimalFormat("#.##");

   public static void main(String[] args) {
      new MontyHall(Long.parseLong(args[0]));
   }

   public MontyHall(long noOfRepeats) {
      Random doors = new Random();
      for (int tries = 0; tries < noOfRepeats; tries++) {
         int prize = doors.nextInt(3) + 1;
         int choice = doors.nextInt(3) + 1;
         if (prize == choice) {
            notSwitchingWins++;
         } else {
            switchingWins++;
         }
      }
      printResults(noOfRepeats);

   }

   private void printResults(long noOfRepeats) {
      System.out.println("For " + noOfRepeats + " number of repeats: ");
      System.out.println("Switching won " + round2Dp((switchingWins / noOfRepeats) * 100));
      System.out.println("Not switching won " + round2Dp((notSwitchingWins / noOfRepeats) * 100));
   }

   private double round2Dp(double input) {
      return Double.valueOf(twoDp.format(input));
   }
}
