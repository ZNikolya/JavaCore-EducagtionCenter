package exampleEducationCenter;

import exampleEducationCenter.exception.DublicateLessonException;
import exampleEducationCenter.model.Lesson;
import exampleEducationCenter.model.Student;
import exampleEducationCenter.storage.LessonStorage;
import exampleEducationCenter.storage.StudentStorage;

import java.util.Scanner;
public class EduactionCenter implements Commands {

    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean search = true;
        while (search) {
            printCommands();
            String commandStr = scanner.nextLine();
            int command;
            try {
               command = Integer.parseInt(commandStr);
            } catch (NumberFormatException e){
                command = -1;
            }

            switch (command) {
                case EXIT:
                    search = false;
                    System.out.println("Հաջողություն");
                    break;
                case ADD_STUDENT:
                    addstudent();
                    break;
                case ADD_LESSON:
                    addlesson();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case PRINT_STUDENTS_BY_LESSON_NAME:
                    printStudentByLessonName();
                    break;
                default:
                    System.out.println("Սխալ հրաման");
            }

        }
    }

    private static void printStudentByLessonName() {
        System.out.println("Ներմուծեք առարկայի անունը, ուսանողների ցանկը տեսնելու համար");
        String lessonName = scanner.nextLine();
        studentStorage.getByStudentByLessonName(lessonName);
    }
    private static void changeStudentLesson() {
        studentStorage.print();
        System.out.println("Ներմուծեք ուսանողի ID-ին, որի առարկաները ուզումեք փոխել");
        String sdudentID = scanner.nextLine();
        lessonStorage.print();
        System.out.println("Ներմուծեք առարկայի անունը։ ");
        String lessonName = scanner.nextLine();
        String [] lessonNameStr = lessonName.split(",");
        Lesson[] lessons = new Lesson[lessonNameStr.length];
        int size = 0;
        for (int i = 0; i < lessonNameStr.length; i++) {
            lessons[size++] = lessonStorage.getByName(lessonNameStr[i]);
        }

        Student studentChange = studentStorage.getByID(sdudentID);
        studentChange.setLessons(lessons);
    }

    private static void addlesson() {
        try {
            System.out.println("Ներմուծեք առարկայի տվյալենրը։ (name, duration, price, lecturerName) ");
            String lessonData = scanner.nextLine();
            String[] lessonDataStr = lessonData.split(",");
            Lesson lesson = new Lesson();
            lesson.setName(lessonDataStr[0]);
            lesson.setDuration(Integer.parseInt(lessonDataStr[1]));
            lesson.setPrice(Integer.parseInt(lessonDataStr[2]));
            lesson.setLecturerName(lessonDataStr[3]);
            lessonStorage.add(lesson);
            lessonStorage.print();
        }catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Incorrect value!");
            addlesson();
        } catch (DublicateLessonException e){
            System.out.println(e.getMessage());
        }
    }

    private static void addstudent() {
        try {
            lessonStorage.print();
            System.out.println("Ներմուծեք առարկաները։ ");
            String lessonData = scanner.nextLine();
            String[] lessonDataStr = lessonData.split(",");
            Lesson[] lesson = new Lesson[lessonDataStr.length];
            int size = 0;
            for (String lessonName : lessonDataStr) {
                Lesson byName = lessonStorage.getByName(lessonName);
                if (byName != null) {
                    lesson[size++] = byName;
                } else {
                    System.err.println("Error");
                    return;
                }
            }
            System.out.println("Ներմուծել ուսանողի տվյալները։ (name, surname, phone, email, ID)");
            String studentData = scanner.nextLine();
            String[] studenDataStr = studentData.split(",");
            Student student = new Student();
            student.setName(studenDataStr[0]);
            student.setSurname(studenDataStr[1]);
            student.setPhone(studenDataStr[2]);
            student.setEmail(studenDataStr[3]);
            student.setID(studenDataStr[4]);
            student.setLessons(lesson);
            studentStorage.add(student);
        }catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Incorrect value!");
            addstudent();
        }
    }

    private static void printCommands() {
        System.out.println("Ներմուծել " + EXIT + " դուրս գալու համար");
        System.out.println("Ներմուծել " + ADD_STUDENT + " ուսանող ավելացնելու համար");
        System.out.println("Ներմուծել " + ADD_LESSON + " առարկա ավելացնելու համար");
        System.out.println("Ներմուծել " + PRINT_STUDENTS + " բոլոր ուսանողներին տեսնելու համար");
        System.out.println("Ներմուծել " + PRINT_LESSONS + " բոլոր առարկաները տեսնելու համար");
        System.out.println("Ներմուծել " + CHANGE_STUDENT_LESSON + " գրել ուսանողի անունը որոնք ուզումենք փոխել, և առարկան ստորակետով փոխել");
        System.out.println("Ներմուծել " + PRINT_STUDENTS_BY_LESSON_NAME + " առարկայի անունը ուսանողների ցանկը տեսնելու համար");
    }
}
