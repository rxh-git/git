package dao;

import entity.MeetingRoom;

import java.util.List;

public interface MeetingRoomDao {
    List<MeetingRoom> queryAll();//查询所有数据
    int add(MeetingRoom meetingRoom);//添加数据
}
