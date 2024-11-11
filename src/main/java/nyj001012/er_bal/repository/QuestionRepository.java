package nyj001012.er_bal.repository;

import jakarta.persistence.EntityManager;
import nyj001012.er_bal.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class QuestionRepository implements IQuestionRepository {
    private final EntityManager entityManager;

    public QuestionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Question save(Question question) {
        entityManager.persist(question);
        return question;
    }

    @Override
    public Optional<Question> findById(Long id) {
        Question question = entityManager.find(Question.class, id);
        return Optional.ofNullable(question);
    }
}
