package cn.edu.cqu.party.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 党费表
 * @author RongchenLiu
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id","partyDueStandard_id"}) })
public class PartyDue {
	/**
	 * 逻辑主键，自增长
	 */
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * 与用户关联
	 */
	@ManyToOne(optional=false)
	private User user;
	/**
	 * 与党费标准关联
	 */
	@ManyToOne(optional=false)
	private PartyDueStandard partyDueStandard;
	
	/**
	 * 缴费类型：个人和单位
	 */
	@Column(nullable=false,length=50)
	private String type;
	
	/**
	 * 缴费日期
	 */
	@Column(nullable=false)
	private Date paymentTime;
	
	/**
	 * 截止日期
	 */
	@Column(nullable=false)
	private Date endTime;
	/**
	 * 缴费状态
	 */
	@Column(nullable=false,length=50)
	private String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PartyDueStandard getPartyDueStandard() {
		return partyDueStandard;
	}
	public void setPartyDueStandard(PartyDueStandard partyDueStandard) {
		this.partyDueStandard = partyDueStandard;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((partyDueStandard == null) ? 0 : partyDueStandard.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartyDue other = (PartyDue) obj;
		if (partyDueStandard == null) {
			if (other.partyDueStandard != null)
				return false;
		} else if (!partyDueStandard.equals(other.partyDueStandard))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
