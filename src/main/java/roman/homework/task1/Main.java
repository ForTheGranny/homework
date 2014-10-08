package roman.homework.task1;

/** Task: a) распечатайте в консоль все параметры которые передаются как параметры при запуске
 *        b) распечатай количество переданных параметров
 *
 * Created by Roman Tereschenko on 10/8/2014.
 */
public class Main {

    private static void outputArgs(String[] params){
        System.out.print("The specified arguments are: ");
        for(String str : params){
            System.out.print(str + " ");
        }
    }

    public static void main(String[] args){
        outputArgs(args);
        System.out.println("\n" + "Total number of arguments: " + args.length );
    }
}
