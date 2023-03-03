package br.com.calculadora.calculadora.controllers;

import br.com.calculadora.calculadora.auxiliaries.SimpleMath;
import br.com.calculadora.calculadora.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.calculadora.calculadora.auxiliaries.Converters.*;

@RestController
public class MathController {
    SimpleMath simpleMath = new SimpleMath();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return simpleMath.sum(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return simpleMath.sub(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value="/mul/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double mul(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return simpleMath.mul(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (isZero(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a number different to zero");
        }

        return simpleMath.div(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

}
