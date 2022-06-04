package com.eert1.learn_springboot.pojo;

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

}
