package by.casanova.team.repository;

import by.casanova.team.models.labs.Diary;
import by.casanova.team.models.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by artifaqiq on 2/12/17.
 */

public interface DiaryRepository extends CrudRepository<Diary, Long> {
    @Query("select d from Diary d order by lastModifiedDate desc")
    public List<Diary> findLastModifiedDiary();

}
