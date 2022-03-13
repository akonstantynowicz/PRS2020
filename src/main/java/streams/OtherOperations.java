package streams;

import org.apache.log4j.Logger;
import streams.model.Student;

import java.util.Comparator;
import java.util.List;

public class OtherOperations {
    static Logger log = Logger.getLogger(OtherOperations.class);

    List<Student> students;

    public OtherOperations(List<Student> students) {
        this.students = students;
    }


    public void printStudentNames() {
        log.info("Students names");
        students.stream()
                .map(Student::getName)
                .distinct()
                .forEach(s -> log.info(s));
    }

    public void printFirstThreeStudentsNames() {
        log.info("Only 3 students names");
        students.stream()
                .map(Student::getName)
                .distinct()
                .limit(3)
                .forEach(s -> log.info(s));
    }

    public void printNamesAlphabetically() {
        log.info("Names list lexicographic");
        students.stream()
                .map(student -> student.getName())
                .sorted()
                .forEach(s -> log.info(s));
    }

    public void printBestThreeStudentsNames() {
        log.info("Best three results");
        students.stream()
                .sorted(Comparator.comparing(Student::getTestResults).reversed())
                .map(student -> student.getName() + " " + student.getSurname() + " " + student.getTestResults())
                .limit(3)
                .forEach(s -> log.info(s));
    }

    public void print3StudentsThatPassedWithPositiveGradeWithLowestTestScore() {
        log.info("3 Students that barely passed");
        students.stream()
                .filter(student -> student.getGrade() > 2)
                .sorted(Comparator.comparing(Student::getTestResults))
                .map(student -> student.getName() + " " + student.getSurname() + " " + student.getTestResults() + " " + student.getGrade())
                .limit(3)
                .forEach(s -> log.info(s));
    }

}
