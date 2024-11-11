package nyj001012.er_bal.repository;

import jakarta.transaction.Transactional;
import nyj001012.er_bal.domain.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class QuestionRepositoryTest {
    @Autowired QuestionRepository questionRepository;

    @Test
    void 질문_등록_테스트() {
        Date dateTime = new Date();
        Question question = new Question();
        question.setQuestionA("질문1");
        question.setQuestionB("질문2");
        question.setCreatedDate(dateTime);
        question.setUpdatedDate(dateTime);
        question.setaChoiceCount(0L);
        question.setbChoiceCount(0L);

        questionRepository.save(question);

        assertThat(questionRepository.findById(question.getId())).isEqualTo(question);
    }
}
