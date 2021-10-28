
public class Main {

    ChangeBaseManager cb = new ChangeBaseManager();
    public void changeBase(String iBase, String oBase, String value) {
        // Nếu cơ số 10 thì gọi hàm chuyển cơ số 10 về cơ số khác
        if (iBase.equals("10"))
        {
            System.out.println(cb.convertDectoOther(value, oBase));
        } //Ngược lại thì chuyển về cơ số 10 xong chuyển về cơ số cần chuyển
        else {
            String dec = cb.convertOtherToDec(value, iBase);
            System.out.println(cb.convertDectoOther(dec, oBase));
        }
    }

    public boolean chooseYesNo() {
        Validation getInput = new Validation();
        String yesNo;
        yesNo = getInput.inputYesNo("Do you want to continue ?",
                "Enter Y/y for yes,N/n for no !");
        if (yesNo.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Validation v = new Validation();
        Main m = new Main();
        boolean loop = true;
        while (loop) {
            // Cơ số nhập vào :
            String inBase = v.inputBase("Choose the base number input:"
                    + "( Bin, Dec, Hex )",
                    "Please choose Bin, Dec or Hex");
            // Cơ số cần chuyển đổi :
            String outBase = v.inputBase("Choose the base number out:"
                    + "( Bin, Dec, Hex )",
                    "Please choose Bin, Dec or Hex");
            // Giá trị cần chuyển đổi :
            String value = v.inputValue("Enter the input value:",
                    "Invalid value,please input again", inBase).toUpperCase();
            System.out.println("Output Value: ");
            m.changeBase(inBase, outBase, value);
            loop = m.chooseYesNo();
        }
    }

}
