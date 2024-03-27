package com.audax.AudaxTimeSheet.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "templateName")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateName {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "template_name_id")
	    private Long templateNameId;

	    @Column(name = "template_name", nullable = false)
	    private String templateName;

	    @Column(name = "created_by", nullable = false)
	    private String createdBy;

	    @Column(name = "creation_date", nullable = false)
	    private Date creationDate;

	    @Column(name = "updated_by")
	    private String updatedBy;

	    @Column(name = "updation_date")
	    private Date updationDate;

	    @Column(name = "version")
	    private Long version;

	    @Column(name = "is_active")
	    private Boolean isActive;

}
