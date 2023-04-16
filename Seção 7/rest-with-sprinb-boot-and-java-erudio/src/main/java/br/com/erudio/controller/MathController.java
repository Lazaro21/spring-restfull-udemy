package br.com.erudio.controller;

import br.com.erudio.exceptions.UnsuportedMathOperationException;
import br.com.erudio.services.MathService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    @Autowired
    private MathService service;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public ResponseEntity<Double> sum(@PathVariable(value = "numberOne") String numberOne,
                                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return ResponseEntity.ok().body(service.sum(numberOne, numberTwo));

    }
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public ResponseEntity<Double> subtraction(@PathVariable(value = "numberOne") String numberOne,
                                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return ResponseEntity.ok().body(service.subtraction(numberOne, numberTwo));

    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public ResponseEntity<Double> multiplication(@PathVariable(value = "numberOne") String numberOne,
                                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return ResponseEntity.ok().body(service.multiplication(numberOne, numberTwo));

    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public ResponseEntity<Double> division(@PathVariable(value = "numberOne") String numberOne,
                                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return ResponseEntity.ok().body(service.division(numberOne, numberTwo));

    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public ResponseEntity<Double> mean(@PathVariable(value = "numberOne") String numberOne,
                                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return ResponseEntity.ok().body(service.mean(numberOne, numberTwo));

    }

    @RequestMapping(value = "/sqrt/{numberOne}",
            method = RequestMethod.GET)
    public ResponseEntity<Double> squareRoot(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        return ResponseEntity.ok().body(service.squareRoot(numberOne));
    }

}
