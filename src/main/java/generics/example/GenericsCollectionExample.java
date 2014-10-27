package generics.example;

/**
 * Created by Roman Tereschenko on 10/23/2014.
 */
/* Commonly used type parameter names are:

E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
S,U,V etc. - 2nd, 3rd, 4th types
*/

public class GenericsCollectionExample<T> {

    //T stands for "type"
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


}
