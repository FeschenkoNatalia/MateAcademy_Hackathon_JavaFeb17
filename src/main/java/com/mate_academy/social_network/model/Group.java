//package com.mate_academy.social_network.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//    @Entity
//    @Table(name = "group")
//    public class Group {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "description")
//    private String description;
//
//    @OneToMany (fetch = FetchType.LAZY, mappedBy = "group")
//    private List<Message> messageList;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public List<Message> getMessageList() {
//        return messageList;
//    }
//
//    public void setMessageList(List<Message> messageList) {
//        this.messageList = messageList;
//    }
//}
