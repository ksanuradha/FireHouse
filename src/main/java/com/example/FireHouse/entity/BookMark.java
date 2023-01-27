package com.example.FireHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Table(name = "bookMark")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookMark {
    @Id
    @Column(name = "id", length = 45)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "url", length = 100)
    private String url;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "status", length = 45)
    private int status;

    @Column(name = "expiry_date", columnDefinition = "DATETIME")
    private Date expiryDate;

    @Column(name = "featured", length = 45)
    private int featured;

    @Column(name = "user_id", length = 45)
    private int userId;

    @Column(name = "image", length = 100)
    private String image;

    @Column(name = "created_at", columnDefinition = "DATETIME")
    private Date createdAt;
}
