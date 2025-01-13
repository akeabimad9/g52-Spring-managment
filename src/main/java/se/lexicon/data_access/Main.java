package se.lexicon.data_access;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
   annotationConfigApplicationContext context=new annotationConfigApplicationContext(ComponentScanConfig.class);
   StudentDao studentDao=context.getBean(StudentDao.class);

   // Add some students
        studentDao.save(new Student(1, "John Doe"));
        studentDao.save(new Student(1, "Jane Smith"));
        // Find all students
        System.out.println("All Students:  " + studentDao.findAll());

        // Find by ID
        System.out.println("Find by ID 1:  " + studentDao.findById(1));
        // Delete student
        studentDao.delete(1);
        System.out.println("All Students after deletion: "+ studentDao.findAll());
        context.close();


        }
    }
}