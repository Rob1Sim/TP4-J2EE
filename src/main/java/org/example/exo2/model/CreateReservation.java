package org.example.exo2.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/CreateReservation")
public class CreateReservation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeAppartement = request.getParameter("typeAppartement");
        String prixStr = request.getParameter("prix");
        String[] optionsArray = request.getParameterValues("options"); // Récupération des options sélectionnées

        // Conversion du champ "prix" en double
        Double prix = null;
        try {
            prix = Double.parseDouble(prixStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Veuillez entrer un prix valide.");
            request.getRequestDispatcher("/reservation.jsp").forward(request, response);
            return;
        }

        // Vérification des champs requis
        if (typeAppartement == null || prix == null || optionsArray == null) {
            request.setAttribute("error", "Veuillez remplir tous les champs.");
            request.getRequestDispatcher("/reservation.jsp").forward(request, response);
            return;
        }

        // Création de l'objet Reservation et définition des valeurs
        Reservation reservation = new Reservation();

        // Vérification de la sélection et assignation du type d'appartement
        if (typeAppartement.equals("0")) {
            reservation.setType(AppartType.PETIT);
        } else if (typeAppartement.equals("1")) {
            reservation.setType(AppartType.MOYEN);
        } else if (typeAppartement.equals("2")) {
            reservation.setType(AppartType.GRAND);
        }

        // Conversion des options en ArrayList et définition dans la réservation
        ArrayList<OptionsType> optionsList = new ArrayList<OptionsType>() ;
        for (String s : optionsArray) {
            if (s.equals("Proche de la mer")) {
                optionsList.add(OptionsType.SEA);
            }
            if (s.equals("pool")) {
                optionsList.add(OptionsType.POOL);
            }
            if (s.equals("Jardin")) {
                optionsList.add(OptionsType.GARDEN);
            }
        }
        switch (typeAppartement) {
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


        reservation.setOptions(optionsList);

        reservation.setPrice(prix);

        // Enregistrement de la réservation dans la session
        HttpSession session = request.getSession();
        session.setAttribute("reservation", reservation);

        // Redirection vers la page de confirmation
        response.sendRedirect("info_reservation.jsp");
    }
}
