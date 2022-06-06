package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.Team;
import com.eert1.learn_springboot.pojo.Team_members;
import com.eert1.learn_springboot.pojo.User;

import java.util.List;

public interface TeamService {
    public List<Team_members> SelectAllApplication(int team_id);

//    public int createTeam(String leader,String teamMsg);

//    public int PostApplication(int team_id,String memberName,String role);

    int createTeam(String leader, String teamMsg, String leader_avatar, int max_num);

    int PostApplication(int team_id, String memberName, String role, String avatar);

    public int acceptApplication(int team_id, int member_id);

    public int refuseApplication(int team_id,int member_id);

    public List<Team> SelectAll();

    public List<Team> SearchTeam(int key);
    public List<Team> GetTeamByname(String username);
}
