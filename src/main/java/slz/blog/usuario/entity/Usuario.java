package slz.blog.usuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Usuario {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
