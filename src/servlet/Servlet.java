package servlet;

import dao.MeetingRoomDao;
import dao.impl.MeetingRoomDaoImpl;
import entity.MeetingRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//response.setContentType("text/html;charset=utf-8");
        String opr = request.getParameter("opr");
        MeetingRoomDao meetingRoomDao = new MeetingRoomDaoImpl();
        List<MeetingRoom> list = meetingRoomDao.queryAll();
        request.setAttribute("list", list);
        if (opr.equals("query")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (opr.equals("addquery")) {
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } else if (opr.equals("add")) {
            String meeting_name = request.getParameter("meeting_name");
            String advance_name = request.getParameter("advance_name");
            String meeting_order = request.getParameter("meeting_order");
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setMeeting_order(meeting_order);
            meetingRoom.setMeeting_name(meeting_name);
            meetingRoom.setAdvance_name(advance_name);
            meetingRoomDao.add(meetingRoom);
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    }
}
