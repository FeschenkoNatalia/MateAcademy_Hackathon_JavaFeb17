package com.mate_academy.social_network.model;

import javax.persistence.*;
import java.io.Serializable;

    @Entity
    @Table(name = "message")
    public class Message implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Id
        @Column(name = "message_id")
        private Long message_Id;

        @Column(name = "text")
        private String text;

        @ManyToOne (fetch = FetchType.LAZY)
        @JoinColumn (name = "group_id")
        private Group group;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getMessage_Id() {
            return message_Id;
        }

        public void setMessage_Id(Long message_Id) {
            this.message_Id = message_Id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Group getGroup() {
            return group;
        }

        public void setGroup(Group group) {
            this.group = group;
        }
    }
