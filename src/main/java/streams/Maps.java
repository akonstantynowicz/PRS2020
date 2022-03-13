package streams;

import org.apache.log4j.Logger;
import streams.model.Student;

import java.util.List;
import java.util.Locale;

public class Maps {
    static Logger log = Logger.getLogger(Maps.class);

    List<Student> students;

    public Maps(List<Student> students) {
        this.students = students;
    }


    public void filterStudentsWithNameStartsWithA() {
        log.info("Students with name starting with A");
        students.stream()
                .map(student -> student.getName())
                .filter(student -> student.startsWith("A"))
                .forEach(s -> log.info(s));
    }

    public void filterStudentsWithNameStartsWithA_vs2() {
        log.info("Students with name starting with A");
        students.stream()
                .map(Student::getName)
                .filter(student -> student.startsWith("A"))
                .forEach(s -> log.info(s));
    }


    public void filterStudentsThatGet5() {
        log.info("Students that get 5");
        students.stream()
                .filter(student -> student.getGrade() == 5)
                .map(student -> student.getName() + " " + student.getSurname() + " " + student.getGrade())
                .forEach(s -> log.info(s));
    }

    public void makeAllStudentGet5() {
        log.info("Students that get 5");
        students.stream()
                .map(student -> Student.builder()
                        .name(student.getName())
                        .surname(student.getSurname())
                        .testResults(student.getTestResults())
                        .grade(5)
                        .build())
                .filter(student -> student.getGrade() == 5)
                .map(student -> student.getName() + " " + student.getSurname() + " " + student.getGrade())
                .forEach(s -> log.info(s));
    }

    public void printListOfStudentsSurnamesInCapitalLetter() {
        students.stream()
                .map(student -> {student.setSurname(student.getSurname().toUpperCase());
                return student;
                })
                .forEach(s -> log.info(s.getSurname()));
    }
}
