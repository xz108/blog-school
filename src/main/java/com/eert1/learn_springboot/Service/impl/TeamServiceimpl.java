package com.eert1.learn_springboot.Service.impl;

import com.eert1.learn_springboot.Service.TeamService;
import com.eert1.learn_springboot.dao.TeamRepository;
import com.eert1.learn_springboot.pojo.Team;
import com.eert1.learn_springboot.pojo.Team_members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamServiceimpl implements TeamService {
    @Autowired
    TeamRepository teamRepository;
    @Override
    public List<Team_members> SelectAllApplication(int team_id) {
        return teamRepository.SelectAllApplication(team_id);
    }

    @Override
    public int createTeam(String leader, String teamMsg,String leader_avatar,int max_num,String title) {
       int create= teamRepository.create_team(leader,teamMsg,leader_avatar,max_num,title);
        if(create==1)
            return 1;
        else return 0;
    }

    @Override
    public int PostApplication(int team_id, String memberName, String role,String avatar) {
        int post=teamRepository.applyToJoin(team_id,memberName,role,avatar);
        if (post==1)
            return 1;
        else return 0;
    }

    @Override
    public int acceptApplication(int team_id, int member_id) {
        int update =teamRepository.acceptTeam(team_id,member_id);
        if (update==1)
            return 1;
        else return 0;
    }

    @Override
    public int refuseApplication(int team_id, int member_id) {
        int update =teamRepository.refuseTeam(team_id,member_id);
        if (update==1)
            return 1;
        else return 0;
    }

    @Override
    public List<Team> SelectAll() {
       return teamRepository.SelectAll();
    }

    @Override
    public List<Team> SearchTeam(String key) {
        return teamRepository.SearchTeam(key);
    }

    @Override
    public List<Team> GetTeamByname(String username) {
        return teamRepository.GetAllTeamByName(username);
    }
}
