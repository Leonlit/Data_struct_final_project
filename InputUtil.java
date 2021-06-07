import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * #extra file for input handling
 * @author Tung Lit Onn a.k.a Leonlit
 * @MatricNumber 056200
 * simple class to check for user input error, reduced a lot of repeated code........
 */

class InputUtil {
    private static Scanner input = new Scanner(System.in);
    
    public static int getInteger (Boolean positiveNum) {
        int result = -1;
        boolean error = true;
        while (error) {
            try {
                double temp = input.nextDouble();
                if (temp == (int)temp) {
                    result = (int)temp;
                    
                }else {
                    throw (new InputMismatchException());
                }
                error = false;
                if (positiveNum == true && result < 0) {
                    System.out.println("Sorry the input must be a positive number, please re-input.");
                    error = true;
                    input = new Scanner(System.in);
                }
            }catch (InputMismatchException err) {
                System.out.println("Sorry, this input only accept integer, 1, 2, 3, etc. \nPlease input again!!!");
                input = new Scanner(System.in);
            }
        }
        return result;
    }
    
    public static double getDouble (Boolean positiveNum) {
        double result = -1;
        boolean error = true;
        while (error) {
            try {
                result = input.nextDouble();
                error = false;
                if (positiveNum == true && result < 0) {
                    System.out.println("Sorry the input must be a positive number, please re-input.");
                    error = true;
                    input = new Scanner(System.in);
                }
            }catch (InputMismatchException err) {
                System.out.println("Sorry, this input only accept a floating/double value, 1.234 etc. \nPlease input again!!!");
                input = new Scanner(System.in);
            }
        }
        return result;
    }
    
    public static String getString (Boolean alphabetsOnly) {
        String result = null;
        boolean error = true;
        while (error) {
            try {
                input.nextLine();
                result = input.nextLine();
                if (alphabetsOnly) {
                    if (!result.matches("[a-zA-Z]+")) {
                        throw new InputMismatchException();
                    }
                }
                error = false;
            }catch (InputMismatchException err) {
                System.out.println("Sorry, this input only accept a Line of text (includes spaces), qew wqeq, etc. \nPlease input again!!!");
                input = new Scanner(System.in);
            }
        }
        return result;
    }
    
    public static char getCharacter (Boolean alphabetsOnly) {
        char result = 0;
        boolean error = true;
        while (error) {
            try {
                String temp = input.next();
                if (temp.length() == 1) {
                    if (alphabetsOnly) {
                        if (!temp.matches("[a-zA-Z]+")) {
                            throw new InputMismatchException();
                        }
                        result = temp.charAt(0);
                    }
                    error = false;
                }else {
                    System.out.println("Sorry but the input can only accept a character, not a word or text");
                }
            }catch (InputMismatchException err) {
                System.out.println("Sorry, this input only accept a character, a, b, c, etc. \nPlease input again!!!");
                input = new Scanner(System.in);
            }
        }
        return result;
    }
    
    public static String getWord (Boolean alphabetsOnly) {
        String result = null;
        boolean error = true;
        while (error) {
            try {
                result= input.next();
                if (alphabetsOnly) {
                    if (!result.matches("[a-zA-Z]+")) {
                        throw new InputMismatchException();
                    }
                }
                error = false;
            }catch (InputMismatchException err) {
                System.out.println("Sorry, this input only accept a character, a, b, c, etc. \nPlease input again!!!");
                input = new Scanner(System.in);
            }
        }
        return result;
    }
}