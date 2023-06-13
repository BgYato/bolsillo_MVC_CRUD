package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BolsilloDAO;
import model.BolsilloVO;
import model.UsuarioDAO;
import model.UsuarioVO;

public class Usuario extends HttpServlet {
    UsuarioDAO usuDao;
    UsuarioVO usuVo;
    BolsilloDAO bolDao;
    BolsilloVO bolVo;

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
                case "inicio":
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                    break;
                case "salir":
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
                case "configuracion":

                    break;
            }   
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        String datos = req.getParameter("datos");
        System.out.println("Del lado post: "+datos);
        switch (datos) {
            case "Registrar":
                registroUsuario(req, resp);   
                break;
            case "Ingresar":
                ingresoUsuario(req, resp);
            break;            
        }
    }
    
    public void registroUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        usuVo = new UsuarioVO("", req.getParameter("correo"), req.getParameter("nombre"), req.getParameter("num"), req.getParameter("pwd"), req.getParameter("corresponsal"));
        usuDao = new UsuarioDAO(usuVo);
        if (usuDao.validarUsuario()) {
            req.setAttribute("mensaje", "existe");
            req.getRequestDispatcher("cuenta-nequi.jsp").forward(req, resp);
        } else {
            if (usuDao.registroUsuario()) {
                req.setAttribute("mensaje", "exito");
                req.getRequestDispatcher("cuenta-nequi.jsp").forward(req, resp);
            } else {
                req.setAttribute("mensaje", "error");
                req.getRequestDispatcher("cuenta-nequi.jsp").forward(req, resp);
            }    
        }     
    }

    public void ingresoUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        usuVo = new UsuarioVO();
        usuVo.setTelefono(req.getParameter("num"));
        usuVo.setPwd(req.getParameter("pwd"));
        usuDao = new UsuarioDAO(usuVo);
        
        if (usuDao.validarLogin()) {

            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        } else {
            req.setAttribute("mensaje", "no-existe");
            req.getRequestDispatcher("cuenta-nequi.jsp").forward(req, resp);                    
        } 
    }

    private void mostrarUsuario(HttpServletRequest req, HttpServletResponse resp) {
        try {
            usuVo = new UsuarioVO();
            usuVo.setTelefono(req.getParameter("num"));            
            usuDao = new UsuarioDAO(usuVo);
            String id = usuDao.obtenerId(req.getParameter("num"));

            bolVo = new BolsilloVO();            
            bolVo.setIdUsuario(id);
            bolDao = new BolsilloDAO(bolVo);
            
            List<UsuarioVO> usuarios = usuDao.mostrarUsuario();
            List<BolsilloVO> cuenta = bolDao.mostrarCuenta();
            req.setAttribute("usuario", usuarios);
            req.setAttribute("cuenta", cuenta);
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp); 
            System.out.println("Consulta hecha");           
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
}
