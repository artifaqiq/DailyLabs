package by.casanova.team;

import by.casanova.team.repository.DiaryRepository;
import by.casanova.team.repository.LabRepository;
import by.casanova.team.repository.SubjectRepository;
import by.casanova.team.repository.user.UserRepository;
import by.casanova.team.service.DiaryService;
import by.casanova.team.service.LabService;
import by.casanova.team.service.SubjectService;
import by.casanova.team.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DailylabsApplicationTests extends TestCase {

	@Autowired
	private UserService userService;

	@Autowired
	private DiaryService diaryService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private LabService labService;

	@Test
	public void servicesTest() {
		assertNotNull(diaryService);
		assertNotNull(userService);
		assertNotNull(subjectService);
		assertNotNull(labService);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LabRepository labRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private DiaryRepository diaryRepository;

	public void repositoriesTest() {
		assertNotNull(userRepository);
		assertNotNull(subjectRepository);
		assertNotNull(labRepository);
		assertNotNull(diaryRepository);
	}

}
