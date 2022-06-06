package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.Team;
import com.eert1.learn_springboot.pojo.Team_members;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamRepository {
    @Insert("insert into team values(null,#{leader},#{teamMsg},#{leader_avatar},#{max_num})")
    int create_team(@Param("leader")String leader,
                    @Param("teamMsg")String teamMsg,
                    @Param("leader_avatar") String leader_avatar,
                    @Param("max_num")int max_num);

    @Insert("insert into team_members values (null,#{team_id},#{memberName},#{role},'OnPending',#{avatar})")
    int applyToJoin(@Param("team_id")int team_id,
                    @Param("memberName")String memberName,
                    @Param("role")String role,
                    @Param("avatar")String avatar);

    @Select("select * from team_members where team_id=#{team_id}")
    List<Team_members> SelectAllApplication(@Param("team_id")int team_id);

    @Update("update team_members set state = 'accept' where team_id= #{team_id} and member_id=#{member_id}")
    int acceptTeam(@Param("team_id")int team_id,
                   @Param("member_id")int member_id);

    @Update("update team_members set state = 'refuse' where team_id= #{team_id} and member_id=#{member_id}")
    int refuseTeam(@Param("team_id")int team_id,
                   @Param("member_id")int member_id);
//    @Select("select * from team_members left join team tm on team_members.team_id = tm.team_id")
    List<Team> SelectAll();

//    @Select("select * from ")
    List<Team> SearchTeam(int key);

    List<Team>GetAllTeamByName(String username);
}
