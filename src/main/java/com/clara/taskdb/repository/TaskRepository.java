package com.clara.taskdb.repository;

import com.clara.taskdb.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    // define helper methods for querying DB here.
    List<Task> findAll();
    List<Task> findAllByOrderByUrgentDesc();
//Custom query for updating a task object, setting the completed value
//    returns the number of rows modified, if the task was found and updated return 1
//    if the task with this id not found in the db, no rows are updated so return 0
    @Transactional
    @Modifying
    @Query("Update Task t set t.completed= ?1 where t.id=?2")
    int setTaskCompleted(boolean completed, long id);
}

