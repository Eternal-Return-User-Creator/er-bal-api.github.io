package nyj001012.er_bal.service;

import nyj001012.er_bal.domain.Question;
import nyj001012.er_bal.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * 질문 등록
     * @param question 질문 객체
     * @return 질문 객체의 id
     */
    public Long post(Question question) {
        validateInvalidQuestion(question);
        questionRepository.save(question);
        return question.getId();
    }
}
