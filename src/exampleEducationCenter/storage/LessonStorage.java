package exampleEducationCenter.storage;

import exampleEducationCenter.exception.DublicateLessonException;
import exampleEducationCenter.model.Lesson;

public class LessonStorage {

    private Lesson[] lessons;
    private int size;

    public LessonStorage(int les) {
        lessons = new Lesson[les];
    }

    public LessonStorage() {
        lessons = new Lesson[16];
    }

    public void add(Lesson lesson) throws DublicateLessonException {
        if (getByName(lesson.getName()) != null ){
            throw new DublicateLessonException(" Նման անունով դասը " + lesson.getName() + "արդեն կա");
        }
        if (size == lessons.length) {
            extend();
        }
        lessons[size++] = lesson;
    }

    private void extend() {
        Lesson[] das = new Lesson[lessons.length + 10];
        System.arraycopy(lessons, 0, das, 0, lessons.length);
        lessons = das;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i]);
        }
    }

    public Lesson getByName(String name) {
        for (int i = 0; i < size; i++) {
            if (name.equals(lessons[i].getName())) {
                return lessons[i];
            }
        }
        return null;
    }
}

