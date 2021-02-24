package exception;

import models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CompareByName implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1= null;
        Date date2= null;
        try {
            date1 = simpleDateFormat.parse(o1.getDateOfBirth());
            date2 = simpleDateFormat.parse(o2.getDateOfBirth());
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
