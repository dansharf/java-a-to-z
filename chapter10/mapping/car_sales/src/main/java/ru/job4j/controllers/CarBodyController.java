package ru.job4j.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.models.CarDetails;
import ru.job4j.repository.CarBodyRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * This controllers gives to the client body car.
 *
 * @author Alexey Voronin.
 * @since 07.11.2017.
 */
public class CarBodyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        List<CarDetails> carBodies = new CarBodyRepository().getBodies();
        writer.append(mapper.writeValueAsString(carBodies));
        writer.flush();
    }
}
