package commons;

public class NotFound_Exception extends Exception {
    public NotFound_Exception(){
    }

    @Override
    public String getMessage() {
        return "ma bnh nhan khong ton tai";
    }
}
