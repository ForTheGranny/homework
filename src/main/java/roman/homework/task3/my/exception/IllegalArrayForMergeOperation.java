package roman.homework.task3.my.exception;

/**
 * Created by rteresch on 15.10.2014.
 */
public class IllegalArrayForMergeOperation extends RuntimeException {

    public IllegalArrayForMergeOperation(){
        super();
    }

    public IllegalArrayForMergeOperation(String message){
        super(message);
    }
    public IllegalArrayForMergeOperation(String message, Throwable cause){
        super(message, cause);
    }
}
