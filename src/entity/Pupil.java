package entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class Pupil {
    private String ID;
    private String name;
    private Date birthDate;
    private DateFormat format;
    private int read;

    public Pupil() {}

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID.substring(2); }

    String getName() { return name; }

    public void setName(String name) { this.name = name; }

    String getBirthDate() { return format.format(birthDate); }

    Date getDate(){ return birthDate; }

    public void setBirthDate(String birthDate) {
        try {
            format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            this.birthDate = format.parse(birthDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    int getRead() { return read; }

    public void setRead(String read) { this.read = Integer.parseInt(read); }

    public static class PupilComparator1 implements Comparator<Pupil> {
        @Override
        public int compare(Pupil one, Pupil two) {
            return Integer.compare(one.read, two.read);
        }
    }

    public static class PupilComparator2 implements Comparator<Pupil>{
        @Override
        public int compare(Pupil one, Pupil two) {
            if (one.getDate().compareTo(two.getDate()) == 0){
                return Integer.compare(two.read, one.read);
            }else if (one.getDate().compareTo(two.getDate()) < 0) {
                return -1;
            }else {
                return 1;
            }
        }
    }
}
