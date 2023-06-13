import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bolsillo.*;

public class Bolsillo extends HttpServlet {
    Daviplata daviplata = new Daviplata();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        System.out.println("Bolsillo: se ha recibido solicitudes.");

        String navegacion = req.getParameter("navegacion"); /* Recibimos datos de tipo get en la URL misma */
        String cuenta = req.getParameter("cuenta");
        System.out.println("Se ha recibido una página de tipo: "+navegacion);

        if (navegacion != null) {
            switch (navegacion) {
                case "inicio":
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
                case "nequi":
                    req.getRequestDispatcher("cuenta-nequi.jsp").forward(req, resp);
                    break;
                case "daviplata":
                    req.getRequestDispatcher("cuenta-daviplata.jsp").forward(req, resp);
                    break;  
                default:
            }
        } else {
            System.out.println("No se está navegando en las pestañas principales");
        }

        if (cuenta != null) {
            switch (cuenta) {
                case "recargar":
                    req.getRequestDispatcher("recargar.jsp").forward(req, resp);
                    break;
                case "transferir":
                    req.getRequestDispatcher("transferir.jsp").forward(req, resp);
                    break;
                case "dashboard":
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                    break;  
            }   
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        String datos = req.getParameter("datos");
        System.out.println("Del lado post: "+datos);
        switch (datos) {
            case "ingresarSaldo":
                double monto = Double.parseDouble(req.getParameter("monto"));
                daviplata.setRecarga(monto);
                
                req.setAttribute("operacion", daviplata.ingresarDinero());
                req.setAttribute("consultarSaldo", daviplata.mostrarBolsillo());
                req.getRequestDispatcher("resultado.jsp").forward(req, resp);
                break;
            case "transferir":
                double retiro = Double.parseDouble(req.getParameter("monto"));
                daviplata.setRetiro(retiro);

                req.setAttribute("operacion", daviplata.retirarDinero());
                req.setAttribute("consultarSaldo", daviplata.mostrarBolsillo());
                req.getRequestDispatcher("res_retiro.jsp").forward(req, resp);
        }
    }
    
}
