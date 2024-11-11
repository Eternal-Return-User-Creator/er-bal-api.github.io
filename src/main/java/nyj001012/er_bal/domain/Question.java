package nyj001012.er_bal.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="question_a")
    private String questionA;

    @Column(name="question_b")
    private String questionB;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="updated_date")
    private Date updatedDate;

    @Column(name="a_choice_count")
    private Long aChoiceCount;

    @Column(name="b_choice_count")
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
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
