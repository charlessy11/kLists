import java.util.*;

public class KLists {
    //compare only two subarrays each time
    public double [] mergeKLists (double [][] outerArray) {
        //set a1 to first row
        double[] a1 = outerArray[0];
        int counter = 0;
        //set counter to length of outerArray
        for (int a = 0; a < outerArray.length; a++) {
            counter += outerArray[a].length;
        }
        //set output to length of outerArray(counter)
        double[] output = new double[counter];
        //loop through each row
        for (int row = 1; row < outerArray.length; row++) {
            //set a2 to second row
            double[] a2 = outerArray[row];
            ArrayList<Double> temp = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < a1.length && j < a2.length) {
                //if element in row 1 <= element in row 2
                if (a1[i] <= a2[j]) {
                    //add element in row 1 to ArrayList 'temp'
                    temp.add(a1[i]);
                    i++;
                } else {
                    //if element in row 1 > element in row 2
                    //add element in row 2 to ArrayList 'temp'
                    temp.add(a2[j]);
                    j++;
                }
            }
            //add remaining elements to temp
            while (i < a1.length) {
                temp.add(a1[i]);
                i++;
            }
            //add remaining elements to temp
            while (j < a2.length) {
                temp.add(a2[j]);
                j++;
            }
            //convert arrayList to array
            Double[] array = temp.toArray(new Double[temp.size()]);
            //merge array into output array
            for (int k = 0; k < array.length; k++) {
                output[k] = array[k];
            }
            //constantly keep track of previous array
            double[] temp2 = new double[array.length];
            for (int k = 0; k < array.length; k++) {
                temp2[k] = array[k];
            }
            //replace a1 with new updated array
            a1 = temp2;
        }
        return output;
    }

    public static void main (String[] args) {
        double[][] outerArray = {{1.1,4.4,5.5},{1.1,3.3,4.4},{2.2,6.6},{7.7,8.8}};
        KLists sort = new KLists();
        System.out.println("Output: ");
        double[] output = sort.mergeKLists(outerArray);
        for (double val : output) {
            System.out.println(val);
        }
    }
}
