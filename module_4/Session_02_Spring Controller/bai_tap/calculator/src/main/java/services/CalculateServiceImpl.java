package services;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public int calculate(int num1, int num2, String operator) {
        int total = 0;
        switch (operator) {
            case "+":
                total = num1 + num2;
                break;
            case "-":
                total = num1 - num2;
                break;
            case "*":
                total = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    total = num1 / num2;
                } else {
                    throw new ArithmeticException("Error divide by 0");
                }
                break;
        }
        return total;
    }
}

