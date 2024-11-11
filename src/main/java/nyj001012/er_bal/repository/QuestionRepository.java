package nyj001012.er_bal.repository;

import jakarta.persistence.EntityManager;
import nyj001012.er_bal.domain.Question;

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
}
