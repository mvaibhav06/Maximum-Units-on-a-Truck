import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnTruck {
    public static int maxUnits(int[][] box, int truckSize){
        Comparator<int[]> comparator = new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1],o1[1]);
            }
        };
        Arrays.sort(box, comparator);
        int counter = 0;
        int boxes = 0;

        for (int i=0; i<box.length; i++){

            if ((box[i][0]+boxes) <= truckSize){
                boxes += box[i][0];
                counter += box[i][0]*box[i][1];
            }else {
                counter += (truckSize - boxes) * box[i][1];
                break;
            }

        }


        return counter;
    }
    public static void main(String[] args) {
        int[][] nums = {{5,10},{2,5},{4,7}, {3,9}};
        System.out.println(maxUnits(nums, 10));
    }
}
