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
            default:
                total = num1 / num2;
                break;
        }
        return total;
    }
}

