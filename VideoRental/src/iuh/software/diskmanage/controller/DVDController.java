package iuh.software.diskmanage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iuh.software.diskmanage.dao.DVDDAO;
import iuh.software.diskmanage.dao.DVDTypesDAO;
import iuh.software.diskmanage.dao.TitleDAO;
import iuh.software.diskmanage.entities.DVD;
import iuh.software.diskmanage.entities.DVDType;
import iuh.software.diskmanage.entities.Title;

/**
 * Servlet implementation class DVDController
 */
@WebServlet("/listDVD")
public class DVDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DVDController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DVDDAO dvdDAO = new DVDDAO();
		TitleDAO titleDAO = new TitleDAO();
		
		
		List<Title> listTitle = titleDAO.getAllTitle();
		

		for (Title title : listTitle) {
			List<DVD> listDVD = dvdDAO.getDVDByIdTitle(title.getIdTitle());
			title.setListDVD(listDVD);
		}
		request.setAttribute("listTitle", listTitle);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ListDVDView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
