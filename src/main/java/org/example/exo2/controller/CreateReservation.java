package org.example.exo2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.exo2.model.AppartType;
import org.example.exo2.model.Client;
import org.example.exo2.model.OptionsType;
import org.example.exo2.model.Reservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "create-reservation", value = "/createReservation")
public class CreateReservation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isConnected", req.getSession().getAttribute("clientSession") != null);
        req.getRequestDispatcher("reservation.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeAppartement = request.getParameter("typeAppartement");
        String prixStr = request.getParameter("prix");
        String[] optionsArray = request.getParameterValues("options"); // Récupération des options sélectionnées

        // Conversion du champ "prix" en double
        double prix = 0.0;
        try {
            prix = Double.parseDouble(prixStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Veuillez entrer un prix valide.");
            request.getRequestDispatcher("reservation.jsp").forward(request, response);
        }

        // Vérification des champs requis
        if (typeAppartement == null || optionsArray == null) {
            request.setAttribute("error", "Veuillez remplir tous les champs.");
            request.getRequestDispatcher("reservation.jsp").forward(request, response);
        }


        // Création de l'objet Reservation et définition des valeurs
        Reservation reservation = new Reservation();
        // Conversion des options en ArrayList et définition dans la réservation
        ArrayList<OptionsType> optionsList = new ArrayList<>() ;
        for (String s : optionsArray) {
            if (s.equals("mer")) {
                optionsList.add(OptionsType.SEA);
            }
            if (s.equals("piscine")) {
                optionsList.add(OptionsType.POOL);
            }
            if (s.equals("jardin")) {
                optionsList.add(OptionsType.GARDEN);
            }
        }
        reservation.setOptions(optionsList);

        switch (Objects.requireNonNull(typeAppartement)) {
            case "0":
                reservation.setType(AppartType.PETIT);
                break;
            case "1":
                reservation.setType(AppartType.MOYEN);
                break;
            case "2":
                reservation.setType(AppartType.GRAND);
                break;
        }

        reservation.setPrice(prix);
        request.setAttribute("reservation", reservation);

        Client client = (Client) request.getSession().getAttribute("clientSession");
        client.setReservation(reservation);
        request.getSession().setAttribute("clientSession", client);
        request.setAttribute("clientBean",client);
        request.getRequestDispatcher("info_reservation.jsp").forward(request, response);
    }
}
