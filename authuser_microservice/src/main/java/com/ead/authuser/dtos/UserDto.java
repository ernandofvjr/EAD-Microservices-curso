package com.ead.authuser.dtos;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.ead.authuser.validation.UsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
	
	
	public interface UserView {
		public static interface RegistrationPost{} //Registro do usuário no post
		public static interface Userput{} //Atualização das informações básicas do usuário
		public static interface PasswordPut{} //Alteração de senha
		public static interface ImagePut{} //Alteração de Imagem
	}
	
	private UUID userId;
	
	@NotBlank(groups = UserView.RegistrationPost.class)
	@UsernameConstraint(groups = UserView.RegistrationPost.class)
	@Size(min = 4, max = 50, groups = UserView.RegistrationPost.class)
	@JsonView(UserView.RegistrationPost.class)
	private String username;
	
	@NotBlank(groups = UserView.RegistrationPost.class)
	@Email(groups = UserView.RegistrationPost.class)
	@JsonView(UserView.RegistrationPost.class)
	private String email;
	
	@NotBlank(groups = {UserView.RegistrationPost.class, UserView.PasswordPut.class})
	@Size(min = 6, max = 20, groups = {UserView.RegistrationPost.class, UserView.PasswordPut.class})
	@JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class})
	private String password;
	
	@NotBlank(groups = UserView.PasswordPut.class)
	@Size(min = 6, max = 20, groups = UserView.PasswordPut.class)
	@JsonView(UserView.PasswordPut.class)
	private String oldPassword;
	
	@JsonView({UserView.RegistrationPost.class, UserView.Userput.class})
	private String fullName;
	
	@JsonView({UserView.RegistrationPost.class, UserView.Userput.class})
	private String phoneNumber;
	
	@JsonView({UserView.RegistrationPost.class, UserView.Userput.class})
	@CPF(groups = {UserView.RegistrationPost.class, UserView.Userput.class})
	private String cpf;
	
	@NotBlank(groups = UserView.ImagePut.class)
	@JsonView(UserView.ImagePut.class)
	private String imageUrl;


}
