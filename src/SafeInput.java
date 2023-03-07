import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "0";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n " + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getRangedInt(Scanner pipe, String enterYourYearOfBirth, int i, int i1) {
        return i;
    }

    public class Pipe
    {

        //method to read integer from console
        public static int getInt(Scanner pipe, String prompt) {
            int input = -1;
            //prompt to user
            System.out.println(prompt + "int:");
            //if user insert integer
            if (pipe.hasNextInt()) {
                //read input
                input = pipe.nextInt();
            }
            //reset pipe
            pipe.reset();
            //if not int return -1
            return input;
        }//end of getInt();

        //method to read double
        public static double getDouble(Scanner pipe, String prompt) {
            double input = -1.0;
            //prompt to user
            System.out.println(prompt + "double:");

            //if user insert double
            if (pipe.hasNextDouble()) {
                //read input double
                input = pipe.nextDouble();
            }
            //reset pipe of type Scanner
            pipe.reset();
            //if input is not a double return -1.0
            return input;
        }//end of getDouble();

        //method to read int between range
        public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
            int input = -1;
            //prompt to user
            System.out.println(prompt + "int[" + low + "-" + high + "]:");
            //if user insert int
            if (pipe.hasNextInt()) {
                //read input int
                input = pipe.nextInt();

                //check is Int in given range
                if (input > low && input < high) {
                    //reset pipe
                    pipe.reset();

                    //if input in given range return input integer
                    return input;
                }
                //reset pipe
                pipe.reset();
                //if input is not in range return -1
                return -1;
            }
            //reset pipe
            pipe.reset();
            //if input is not an int return -1
            return -1;
        }//getRangedInt();

        //method to read double in given ranged
        public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
            double input = -1;
            //prompt to user
            System.out.println(prompt + "double[" + low + "-" + high + "]:");
            //if user insert a double
            if (pipe.hasNextDouble()) {
                //read input double
                input = pipe.nextDouble();

                //check is input in a range
                if (input > low && input < high) {
                    pipe.reset();
                    return input;
                }
                pipe.reset();
                //if not in range return -
                return -1.0;
            }
            pipe.reset();
            //if not a double return -1
            return -1.0;
        }//getRangedDouble();

        //method to read Yes or No
        public static boolean getYNConfirm(Scanner pipe, String prompt) {
            char input;
            int repeat = 0;
            do {
                //prompt to user
                System.out.println(prompt + "Yes or No[Y/N]:");
                //read first char
                input = pipe.next().charAt(0);
                //if its Y or y
                if (input == 'y' || input == 'Y') {
                    pipe.reset();
                    //return true if yes
                    return true;
                }
                //if it is N or n
                else if (input == 'n' || input == 'N') {
                    pipe.reset();
                    //return false if input n or N
                    return false;
                } else {
                    pipe.reset();
                    repeat = 1;
                }

            } while (repeat != 0);//repeat if input is not as expected

            pipe.reset();
            return false;
        }//getYNConfirm();

        //method to return String which matches to given regEx
        public static String getRegExString(Scanner pipe, String prompt, String regEx) {
            String input;
            //prompt to user
            System.out.println(prompt + "String that Matches " + regEx + ":");
            //if input string matches the pattern regEx
            if (pipe.hasNext()) {
                //then read String input
                input = pipe.next();
                pipe.reset();
                if (Pattern.matches(regEx, input)) {
                    return input;
                }
                return null;
            }
            pipe.reset();
            return null;//if not matches return null;
        }//end of getRegExString()


        public static void main(String[] args) {
            int input_Int;
            String input_String;
            double input_double;

            //Scanner object to read input from console
            Scanner pipe = new Scanner(System.in);
            //prompt to enter input
            String prompt = "Please Insert Input?as a ";

            //test getInt method;
            input_Int = getInt(pipe, prompt);
            if (input_Int != -1) {
                System.out.println("getInt():-" + input_Int);
            } else {
                System.out.println("input is not an integer!");
            }


            //test getDouble() method
            input_double = getDouble(pipe, prompt);
            if (input_double != -1.0) {
                System.out.println("getDouble():-" + input_double);
            } else {
                System.out.println("input is not a double!");
            }

            //test getRangedInt() method
            input_Int = getRangedInt(pipe, prompt, 10, 20);
            if (input_Int != -1) {
                System.out.println("getRangedInt():-" + input_Int);
            } else {
                System.out.println("input does not comply the instructions!");
            }

            //test getRangedDouble() method
            input_double = getRangedDouble(pipe, prompt, 10.0, 20.00);
            if (input_double != -1.0) {
                System.out.println("getRangedDouble():-" + input_double);
            } else {
                System.out.println("input does not comply the instructions!");
            }

            //test getYNConfirm()
            boolean inp = getYNConfirm(pipe, prompt);
            System.out.println("getYNConfirm():-" + inp);

            //test getRegExString() method
            String regEx = "[a-zA-Z0-9]{6}";//string length should be 6
            input_String = getRegExString(pipe, prompt, regEx);
            if (input_String != null) {
                System.out.println("getRegExString():-" + input_String);
            } else {
                System.out.println("input does not matches the regex!");
            }


            class SafeInputs {
                // A utility method to get an integer input within a range
                public static int getRangedInt(Scanner input, String message, int min, int max) {
                    int value;
                    do {
                        System.out.print(message);
                        while (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next();
                        }
                        value = input.nextInt();
                        input.nextLine();  // Consume the newline character
                    } while (value < min || value > max);
                    return value;
                }

                // A utility method to get a double input within a range
                public static double getRangedDouble(Scanner input, String message, double min, double max) {
                    double value;
                    do {
                        System.out.print(message);
                        while (!input.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                        }
                        value = input.nextDouble();
                        input.nextLine();  // Consume the newline character
                    } while (value < min || value > max);
                    return value;
                }

                // A utility method to get a Yes/No confirmation from the user
                public static boolean getYNConfirm(Scanner input, String message) {
                    String confirm;
                    do {
                        System.out.print(message);
                        confirm = input.nextLine();
                    } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
                    return confirm.equalsIgnoreCase("Y");
                }

                // A utility method to create a pretty header with a message centered

                public static void prettyHeader(String msg) {
                    int starCount=60;
                    while(starCount!=0)
                    {System.out.print("*");
                        starCount--;
                    }
                    System.out.println();
                    int starsonLeft=(60-msg.length())/2;
                    int left=1;
                    while(left<=starsonLeft)
                    {
                        System.out.print("*");
                        left++;
                        //applies starts in appropriate spots
                    }
                    System.out.print(msg);
                    int right=0;
                    while(right<=starsonLeft)
                    {
                        System.out.print("*");
                        right++;
                    }
                    System.out.println();
                    starCount=60;
                    while(starCount!=0)
                    {
                        System.out.print("*");
                        starCount--;
                    }
                }
            }


                            }

                        }
                }





 class GetUserName
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        //asks for first and last name
        firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
        lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
        System.out.println("\nYour full name is: " + firstName + " " + lastName);
        //shows you your name
    }
}






 class FavNumbers {

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        int favInt= Integer.parseInt(SafeInput.getNonZeroLenString(pipe, "Enter your favorite integer"));
        System.out.println("Your favorite integer received:"+favInt);
        //shows your favorite integer
        double favDouble= Double.parseDouble(SafeInput.getNonZeroLenString(pipe, "Enter your favorite double"));
        System.out.println("Your favorite integer received:"+favDouble);
//shows your favorite double
    }


}







 class BirthDateTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get birth year
        int birthYear = getRangedInt(input, "Enter birth year (1950-2010): ", 1950, 2010);

        // Get birth month
        int birthMonth = getRangedInt(input, "Enter birth month (1-12): ", 1, 12);

        // Get birthday, based on the month
        int maxDays;
        switch (birthMonth) {
            case 2: // February
                maxDays = 29; // Leap year will be handled below
                if (birthYear % 4 != 0 || (birthYear % 100 == 0 && birthYear % 400 != 0)) {
                    maxDays = 28;
                }
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                maxDays = 30;
                break;
            default: // January, March, May, July, August, October, December
                maxDays = 31;
                break;
        }
        int birthDay = getRangedInt(input, "Enter birth day (" + maxDays + " days max): ", 1, maxDays);

        // Get birth hour
        int birthHour = getRangedInt(input, "Enter birth hour (1-24): ", 1, 24);

        // Get birth minute
        int birthMinute = getRangedInt(input, "Enter birth minute (1-59): ", 1, 59);

        // Output the result
        System.out.println("Birth date: " + birthDay + "/" + birthMonth + "/" + birthYear +
                " at " + String.format("%02d", birthHour) + ":" + String.format("%02d", birthMinute));
    }

    // A utility method to get an integer input within a certain range
    private static int getRangedInt(Scanner input, String message, int min, int max) {
        int value;
        do {
            System.out.print(message);
            while (!input.hasNextInt()) {
                input.next(); // Consume invalid input
                System.out.print("Invalid input. " + message);
            }
            value = input.nextInt();
        } while (value < min || value > max);
        return value;
    }
}


