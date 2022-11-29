package ru.iashinme.domain;

public class Answer {
    private String answer;
    private Boolean isTrue;

    public Answer(String answer, Boolean isTrue) {
        this.answer = answer;
        this.isTrue = isTrue;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setIsTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getIsTrue() {
        return isTrue;
    }

    @Override
    public String toString() {
        return answer + "(" + isTrue + ")";
    }
}
