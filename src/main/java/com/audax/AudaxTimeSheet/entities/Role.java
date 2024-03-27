package com.audax.AudaxTimeSheet.entities;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_description", nullable = false)
    private String roleDescription;

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
