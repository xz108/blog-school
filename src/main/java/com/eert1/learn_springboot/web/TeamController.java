package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.TeamService;
import com.eert1.learn_springboot.pojo.Team_members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/Team")
public class TeamController {
    @Autowired
    TeamService teamService;
    @PostMapping("/postTetam")
    public boolean postTeam(@RequestBody Map<String, Object> map)
    {
        String leader =(String) map.get("leader");
        String teamMsg =(String) map.get("teamMsg");
        int create = teamService.createTeam(leader,teamMsg);
        return create == 1;
    }
    @PostMapping("/getApplication")
    public List<Team_members> getAll(@RequestBody Map<String,Object>map)
    {
        String team_id =(String) map.get("team_id");
//        String member_id=(String) map.get("mem")
        Integer td=Integer.parseInt(team_id);
        return teamService.SelectAllApplication(td);
    }
    @PostMapping("/postApplication")
    public boolean postApplication(@RequestBody Map<String,Object>map)
    {
        String team_id=(String) map.get("team_id");
        String member_name =(String) map.get("member_name");
        String role =(String) map.get("role");
        Integer td =Integer.parseInt(team_id);
        int post= teamService.PostApplication(td,member_name,role);
        return post==1;
    }
    @PostMapping("/accept")
    public boolean accept(@RequestBody Map<String,Object>map)
    {
        String team_id = (String) map.get("team_id");
        String member_id =(String) map.get("member_id");
        Integer td =Integer.parseInt(team_id);
        Integer md =Integer.parseInt(member_id);
        int accept=teamService.acceptApplication(td,md);
        return accept==1;
    }
    @PostMapping("/refuse")
    public boolean refuse(@RequestBody Map<String,Object>map)
    {
        String team_id = (String) map.get("team_id");
        String member_id =(String) map.get("member_id");
        Integer td =Integer.parseInt(team_id);
        Integer md =Integer.parseInt(member_id);
        int refuse=teamService.refuseApplication(td,md);
        return refuse==1;
    }
}
