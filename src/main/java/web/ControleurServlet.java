package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aeroport.IavionCatalogue;
import aeroport.AvionImpl;
import aeroport.Avion;

@WebServlet (name="cs",urlPatterns= {"/controleur"})
public class ControleurServlet extends HttpServlet {
private IavionCatalogue avion;
@Override
public void init() throws ServletException {
avion=new AvionImpl();
}

@Override
protected void doPost(HttpServletRequest request,
 HttpServletResponse response) 
 throws ServletException, IOException {
	String mc=request.getParameter("motCle");
	AvionModele mod = new AvionModele();
	mod.setMotCle(mc);
	List<Avion> avios = avion.getAvionsParMotCle(mc);
	mod.setAvions(avios);
	request.setAttribute("modele", mod);
	request.getRequestDispatcher("AvionsView.jsp").forward(request,response);
	}
}