package com.fuzhu.entity.vo;

import com.fuzhu.entity.Score;
import com.fuzhu.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserScore {
    private Score score;
    private User user;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
