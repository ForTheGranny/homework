package generics.example;

/**
 * Created by Roman Tereschenko on 10/23/2014.
 */
public class OrderedPair<K,V> implements Pair<K,V> {
    private K key;
    private V value;


    public OrderedPair(V value, K key) {
        this.value = value;
        this.key = key;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }



    public static void main(String[] args) {
     //   Pair<String, Integer> p1 = new OrderedPair<>("Even",9);
     //   Pair<String, String>  p2 = new OrderedPair<>("hello", "world");
    }
}
