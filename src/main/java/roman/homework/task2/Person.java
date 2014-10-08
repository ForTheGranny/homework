package roman.homework.task2;

/** Task:   Создайте POJO класс
 *          Создайте POJO класс, поля которого являются final (Person)
 *          Создайте Enum который характеризует экзмпляр POJO класса (Должность:DIRECTOR, DEVELOPER, QA)
 *          Добавьте Enum как поле в POJO
 *          Cгенерируйте equals/hashcode методы
 *          Создайте Main класс, в main методе которого проведите сравнение экземпляров по ссылке и через метод equals
 *
 * Created by Roman Tereschenko on 10/9/2014.
 */
public class Person {

    private final String firstName = "Joseph";
    private final String secondName = "Lagrange";
    private final int age = 77;
    private final Position post = Position.DEVELOPER;



    // Getters for the instance fields
    public String getName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Position getPost() {
        return post;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (post != person.post) return false;
        if (secondName != null ? !secondName.equals(person.secondName) : person.secondName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (post != null ? post.hashCode() : 0);
        return result;
    }
}
