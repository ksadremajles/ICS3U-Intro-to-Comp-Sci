package week3;

import java.util.Scanner;

public class CrossCountryAssignment {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    processRunner(in);  // runner 1
    processRunner(in);  // runner 2
    processRunner(in);  // runner 3

    in.close();
  }

  private static void processRunner(Scanner in) {
    System.out.print("Please enter runner's first Name");
    String fName = in.nextLine();

    System.out.print("Please enter runner's Last Name");
    String lName = in.nextLine();

    // get the time for the first mile (ask the question println() and then read the time using nextLine) (ex. 5:34.221) <- mile 1 and split 1 are the same
    System.out.print("Please enter mile one time: ");
    String mileOne = in.nextLine();
    // get the time from the beginning to the end of the 2nd mile (ask the question println() and then read the time using nextLine)  (ex. 11:21.672)
    System.out.print("Please enter mile time for first two miles: ");
    String mileTwo = in.nextLine();
    // get the time for the whole race (5 km) (ask the question println() and then read the time using nextLine) (ex. 17:46.851)
    System.out.print("Please enter mile time for whole race: ");
    String finishTime = in.nextLine();
    // subtract mile1 from mile2 -> split 2 (use subtractTimes())
    String splitTwo = subtractTimes(mileOne, mileTwo);
    // subtract mile2 from finish -> split 3
    String splitThree = subtractTimes(mileTwo, finishTime);


    /**
     * display the following:
     * name
     * mile1
     * split2
     * split3
     * finisht
     */
    System.out.println("name" + fName + " " + lName);
    System.out.println("mile1" + mileOne);
    System.out.println("split2" + splitTwo);
    System.out.println("split3" + splitThree);
    System.out.println("finsht" + mileOne + splitTwo + splitThree); 

  
    }

  private static String subtractTimes(String startTime, String finishTime){

    // use convertToSeconds to subtract the times
    double seconds = convertToSeconds(finishTime) - convertToSeconds(startTime);
    // user convertToTime to turn seconds into a time
    return convertToTime(seconds);
    

  
  }
// does the exact opposite of convert to seconds
  private static String convertToTime(double seconds) {
    
    // get the number of minutes in seconds 
    int minutes = (int) (seconds / 60);
    // get the number of seconds left over after subtracting those minutes 
    double sec = seconds - minutes * 60;
    // build a string with minutes: seconds
    return minutes + ":" + sec;
  }

  /**
   * Converts a time into a double (seconds) "5:34.221" => 334.221
   * 
   * @param timeString time in the format "mm:ss.sss"
   * @return converts time into seconds
   */
  private static double convertToSeconds(String timeString) {
    int colon = timeString.indexOf(":");
    int minutesAsSeconds = Integer.parseInt(timeString.substring(0,colon)) * 60;
    double seconds = Double.parseDouble(timeString.substring(colon+1));

    return minutesAsSeconds + seconds;
  }
}