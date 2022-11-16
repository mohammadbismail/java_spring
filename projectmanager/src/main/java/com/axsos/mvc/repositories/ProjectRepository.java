package com.axsos.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc.models.Project;
import com.axsos.mvc.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
	List<Project> findAll();
	
	// or team_lead_in <> 2;
	@Query(value="select * from projects where team_lead_id not in(?1)",nativeQuery=true)
	List<Project> projectsWhereUserIsNotTL(Long userid);


	@Query(value="select * from projects where team_lead_id = ?1",nativeQuery=true)
	List<Project> allProjectWhereUserIsTL(Long userid);
	
	List<Project> findByusersContains(User user);
	
	List<Project> findByusersNotContains(User user);
//	@Query(value="select project_id from users_projects where user_id not in(?1)",nativeQuery=true)
//	Optional<List<Project>> projectsUserNotMemberOf(Long userid);
//	@Modifying
//	@Query(value="insert into users_projects (user_id,project_id) values (?1,?2)",nativeQuery=true)
//	int joinUserOnTeam(Long userid, Long projectid);
	
}
