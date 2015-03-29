package cn.edu.cqu.party.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 学校表
 * @author RongchenLiu
 *
 */
@Entity
public class School {
	/**
	 * 逻辑主键，自增长
	 */
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * 学校名
	 */
	@Column(nullable=false,unique=true,length=50)
	private String name;
}
