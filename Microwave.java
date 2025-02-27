import java.util.Scanner;

/**

* This will calculate the amount of time to reheat a food.

*

* @author  Tony Tran

* @version 1.0

* @since   2025-02-24

*/

final class Microwave {
    /**
     * @exception IllegalStateException
     * @see IllegalStateException
     */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /** Constant heating time for a sub. */
    private static final int SUBTIME = 60;
    /** Constant heating time for a pizza. */
    private static final int PIZZATIME = 45;
    /** Constant heating time for a soup. */
    private static final int SOUPTIME = 105;

    /** Multiplier for heating 2 items. */
    private static final double MULTIPLIERTWO = 1.5;
    /** Multiplier for heating 3 items. */
    private static final double MULTIPLIERTHREE = 2.0;
    /** Maximum quantity amount.*/
    private static final int MAXIMUMAMOUNT = 3;

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you heating sub, pizza, or soup?: ");
        String food = scanner.nextLine();
        int baseTime = 0;
        switch (food) {
            case "sub":
                baseTime = SUBTIME;
                break;
            case "pizza":
                baseTime = PIZZATIME;
                break;
            case "soup":
                baseTime = SOUPTIME;
                break;
            default:
                System.out.println("The food must be sub, pizza, or soup.");
                scanner.close();
                return;
        }
        // Ask the user for quantity
        System.out.print("How many are you cooking? (max: 3): ");
        try {
            int amount = Integer.parseInt(scanner.nextLine());
            if (amount < 1 || amount > 3) {
                System.out.println("The quantity must be 1 and 3.");
            } else {
                // Adjust heating time on quantity
                double multiplier = (amount == 2) ? MULTIPLIERTWO
                : (amount == 3) ? MULTIPLIERTHREE : 1;
                int totalTime = (int) (baseTime * multiplier);

                // Converting time to minutes and seconds
                int minutes = totalTime / 60;
                int seconds = totalTime % 60;

                // Displaying result
                System.out.println("The total heating time is: "
                + minutes + " minute(s) and " + seconds + " second(s).");
            }
        } catch (NumberFormatException error) {
            System.out.println("Invalid input. Please enter a number.");
        }
        scanner.close();
    }
}
