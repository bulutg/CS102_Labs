import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Lab07
 * @author Bulut Gozubuyuk
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Initialization
        File output = new File("output.txt");
        PrintWriter printWriter = new PrintWriter(output);
        Scanner in = new Scanner(new File("houseman.txt"));
        in.useDelimiter("[^A-Za-z]+");
        String[] words = new String[0];
        // Test
        String[] a1 = {};
        String[] a2 = {};

        int count = 0;
        int indx = 0;

        System.out.println(Arrays.toString(mergeSorted(a1, a2)));

        String[] a = {"zeynep", "yasemin", "caglabulut", "bulut", "ahmet", "ahmet", "ahmet", "bulut"};
        System.out.println(Arrays.toString(sort(a)));

        while (in.hasNext()){
            count++;
            in.next();
        }
        System.out.println(count);
        String[] newArr = new String[count];

        Scanner scan = new Scanner(new File("houseman.txt"));
        scan.useDelimiter("[^A-Za-z]+");

        while (scan.hasNext()){
            newArr[indx] = scan.next();
            indx++;
        }
        System.out.println(Arrays.toString(newArr));


//        // Copy to array
//        while (in.hasNextLine()) {
//            String currentLine = in.nextLine();
//            String[] temp = currentLine.split(" ");
//
//            String[] result = new String[temp.length + words.length];
//            System.arraycopy(words, 0, result, 0, words.length);
//            System.arraycopy(temp, 0, result, words.length, temp.length);
//            words = result;
//        }
//
////         Filter alphabet letters
//        for (int i = 0; i < words.length; i++) words[i] = purify(words[i]);
        words = newArr;
        words = deleteDuplicate(sort(words)); // purify and delete duplicates
        System.out.println(Arrays.toString(words));

        // Write to file
        for (String s:words) printWriter.println(s);
        printWriter.close();
    }

    /**
     * Sort array using recursion and mergeSorted
     * @param arr array
     * @return sorted array
     */
    public static String[] sort(String[] arr) {
        if (arr.length == 2) {
            if (arr[0].compareTo(arr[1]) < 0) return arr;
            else return new String[]{arr[1], arr[0]};
        }
        else if (arr.length == 1 || arr.length == 0) return arr;
        return mergeSorted(sort(Arrays.copyOfRange(arr, 0, arr.length / 2)), sort(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
    }


    /**
     * Merge two sorted arrays
     * @param arr1 array 1
     * @param arr2 array 2
     * @return sorted arrays
     */
    public static String[] mergeSorted(String[] arr1, String[] arr2) {
        String[] arr = new String[arr1.length + arr2.length];

        // Initialization
        int index = 0;
        int index1 = 0;
        int index2 = 0;

        // Add lowest to array
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1].compareTo(arr2[index2]) > 0) arr[index++] = arr2[index2++];
            else arr[index++] = arr1[index1++];
        }

        // Add remaining
        while (index1 < arr1.length) arr[index++] = arr1[index1++];
        while (index2 < arr2.length) arr[index++] = arr2[index2++];

        return arr;
    }

    /**
     * Filter alphabet letters
     * @param str string
     * @return purified string
     */
    public static String purify(String str) {
        for (int i = 0; i < str.length(); i++) if (str.charAt(i) < 'A' || str.charAt(i) > 'Z' && str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                str = str.substring(0, i) + str.substring(i-- + 1);
            }

        return str;
    }

    /**
     * Delete duplicate words
     * @param arr array
     * @return unique array
     */
    public static String[] deleteDuplicate(String[] arr) {

        // Temp array
        String[] temp = new String[arr.length];

        int j = 0;

        // Make unique elements
        for (int i = 0; i < arr.length - 1; i++) {
            String index = arr[i];
            if (!index.equals(arr[i + 1])) temp[j++] = index;
        }

        temp[j] = arr[arr.length - 1];
        j = 0;

        // Count non-null elements
        for (int i = 0; i < temp.length; i++) if (temp[i] != null) j++;

        // Create new temp array to add them
        String[] temp2 = new String[j];
        for (int i = 0; i < temp2.length; i++) temp2[i] = temp[i];

        return temp2;
    }
}
