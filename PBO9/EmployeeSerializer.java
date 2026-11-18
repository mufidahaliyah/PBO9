package PBO9;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** Menyimpan dan membaca kembali daftar objek Employee. */
public class EmployeeSerializer {
    public void serialize(List<Employee> employees, Path file) throws IOException {
        Path parent = file.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(file))) {
            output.writeObject(new ArrayList<>(employees));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Employee> deserialize(Path file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(file))) {
            return (List<Employee>) input.readObject();
        }
    }
}
