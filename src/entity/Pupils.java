package entity;

import entity.Pupil.PupilComparator1;
import entity.Pupil.PupilComparator2;

import java.util.ArrayList;

public class Pupils {
    private ArrayList<Pupil> pupils;

    public Pupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public Pupils(){}

    public ArrayList<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public void getReadingPupils(){
        sort(1);
        boolean status = false;
        System.out.println("---------------------------------\nPupils that read at least 2 books:");
        for (Pupil pupil : pupils){
            if (pupil.getRead() > 1) {
                System.out.println("\t" + pupil.getName() + ": " + pupil.getRead() + " books;");
                status = true;
            }
        }
        if (!status)
            System.out.println("There's no pupils using the school library...");
        System.out.println("---------------------------------");
    }

    public void getNotReadingPupils(){
        sort(2);
        boolean status = false;
        System.out.println("---------------------------------\nPupils that read at most 2 books:");
        for (Pupil pupil : pupils){
            if (pupil.getRead() == 2 || pupil.getRead() == 0){
                System.out.println("\t" + pupil.getName() + ", " +
                        pupil.getBirthDate() + ": " + pupil.getRead() + " books");
                status = true;
            } else if (pupil.getRead() == 1) {
                System.out.println("\t" + pupil.getName() + ", " +
                        pupil.getBirthDate() + ": " + pupil.getRead() + " book");
                status = true;
            }
        }
        if (!status)
            System.out.println("Every pupil has read more than 2 books...");
        System.out.println("---------------------------------");
    }

    public void sort(int mode){
        switch (mode){
            case 1:
                pupils.sort(new PupilComparator1());
                break;
            case 2:
                pupils.sort(new PupilComparator2());
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Pupils{" +
                "pupils=" + pupils +
                '}';
    }
}
