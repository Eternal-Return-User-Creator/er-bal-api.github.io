package nyj001012.er_bal.repository;

import nyj001012.er_bal.domain.Question;

import java.util.Optional;

public interface IQuestionRepository {
    Question save(Question question);
    Optional<Question> findById(Long id);
}
