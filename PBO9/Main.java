package PBO9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/** Program utama Latihan 9: uji serialisasi dengan beberapa karyawan. */
public class Main {
    public static void main(String[] args) {
        Path file = Paths.get("PBO9", "employees.ser");
        List<Employee> employees = Arrays.asList(
                new Employee("Alya", 25),
                new Employee("Bima", 30),
                new Employee("Citra", 28));
        EmployeeSerializer serializer = new EmployeeSerializer();

        try {
            serializer.serialize(employees, file);
            System.out.println("Data berhasil diserialisasi ke: " + file.toAbsolutePath());

            List<Employee> restoredEmployees = serializer.deserialize(file);
            System.out.println("Data hasil deserialisasi:");
            for (Employee employee : restoredEmployees) {
                System.out.println(employee);
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca/menulis file serialisasi: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class Employee tidak ditemukan saat deserialisasi: " + e.getMessage());
        }
    }
}
