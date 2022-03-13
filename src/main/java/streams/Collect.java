package streams;

import org.apache.log4j.Logger;
import streams.model.Hobbies;
import streams.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collect {
    static Logger log = Logger.getLogger(Collect.class);

    List<Student> students;

    public Collect(List<Student> students) {
        this.students = students;
    }

    public void collectStudentsWithNameStartsWithA() {
        log.info("Students with name starting with A");
        List<Student> studentsWithAname = students.stream()
                .filter(student -> student.getName().startsWith("A"))
                .collect(Collectors.toList());
        studentsWithAname.forEach(student -> log.info(student.getName()));

    }

    public void collectStudentsWithNameStartsWithA_vs2() {
        log.info("Students with name starting with A");
        Set<Student> studentsWithAname = students.stream()
                .filter(student -> student.getName().startsWith("A"))
                .collect(Collectors.toSet());
        studentsWithAname.forEach(student -> log.info(student.getName()));
    }

    public void groupStudentByGrade() {
        log.info("Group student by grade");
        Map<Double, List<Student>> studentsByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        studentsByGrade.forEach((g, s_list) -> {log.info(g); s_list.forEach(s -> log.info(s.getName() + " " + s.getSurname()));});
    }

    public void groupStudentByGradeVs2() {
        log.info("Group student by grade");
        Map<Double, List<Student>> studentsByGrade = students.stream().
                collect(Collectors.toMap(student -> student.getGrade(),
                        x -> {
                            List<Student> list = new ArrayList<>();
                            list.add(x);
                            return list;
                        },
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        }));
        studentsByGrade.forEach((g, s_list) -> {log.info(g); s_list.forEach(s -> log.info(s.getName() + " " + s.getSurname()));});
    }

    public void partitionStudentWhoPassAndFail() {
        log.info("Group student by grade");
        Map<Boolean, List<Student>> groups =
                students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() > 2));

        groups.forEach((g, s_list) -> {log.info(g?"passed":"failed"); s_list.forEach(s -> log.info(s.getName() + " " + s.getSurname()));});
    }

    public void mapHobbiesToStudents() {
        log.info("Map hobbies to students");
        Map<Hobbies, List<Student>> map = students.stream()
                .flatMap(s -> s.getHobbiesList().stream().map(h -> Map.entry(h, s)))
                .collect(Collectors.toMap(entry -> entry.getKey(),
                        x -> {
                            List<Student> list = new ArrayList<>();
                            list.add(x.getValue());
                            return list;
                        },
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        }));
        map.forEach((g, s_list) -> {log.info(g); s_list.forEach(s -> log.info(s.getName() + " " + s.getSurname()));});

    }



}