class Reggie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get SSN
        String ssnPattern = "\\d{3}-\\d{2}-\\d{4}";
        String ssn = getRegExString(input, "Enter SSN (###-##-####): ", ssnPattern);
        System.out.println("SSN: " + ssn);

        // Get UC Student M number
        String mNumberPattern = "(M|m)\\d{5}";
        String mNumber = getRegExString(input, "Enter UC Student M number (M#####): ", mNumberPattern);
        System.out.println("M number: " + mNumber);

        // Get menu choice
        String menuPattern = "[OoSsVvQq]";
        String menuChoice = getRegExString(input, "Enter menu choice (O=Open, S=Save, V=View, Q=Quit): ", menuPattern);
        System.out.println("Menu choice: " + menuChoice);
    }

    // A utility method to get a string input that matches a regular expression pattern
    private static String getRegExString(Scanner input, String message, String pattern) {
        String value;
        do {
            System.out.print(message);
            value = input.nextLine();
        } while (!value.matches(pattern));
        return value;
    }
}



class CheckOut {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalCost = 0;

        do {
            double itemPrice = getRangedDouble(input, "Enter the price of your item ($0.50 to $9.99): ", 0.5, 9.99);
            totalCost += itemPrice;
        } while (getYNConfirm(input, "Do you have more items to add (Y/N)? "));

        System.out.printf("Total cost: $%.2f\n", totalCost);
    }

    // A utility method to get a double input within a range
    private static double getRangedDouble(Scanner input, String message, double min, double max) {
        double value;
        do {
            System.out.print(message);
            value = input.nextDouble();
            input.nextLine();  // Consume the newline character
        } while (value < min || value > max);
        return value;
    }

    // A utility method to get a Yes/No confirmation from the user
    private static boolean getYNConfirm(Scanner input, String message) {
        String confirm;
        do {
            System.out.print(message);
            confirm = input.nextLine();
        } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
        return confirm.equalsIgnoreCase("Y");
    }
}
class PrettyHeader {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String prettyMessage = "";
        prettyMessage = SafeInput.prettyHeader(in,"Farouk");
        //prints pretty message
    }


}
 class CtoFTableDisplay {

    public static void main(String[] args) {
        System.out.println("Celsius\tFahrenheit");
        for (double celsius = -100; celsius <= 100; celsius++) {
            double fahrenheit = CtoF(celsius);
            System.out.println(celsius + "\t" + fahrenheit);
        }
    }

    public static double CtoF(double celsius) {
        return (celsius * 1.8) + 32;
    }

}




