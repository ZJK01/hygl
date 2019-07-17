package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 文件表
 */
@Entity
public class Matter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer matterId;     // 文件序列号
	private String matterName;    // 文件名
	private Integer matterUserid; // 上传人
	private Date matterTime;          // 上传时间
	private Boolean matterEncryption; // 是否加密
	private String matterPassword;    // 加密密码
	private String deptnoId;          // 部门关联
	private String matterContent;     // 文件内容
	
	public Integer getMatterId() {
		return matterId;
	}

	public void setMatterId(Integer matterId) {
		this.matterId = matterId;
	}

	public String getMatterName() {
		return matterName;
	}

	public void setMatterName(String matterName) {
		this.matterName = matterName;
	}

	public Integer getMatterUserid() {
		return matterUserid;
	}

	public void setMatterUserid(Integer matterUserid) {
		this.matterUserid = matterUserid;
	}

	public Date getMatterTime() {
		return matterTime;
	}

	public void setMatterTime(Date matterTime) {
		this.matterTime = matterTime;
	}

	public Boolean getMatterEncryption() {
		return matterEncryption;
	}

	public void setMatterEncryption(Boolean matterEncryption) {
		this.matterEncryption = matterEncryption;
	}

	public String getMatterPassword() {
		return matterPassword;
	}

	public void setMatterPassword(String matterPassword) {
		this.matterPassword = matterPassword;
	}

	public String getDeptnoId() {
		return deptnoId;
	}

	public void setDeptnoId(String deptnoId) {
		this.deptnoId = deptnoId;
	}

	public String getMattercontent() {
		return matterContent;
	}

	public void setMattercontent(String mattercontent) {
		this.matterContent = mattercontent;
	}

	public Matter(Integer matterId, String matterName, Integer matterUserid, Date matterTime, Boolean matterEncryption,
			String matterPassword, String deptnoId, String mattercontent) {
		super();
		this.matterId = matterId;
		this.matterName = matterName;
		this.matterUserid = matterUserid;
		this.matterTime = matterTime;
		this.matterEncryption = matterEncryption;
		this.matterPassword = matterPassword;
		this.deptnoId = deptnoId;
		this.matterContent = mattercontent;
	}

	public Matter() {
		super();
	}

	@Override
	public String toString() {
		return "Matter [matterId=" + matterId + ", matterName=" + matterName + ", matterUserid=" + matterUserid
				+ ", matterTime=" + matterTime + ", matterEncryption=" + matterEncryption + ", matterPassword="
				+ matterPassword + ", deptnoId=" + deptnoId + ", matterContent=" + matterContent + "]";
	}

	
}
