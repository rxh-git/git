package dao.impl;

import dao.BaseDao;
import dao.MeetingRoomDao;
import entity.MeetingRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingRoomDaoImpl extends BaseDao implements MeetingRoomDao {
    @Override
    public List<MeetingRoom> queryAll() {
        String sql = "select * from meetingroom";
        ResultSet resultSet = executeQuery(sql);
        List<MeetingRoom> list = new ArrayList<MeetingRoom>();
        try {

            while (resultSet.next()) {
                MeetingRoom meetingRoom = new MeetingRoom();
                meetingRoom.setId(resultSet.getInt("id"));
                meetingRoom.setMeeting_name(resultSet.getString("meeting_name"));
                meetingRoom.setMeeting_order(resultSet.getString("meeting_order"));
                meetingRoom.setAdvance_name(resultSet.getString("advance_name"));
                list.add(meetingRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(MeetingRoom meetingRoom) {
        String sql="insert into meetingroom(meeting_name,meeting_order,advance_name) values(?,?,?)";
        Object[] params = new Object[] { meetingRoom.getMeeting_name(),
                meetingRoom.getMeeting_order(), meetingRoom.getAdvance_name() };
        int result = 0;
        try {
            result = executeUpdate(sql, params);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,pstmt,rs);
        }
        return result;
    }
}
