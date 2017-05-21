package com.mate_academy.social_network.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "friends")
public class Friends implements Serializable{

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u1")
    private User user1;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u2")
    private User user2;

    @Column(name = "status", nullable = false)
    private Boolean status;


    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}



