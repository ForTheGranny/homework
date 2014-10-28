package com.homework.task2;

import java.util.Comparator;

/** Task:   Создайте POJO класс
 *          Создайте POJO класс, поля которого являются final (Person)
 *          Создайте Enum который характеризует экзмпляр POJO класса (Должность:DIRECTOR, DEVELOPER, QA)
 *          Добавьте Enum как поле в POJO
 *          Cгенерируйте equals/hashcode методы
 *          Создайте Main класс, в main методе которого проведите сравнение экземпляров по ссылке и через метод equals
 *
 * Created by Roman Tereschenko on 10/9/2014.
 */
public class Person implements Comparator {

    private final String firstName;
    private final String secondName;
    private final int age;
    private final Position post;

    private Person(Builder builder) {
            this.firstName = builder.firstName;
            this.secondName = builder.secondName;
            this.age = builder.age;
            this.post = builder.post;
    }


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
    public int compare(Object o1, Object o2) {
        if(o1.equals(o2))
            return 0;
        else
            return 1;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", post=").append(post);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder{
        private  String firstName;
        private  String secondName;
        private  int age;
        private  Position post;

        public Builder(){
        }

        public Builder(Person original) {
            this.firstName = original.firstName;
            this.secondName = original.secondName;
            this.age = original.age;
            this.post = original.post;
        }
        public Person build(){
             return new Person(this);
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName){
            this.secondName = secondName;
            return this;
        }

        public Builder personAge(int person_age){
            this.age = person_age;
            return this;
        }

        public Builder personPost(Position person_post){
            this.post = person_post;
            return this;
        }
    }
}
