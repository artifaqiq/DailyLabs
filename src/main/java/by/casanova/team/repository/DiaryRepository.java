package by.casanova.team.repository;

import by.casanova.team.models.labs.Diary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by artifaqiq on 2/12/17.
 */

public interface DiaryRepository extends CrudRepository<Diary, Long> {
    @Query("select d from Diary d order by lastModifiedDate desc")
    List<Diary> findLastModifiedDiary();
}
