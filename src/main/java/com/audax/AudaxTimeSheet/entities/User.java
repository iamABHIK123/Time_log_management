package com.audax.AudaxTimeSheet.entities;

import java.sql.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Long userId;

	    @Column(name = "user_login_id", nullable = false)
	    private String userLoginId;

	    @Column(name = "password", nullable = false)
	    private String password;

	    @Column(name = "user_type", nullable = false)
	    private String userType;

	    @ManyToOne
	    @JoinColumn(name = "role_id", nullable = false)
	    private Role role;

	    @Column(name = "created_by", nullable = false)
	    private String createdBy;

	    @Column(name = "creation_date", nullable = false)
	    private Date creationDate;

	    @Column(name = "updated_by")
	    private String updatedBy;

	    @Column(name = "updation_date")
	    private Date updationDate;

	    @Column(name = "version", nullable = false)
	    private Long version;

	    @Column(name = "is_active", nullable = false)
	    private Boolean isActive;
}