package com.mate_academy.social_network.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "sender")
    private User sender;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "recipient")
    private User recipient;

    @Column(name = "text")
    private String text;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}