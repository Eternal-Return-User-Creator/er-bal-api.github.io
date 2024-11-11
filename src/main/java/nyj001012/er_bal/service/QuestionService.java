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
        validateQuestion(question);
        questionRepository.save(question);
        return question.getId();
    }

    /**
     * 질문 검증
     * 1. 질문 길이 검증
     * 2. 비속어 검증
     * 3. 질문 중복 검증
     * @param question 검증할 질문 객체
     */
    public void validateQuestion(Question question) {
        validateQuestionLength(question);
        validateQuestionProfanity(question);
        validateQuestionDuplicate(question);
    }

    /**
     * 질문 길이 검증 (100자 이하)
     * @param question 중복 검증할 질문 객체
     */
    public void validateQuestionLength(Question question) {
        if (question.getQuestionA().isEmpty() || question.getQuestionB().isEmpty()) {
            throw new IllegalArgumentException("질문은 비어있을 수 없습니다.");
        }
        if (question.getQuestionA().length() > 100 || question.getQuestionB().length() > 100) {
            throw new IllegalArgumentException("질문은 100자 이하이어야 합니다.");
        }
    }
}
