package com.qst.note.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.dao.NoteDao;
import com.qst.note.result.Result;

/**
 * Servlet implementation class UpdateNoteServlet
 */
@WebServlet("/UpdateNoteServlet")
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int id = Integer.parseInt(request.getParameter("id"));
		String noteTime = request.getParameter("noteTime");
		
		NoteDao dao = new NoteDao();
		Gson gson = new Gson();
		Result rs = new Result();
		
		rs.isSuccess = dao.ModifyNote(id, title, content, noteTime);
		rs.msg = rs.isSuccess?"修改成功":"修改失败";
		
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
