package nyj001012.er_bal.domain;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionA;
    private String questionB;
    private String createdDate;
    private String updatedDate;
    private Long aChoiceCount;
    private Long bChoiceCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getaChoiceCount() {
        return aChoiceCount;
    }

    public void setaChoiceCount(Long aChoiceCount) {
        this.aChoiceCount = aChoiceCount;
    }

    public Long getbChoiceCount() {
        return bChoiceCount;
    }

    public void setbChoiceCount(Long bChoiceCount) {
        this.bChoiceCount = bChoiceCount;
    }
}
