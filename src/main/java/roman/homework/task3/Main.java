package roman.homework.task3;

 /**
 * Created by Roman Tereschenko on 10/13/2014.
 Array join (inner, outer, merge consider duplicates )
 Для inner union (обеднение общих элементов)
 [1,5,4,23,65,32,78]
 [3,5,24,4,1,2,34,45,32,5]
 res:
 [5,4,32,1]


 Для outer union (Вывод разных отличающихся элементов):
 [1,5,4,23,65,32,78]
 [3,5,24,4,1,2,34,45,32,5]
 res:
 [23,65,78,3,24,2,34,45]

 */
public class Main {

    public static void main(String[] args) {

        int[] firstArray = new int[] {1,5,4,23,65,32,78};
        int[] secondArray = new int[] {3,5,24,4,1,2,34,45,32,5};


        int[] res_inner = JoinUtil.innerJoin(firstArray, secondArray);
        int[] res_outer = JoinUtil.outerJoin(firstArray, secondArray);
        int[] res_merge = JoinUtil.merge(firstArray, secondArray);

        System.out.print("Equal elements are: ");
        for(int matchedNumbers : res_inner){
            System.out.print(" " + matchedNumbers);
        }

        System.out.print("\n"+ "Only different elements from both arrays: ");
        for(int matchedNumbers : res_outer){
            System.out.print(" " + matchedNumbers);
        }

        System.out.print("\n"+ "Merge result: ");
        for(int matchedNumbers : res_merge){
            System.out.print(" " + matchedNumbers);
        }

    }
}
