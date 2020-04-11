import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MethodsCode {

    /**
     * TASK 1
     * Write a method named getTotal
     * that accepts number as string argument
     * and return sum of digits in provided number,
     * but there is a catch
     * if digit is even you digit is multiplied by 2
     * if digit is odd you digit is multiplied by -1
     * Note: if sum is zero then return -1
     * <p>
     * ex1: you passed argument "85" and return is 11
     * because: (8 * 2) + (5 * -1) = 11
     * <p>
     * ex2: "0" ->  -1
     * because:
     */
    //write you code here
    public int getTotal(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            try {
                int d = Integer.parseInt(str.substring(i, i + 1));
                if (d % 2 == 0) {
                    sum = sum + d * 2;
                } else {
                    sum = sum - d;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("The String cannot be converted into an integer value!");
            }
        }
        if (sum != 0) return sum;
        else return -1;
    }
    //end
    /*TechnoStudy Solution
//
//    public int getTotal(String number) {
//        int sum = 0;
//
//        for (int i = 0; i < number.length(); i++) {
//            Integer digit = Integer.valueOf(number.substring(i, i + 1));
//            if (digit % 2 == 0) {
//                sum += digit * 2;
//            } else {
//                sum += digit * -1;
//            }
//        }
//
////        for (String num : number.split("")) {
////            Integer digit = Integer.valueOf(num);
////            if (digit % 2 == 0) {
////                sum += digit * 2;
////            } else {
////                sum += digit * -1;
////            }
////        }
//
//        return sum == 0 ? -1 : sum;
//    }
*/

    /**
     * TASK 2
     * Write a method named bankStatementCalculator
     * that accepts bankStatements as List<String> argument
     * and return total of bank statements
     * Note: if total is zero then return -1
     * <p>
     * ex: arguments is like: {$15.00, $10.20, $2,050.75} and return is 2075.95
     * <p>
     * Hint: remove the unnecessary icons and calculate the total
     */
    //write you code here
    public double bankStatementCalculator(List<String> stats) {
        double total = 0;
        for (String stat : stats) {
            try {
                stat = stat.replaceAll(",", "");
                double num = Double.parseDouble(stat.substring(1));
                total = total + num;
            } catch (NumberFormatException nfe) {
                System.out.println("The String cannot be converted into a double value!");
            }
        }
        if (total != 0) return total;
        else return -1;
    }
    //end
    /*
    public double bankStatementCalculator(List<String> bankStatements) {
        double sum = 0;
        for (String str : bankStatements) {
            String removedDollar = str.replace("$", "");
            String removedComma = removedDollar.replace(",", "");
            sum += Double.valueOf(removedComma);
        }
        return sum == 0 ? -1 : sum;
    }
*/

    /**
     * TASK 3
     * Write a method named randomGenerator
     * that accepts bound as int argument
     * and return random number within provided bound which is bigger than 1
     * if bound is less than 1  return -1
     * if bound is equal to 1 return 1
     * <p>
     * ex: 1 -> 1
     * ex2: -1000 -> -1
     * ex3: 10 -> (random number between 1 and 10)
     */
    //write you code here
    public int randomGenerator(int bound) {
        if (bound < 1) return -1;
        else if (bound == 1) return 1;
        else {
            Random random = new Random(bound);
            return random.nextInt();
        }
    }
    //end
    /*
    public int randomGenerator(int bound) {
        if (bound < 1) {
            return -1;
        } else if (bound == 1) {
            return 1;
        } else {
            Random rand = new Random();
            int randomNumber = rand.nextInt(10) + 1;
            return randomNumber;
        }
    }
    */

    /**
     * TASK 4
     * Write a method named getPopulation
     * that accepts countries as List<String>, populations in countries as List<String> and selected country as String arguments
     * and return string population of selected country in
     * countries list
     * if selected country is not in the countries list then return "-1"
     * <populations>
     * NOTE:
     * this method will not work if you don't finish the randomNumber method
     * <populations>
     * ex:
     * countries -> "USA", "Mexico", "Canada", "Brazil"
     * populations -> "350000000", "100000000", "50000000", "120000000"
     * selected country -> "Canada"
     * <populations>
     * return is "50000000"
     * because: canada has population of 50000000
     * <populations>
     * ex2:
     * <populations>
     * countries -> "USA", "Mexico", "Canada", "Brazil"
     * populations -> "350000000", "100000000", "50000000", "120000000"
     * selected country -> "Germany"
     * <populations>
     * return is "-1"
     */
    //write you code here
    public String getPopulation(List<String> countries, List<String> population, String selected) {
        String result = "-1";
        for (String country : countries) {
            if(country.equals(selected)) {
                int index = countries.indexOf(country);
                result = population.get(index);
            }
        }
        return result;
    }
    //end
    /*
    public String getPopulation(List<String> countries, List<String> populations, String selectedCountry) {
        int index = countries.indexOf(selectedCountry);
        if (index == -1) {
            return "-1";
        }
        return populations.get(index);

// 2. way
//        if (!countries.contains(selectedCountry)) {
//            return "-1";
//        }
//        return populations.get(countries.indexOf(selectedCountry));

// 3. way
//        for (int i = 0; i < countries.size(); i++) {
//            if (countries.get(i).equals(selectedCountry)) {
//                return populations.get(i);
//            }
//        }
//
//        return "-1";
    }
    */

    /**
     * TASK 5
     * Bob was writing names of his relatives, but he did some mistakes while writing them
     * you as a best friend want to help him to correct that list
     * <p>
     * Write a method named correctListOfNames
     * that accepts names as List<String>, wrongName as string and correctName as string argument
     * and return corrected names
     * <p>
     * ex:
     * names: {"Alice", "Bob", "Alo"}
     * wrongName: Alo
     * correctName: Ali
     * <p>
     * return {"Alice", "Bob", "Ali"}
     */
    // write your code here
    public List<String> correctListOfNames (List<String> names, String wrongName, String correctName){
        for (String name : names) {
            if(name.equals(wrongName)) {
                int index = names.indexOf(name);
                names.set(index, correctName);
            }
        }
        return names;
    }
    //end
    /*
    public List<String> correctListOfNames(List<String> names, String wn, String cn) {
        int index = names.indexOf(wn);
        names.set(index, cn);
        return names;
// 2. way
//        for (int i = 0; i < names.size(); i++) {
//            if (names.get(i).equals(wn)) {
//                names.set(i, cn);
//            }
//        }
//        return names;
    }
    */
}
