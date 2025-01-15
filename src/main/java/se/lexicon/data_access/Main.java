package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDao studentDao = context.getBean(StudentDao.class);

        // Add some students
        studentDao.save(new Student(1, "John Doe"));
        studentDao.save(new Student(2, "Jane Smith"));

        // Find all students
        System.out.println("All Students: " + studentDao.findAll());

        // Find by ID
        System.out.println("Find by ID 1: " + studentDao.findById(1));

        // Delete a student
        studentDao.delete(1);
        System.out.println("All Students after deletion: " + studentDao.findAll());

        context.close();
    }
}
