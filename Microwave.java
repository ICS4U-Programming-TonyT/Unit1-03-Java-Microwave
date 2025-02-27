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
    private static final int SUB_TIME = 60;
    /** Constant heating time for a pizza. */
    private static final int PIZZA_TIME = 45;
    /** Constant heating time for a soup. */
    private static final int SOUP_TIME = 105;

    /** Multiplier for heating 2 items. */
    private static final double MULTIPLIER_TWO = 1.5;
    /** Multiplier for heating 3 items. */
    private static final double MULTIPLIER_THREE = 2.0;
    /** Maximum quantity amount.*/
    private static final int MAXIMUM_AMOUNT = 3;
    /** Minimum quantity amount.*/
    private static final int MINIMUM_AMOUNT = 1;
    /** Amount to divide for Minutes and Seconds.*/
    private static final int TIME_DIVIDE = 60;

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you heating sub, pizza, or soup?: ");
        String food = scanner.nextLine();
        int baseTime = 0;
        switch (food) {
            case "sub":
                baseTime = SUB_TIME;
                break;
            case "pizza":
                baseTime = PIZZA_TIME;
                break;
            case "soup":
                baseTime = SOUP_TIME;
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
            if (amount < MINIMUM_AMOUNT || amount >  MAXIMUM_AMOUNT) {
                System.out.println("The quantity must be 1 and 3.");
            } else {
                // Adjust heating time on quantity
                double multiplier = (amount == 2) ? MULTIPLIER_TWO
                : (amount == TIME_DIVIDE) ? MULTIPLIER_THREE : 1;
                int totalTime = (int) (baseTime * multiplier);

                // Converting time to minutes and seconds
                int minutes = totalTime / TIME_DIVIDE;
                int seconds = totalTime % TIME_DIVIDE;

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
