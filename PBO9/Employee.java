package PBO9;

import java.io.Serializable;

/** Model karyawan yang dapat disimpan sebagai objek serialisasi. */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Nama: " + name + ", umur: " + age;
    }
}

