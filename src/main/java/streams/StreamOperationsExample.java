package streams;

import org.apache.log4j.Logger;
import streams.model.Hobbies;
import streams.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamOperationsExample {

    static Logger log = Logger.getLogger(StreamOperationsExample.class);

    public static void main(String[] args) {

        List<Student> students = createDataSet();

//        Filters filter = new Filters(students);
//        filter.filterStudentsWithNameStartsWithA();
//        filter.filterStudentsThatGet5();
//        filter.filterStudentsThatAreFemale();
//        //DONE
//        filter.filterStudentsThatFailTest();
//        filter.filterStudentsWhichNamesAndSurnamesStartWithDifferentLetter();

//        Maps maps = new Maps(students);
//        maps.filterStudentsWithNameStartsWithA();
//        maps.filterStudentsWithNameStartsWithA_vs2();
//        maps.filterStudentsThatGet5();
//        maps.makeAllStudentGet5();
          //DONE
//        maps.printListOfStudentsSurnamesInCapitalLetter();
//
//        OtherOperations otherOperations = new OtherOperations(students);
//        otherOperations.printStudentNames();
//        otherOperations.printFirstThreeStudentsNames();
//        otherOperations.printNamesAlphabetically();
//        otherOperations.printBestThreeStudentsNames();
//
//        //Todo
//        otherOperations.print3StudentsThatPassedWithPositiveGradeWithLowestTestScore();
//
//        FlatMaps flatMaps = new FlatMaps(students);
//        flatMaps.printStudentHobbies();
//        flatMaps.printDistinctStudentHobbies();
//
//        Terminals terminals = new Terminals(students);
//        terminals.isThereStudentWhoFailExam();
//        terminals.hasAllStudentsPassExam();
//        terminals.hasAllStudentsPassExamVs2();
//        terminals.findRandomStudentWhoGet3();
//        terminals.findFirstStudentWhoGet3();
//        terminals.removeStudentsWhoFailExam();
//
//        Collect collect = new Collect(students);
//        collect.collectStudentsWithNameStartsWithA();
//        collect.collectStudentsWithNameStartsWithA_vs2();
//        collect.groupStudentByGrade();
//        collect.groupStudentByGradeVs2();
//        collect.partitionStudentWhoPassAndFail();

//        //ToDo
//        collect.mapHobbiesToStudents();
//
    }

    private static List<Student> createDataSet() {
        List<Student> students = new ArrayList<>();
        students.add(Student.builder()
                .name("Adam")
                .surname("Adamski")
                .testResults(100L)
                .grade(5)
                .hobbiesList(Arrays.asList(Hobbies.COMPUTER_GAMES,Hobbies.COOKING))
                .build());
        students.add(Student.builder()
                .name("Adam")
                .surname("Antkowski")
                .testResults(100L)
                .grade(5)
                .hobbiesList(Arrays.asList(Hobbies.READING))
                .build());
        students.add(Student.builder()
                .name("Bogdan")
                .surname("Bękalski")
                .testResults(10L)
                .grade(2)
                .hobbiesList(Arrays.asList(Hobbies.RUNNING))
                .build());
        students.add(Student.builder()
                .name("Cezary")
                .surname("Czamper")
                .testResults(90L)
                .grade(3)
                .hobbiesList(Arrays.asList(Hobbies.FILMS, Hobbies.DANCING, Hobbies.WALKING))
                .build());
        students.add(Student.builder()
                .name("Daniela")
                .surname("Dąb")
                .testResults(50L)
                .grade(3)
                .hobbiesList(Arrays.asList(Hobbies.RUNNING))
                .build());
        students.add(Student.builder()
                .name("Eryk")
                .surname("Niepoprawny")
                .testResults(60L)
                .grade(3.5)
                .hobbiesList(Arrays.asList(Hobbies.DANCING))
                .build());
        students.add(Student.builder()
                .name("Feliks")
                .surname("Fartowny")
                .testResults(80L)
                .grade(4.5)
                .hobbiesList(Arrays.asList(Hobbies.LANGUAGE))
                .build());
        students.add(Student.builder()
                .name("Grażyna")
                .surname("Gołąb")
                .testResults(70L)
                .grade(5)
                .hobbiesList(Arrays.asList(Hobbies.STUDYING))
                .build());
        return students;
    }


}