package com.audax.AudaxTimeSheet.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "timesheet_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimesheetDetail {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "timesheet_detail_id")
	    private Long timesheetDetailId;

	    @Column(name = "timesheet_detail_month", nullable = false)
	    private String timesheetDetailMonth;

	    @ManyToOne
	    @JoinColumn(name = "template_name_id", nullable = false)
	    private TemplateName templateName;

	    @ManyToOne
	    @JoinColumn(name = "resourse_id", nullable = false)
	    private Resource resource;

	    @Column(name = "job_name", nullable = false)
	    private String jobName;

	    @Column(name = "billable_status", nullable = false)
	    private Boolean billableStatus;

	    @Column(name = "billable_hour", nullable = false)
	    private Long billableHour;

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
