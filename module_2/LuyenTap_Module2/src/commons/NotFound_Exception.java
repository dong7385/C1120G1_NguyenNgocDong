package commons;

public class NotFound_Exception extends Exception {
    public NotFound_Exception(){
    }

    @Override
    public String getMessage() {
        return "Biển kiểm soát không tồn tại";
    }
}
