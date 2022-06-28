package com.ecodation.userproject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//Entity
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="name")
    private String userName;

    @Column(name="surname")
    private String userSurname;

    @Column(name="email")
    private String userEmail;

    @Column(name="password")
    private String userPassword;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="created_date")
    private Date createdDate;
}

