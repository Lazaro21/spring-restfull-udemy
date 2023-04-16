package br.com.erudio.services;


import br.com.erudio.exceptions.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) throws Exception {

//        System.out.println(numberOne);

        Double n1 = convertToDouble(numberOne);
        Double n2 = convertToDouble(numberTwo);

//        System.out.println(n1);

        return n1 + n2;

    }
    public Double subtraction(String numberOne, String numberTwo) throws Exception {


        Double n1 = convertToDouble(numberOne);
        Double n2 = convertToDouble(numberTwo);

        return n1 - n2;

    }

    public Double multiplication(String numberOne, String numberTwo) throws Exception {


        Double n1 = convertToDouble(numberOne);
        Double n2 = convertToDouble(numberTwo);

        return n1 * n2;

    }

    public Double division(String numberOne, String numberTwo) throws Exception {


        Double n1 = convertToDouble(numberOne);
        Double n2 = convertToDouble(numberTwo);

        return n1 / n2;

    }

    public Double squareRoot(String numberOne) throws Exception {


        Double n1 = convertToDouble(numberOne);

        return Math.sqrt(n1);

    }

    public Double mean(String numberOne, String numberTwo) throws Exception {


        Double n1 = convertToDouble(numberOne);
        Double n2 = convertToDouble(numberTwo);

        return (n1 + n2)/2;

    }

    private Double convertToDouble(String strNumber) throws Exception {
        String number = strNumber.replace(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) throws Exception {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        if(number.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            return true;
        } else {
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
    }

}
