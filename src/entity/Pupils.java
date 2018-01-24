package entity;

import entity.Pupil.PupilComparator1;
import entity.Pupil.PupilComparator2;

import java.util.ArrayList;

public class Pupils {
    private ArrayList<Pupil> pupils;

    public Pupils(ArrayList<Pupil> pupils) { this.pupils = pupils; }

    public boolean acceptID(String ID){
        for (Pupil pupil : pupils){
            if (pupil.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }

    public String greeting(String ID){
        for (Pupil pupil : pupils){
            if (pupil.getID().equals(ID)){
                return "\nWelcome, " + pupil.getName() + ". Enter the number of the publication you want to read." +
                        "\nEnter \"back\" if you want to return to main menu.";
            }
        }
        return "";
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

    private void sort(int mode){
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
}
