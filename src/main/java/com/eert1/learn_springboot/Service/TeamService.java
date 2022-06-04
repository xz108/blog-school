package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.Team_members;

import java.util.List;

public interface TeamService {
    public List<Team_members> SelectAllApplication(int team_id);

    public int createTeam(String leader,String teamMsg);

    public int PostApplication(int team_id,String memberName,String role);

    public int acceptApplication(int team_id,int member_id);

    public int refuseApplication(int team_id,int member_id);
}
