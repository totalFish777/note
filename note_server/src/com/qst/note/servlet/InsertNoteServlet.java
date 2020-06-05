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
 * Servlet implementation class InsertNoteServlet
 */
@WebServlet("/InsertNoteServlet")
public class InsertNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertNoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String title = request.getParameter("title");
		String tel = request.getParameter("tel");
		String content = request.getParameter("content");
		String noteTime = request.getParameter("noteTime");

		NoteDao dao = new NoteDao();
		Gson gson = new Gson();
		Result result = new Result();

		result.isSuccess = dao.insert(title, content, noteTime, tel);
		result.msg = result.isSuccess ? "上传成功" : "上传失败";
		response.getWriter().append(gson.toJson(result));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
