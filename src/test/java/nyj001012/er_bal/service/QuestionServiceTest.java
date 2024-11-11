package nyj001012.er_bal.service;

import nyj001012.er_bal.domain.Question;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class QuestionServiceTest {
    @Autowired QuestionService questionService;
    private Question question = new Question();

    @BeforeEach
    public void setUp() {
        this.question = new Question();
        this.question.setQuestionA("질문A");
        this.question.setQuestionB("질문B");
        this.question.setbChoiceCount(0L);
        this.question.setaChoiceCount(0L);
        this.question.setCreatedDate(new Date());
        this.question.setUpdatedDate(new Date());
    }

    @Nested
    class 질문_길이_검증_테스트 {

        @Test
        public void 질문_길이_검증_통과() {
            questionService.validateQuestionLength(question);
        }

        @Test
        public void 질문_길이가_100자를_넘는_경우() {
            // questionA가 101자인 경우
            question.setQuestionA("a".repeat(101));
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionLength(question));
            assertThat(e.getMessage()).isEqualTo("질문은 100자 이하이어야 합니다.");

            // questionA, questionB가 101자인 경우
            question.setQuestionA("질문A");
            question.setQuestionB("b".repeat(101));
            e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionLength(question));
            assertThat(e.getMessage()).isEqualTo("질문은 100자 이하이어야 합니다.");

            // questionB가 101자인 경우
            question.setQuestionA("a");
            e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionLength(question));
            assertThat(e.getMessage()).isEqualTo("질문은 100자 이하이어야 합니다.");
        }

        @Test
        public void 질문이_비어있을_경우() {
            // questionA가 비어있는 경우
            question.setQuestionA("");
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionLength(question));
            assertThat(e.getMessage()).isEqualTo("질문은 비어있을 수 없습니다.");

            // questionA, questionB가 비어있는 경우
            question.setQuestionB("");
            e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionLength(question));
            assertThat(e.getMessage()).isEqualTo("질문은 비어있을 수 없습니다.");

            // questionB가 비어있는 경우
            question.setQuestionA("질문A");
            e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionLength(question));
            assertThat(e.getMessage()).isEqualTo("질문은 비어있을 수 없습니다.");
        }
    }

    @Nested
    class 질문_비속어_포함_테스트 {

        @Test
        public void 질문_비속어_포함_통과() {
            questionService.validateQuestionProfanity(question);
        }

        @Test
        public void 질문에_비속어가_포함되어_있을_때() {
            // questionA에 비속어가 포함된 경우
            question.setQuestionA("ㅆㅂ이라고 욕한다.");
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionProfanity(question));
            assertThat(e.getMessage()).isEqualTo("욕설은 사용할 수 없습니다.");

            // questionA, questionB에 비속어가 포함된 경우
            question.setQuestionB("채팅으로 존나 못하네라고 한다.");
            e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionProfanity(question));
            assertThat(e.getMessage()).isEqualTo("욕설은 사용할 수 없습니다.");

            // questionB에 비속어가 포함된 경우
            question.setQuestionA("예쁜말..!");
            e = assertThrows(IllegalArgumentException.class, () -> questionService.validateQuestionProfanity(question));
            assertThat(e.getMessage()).isEqualTo("욕설은 사용할 수 없습니다.");
        }
    }
}
