package jp.ac.ait.k21101;

import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.IStudentsSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsSorter implements IStudentsSorter {

    private List<IStudent> students;

    @Override
    public List<IStudent> getStudents() {
        return students;
    }

    @Override
    public void setStudents(List<IStudent> students) {
        this.students = students;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedAsc() {
        List<IStudent> data = new ArrayList<>(this.students);
        data.sort(Comparator.comparingInt(IStudent::getTotalCreditsEarned));
        return data;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedDsc() {
        List<IStudent> data2 = new ArrayList<>(this.students);
        data2.sort((o1, o2) -> o2.getTotalCreditsEarned()- o1.getTotalCreditsEarned());
        return data2;
    }
}
