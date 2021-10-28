
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class Controller {

    private final Scanner sc = new Scanner(System.in);

    ArrayList<Doctor> list = new ArrayList<>();

    public Controller() {
    }

    public ArrayList<Doctor> getList() {
        return list;
    }

    public void updateDoctor(String code, String name, String Specialization, int availablity) {
        Doctor doctor = getCodeDoctor(code);
        if (!name.equals("")) {
            doctor.setName(name);
        }
        if (!Specialization.equals("")) {
            doctor.setSpecialization(Specialization);
        }
        if (availablity != -1) {
            doctor.setAvailablity(availablity);
        }
    }

    public void addDoctor(String code, String name, String Specialization, int availablity) {
        list.add(new Doctor(code, name, Specialization, availablity));
    }

    public Doctor getCodeDoctor(String code) {
        for (Doctor doctor : list) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public boolean checkExist(String code) {
        for (Doctor doctor : list) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Doctor> searchDoctor(String searchValue) {
        ArrayList<Doctor> listSearch = new ArrayList<>();
        for (Doctor doctor : list) {
            if (doctor.getCode().toLowerCase().contains(searchValue)) {
                listSearch.add(doctor);
            }
        }
        return listSearch;
    }

    public void removeDocter(String code) {
        Doctor doctor = getCodeDoctor(code);
        if (doctor == null) {
            return;
        } else {
            list.remove(doctor);
        }
    }

    public int choice(String mess, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(mess);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.err.println(err);
            }
        }
    }

    public int inputInt(String mess, String err) {
        while (true) {
            try {
                System.out.println(mess);
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.err.println(err);
            }
        }
    }

    public String inputString(String mess, String err) {
        while (true) {
            try {
                System.out.println(mess);
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    System.out.println(err);
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println(err);
            }
        }
    }

    public String inputStringUpdate(String msg, String err, String regex) {
        String result = null;
        while (true) {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.isEmpty()) {
                return result;
            }
            if (!result.matches(regex)) {
                System.err.println(err);
            } else {
                return result;
            }

        }
    }

    public int inputIntUpdate(String mess, String err) {
        int n;
        System.out.print(mess);
        while (true) {
            try {
                String result = sc.nextLine();
                if (result.equals("")) {
                    return -1;
                }
                n = Integer.parseInt(result);
                if (n < 0) {
                    System.out.println(err);
                }
                return n;
            } catch (NumberFormatException e) {
            }
        }
    }
}
