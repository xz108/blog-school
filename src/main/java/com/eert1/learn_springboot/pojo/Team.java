package com.eert1.learn_springboot.pojo;

import java.util.List;

public class Team {
    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTeamMsg() {
        return teamMsg;
    }

    public void setTeamMsg(String teamMsg) {
        this.teamMsg = teamMsg;
    }

    public int team_id;
    public String leader;
    public String teamMsg;

    public String getLeader_avatar() {
        return leader_avatar;
    }

    public void setLeader_avatar(String leader_avatar) {
        this.leader_avatar = leader_avatar;
    }

    public int getMax_num() {
        return max_num;
    }

    public void setMax_num(int max_num) {
        this.max_num = max_num;
    }

    public String leader_avatar;
    public int max_num;

    public List<Team_members> team_membersList;

    public List<Team_members> getTeam_membersList() {
        return team_membersList;
    }

    public void setTeam_membersList(List<Team_members> team_membersList) {
        this.team_membersList = team_membersList;
    }
}
