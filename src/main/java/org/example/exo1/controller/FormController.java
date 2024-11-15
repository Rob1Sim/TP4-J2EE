package org.example.exo1.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.exo1.model.Formulaire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "createFormulaire", value = "/create-Formulaire")
public class FormController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String genre = request.getParameter("genre");
        String codePostal = request.getParameter("codePostal");
        String[] transports = request.getParameterValues("transports");

        // Validate required fields
        if (nom == null || prenom == null || genre == null || codePostal == null ||
                nom.isEmpty() || prenom.isEmpty() || genre.isEmpty() || codePostal.isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            RequestDispatcher rd = request.getRequestDispatcher("formulaire.jsp");
            rd.forward(request, response);
            return;
        }

        // Validate names
        if (!isValidName(nom)) {
            request.setAttribute("error", "Nom is invalid! It should only contain letters and spaces.");
            RequestDispatcher rd = request.getRequestDispatcher("formulaire.jsp");
            rd.forward(request, response);
            return;
        }

        if (!isValidName(prenom)) {
            request.setAttribute("error", "Prénom is invalid! It should only contain letters and spaces.");
            RequestDispatcher rd = request.getRequestDispatcher("formulaire.jsp");
            rd.forward(request, response);
            return;
        }

        // Validate code postal
        if (!isValidCodePostal(codePostal)) {
            request.setAttribute("error", "CodePostal invalid!");
            RequestDispatcher rd = request.getRequestDispatcher("formulaire.jsp");
            rd.forward(request, response);
            return;
        }

        // Create a new Formulaire object
        Formulaire formData = new Formulaire();
        formData.setNom(nom);
        formData.setPrenom(prenom);
        formData.setGenre(genre);
        formData.setCodePostal(codePostal);
        formData.setTransports(transports != null ? Arrays.asList(transports) : new ArrayList<>());

        // Get the session and retrieve the list of form submissions
        HttpSession session = request.getSession();

        // Store the updated list back in the session
        session.setAttribute("formData", formData);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // Forward to the results page
        RequestDispatcher rd = request.getRequestDispatcher("resultatFormulaire.jsp");

        StringBuilder formattedTransports = new StringBuilder();
        for (String transport : formData.getTransports()) {
            formattedTransports.append(transport).append("<br />");
        }
        request.setAttribute("formattedTransports", formattedTransports.toString());
        rd.forward(request, response);
    }


    private boolean isValidCodePostal(String codePostal) {
        String postalCodeRegex = "^[0-9]{5}$";  // A simple regex for a 5-digit postal code.

        Pattern pattern = Pattern.compile(postalCodeRegex);
        Matcher matcher = pattern.matcher(codePostal);
        return matcher.matches();
    }

    private boolean isValidName(String name) {
        String nameRegex = "^[a-zA-ZàáâäçèéêëîïôùúûüÿñæœÀÁÂÄÇÈÉÊËÎÏÔÙÚÛÜŸÑÆŒ ]+$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
