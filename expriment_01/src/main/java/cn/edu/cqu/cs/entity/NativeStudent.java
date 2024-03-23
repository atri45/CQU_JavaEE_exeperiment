package cn.edu.cqu.cs.entity;

import java.util.Objects;

public class NativeStudent {

    public NativeStudent() {
    }

    public NativeStudent(long id, String name, String age, String tel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tel = tel;
    }

    private long id;
    private String name;
    private String age;
    private String tel;


    //setter/getter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NativeStudent that = (NativeStudent) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects.equals(tel, that.tel);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, tel);
    }

    // toString
    @Override
    public String toString() {
        return "NativeStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
