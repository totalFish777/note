package com.qst.note.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.dao.NoteDao;
import com.qst.note.dao.UserDao;
import com.qst.note.result.Result;

/**
 * Servlet implementation class DeleteNoteServlet
 */
@WebServlet("/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String tel = request.getParameter("tel");
		
		int id = Integer.parseInt(request.getParameter("id"));
		NoteDao ndao = new NoteDao();
		Gson gson = new Gson();
		Result rs = new Result();
		
		rs.isSuccess = ndao.DeleteNoteById(id);
		rs.msg = rs.isSuccess?"É¾³ý³É¹¦":"É¾³ýÊ§°Ü";
		
		response.getWriter().append(gson.toJson(rs));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
