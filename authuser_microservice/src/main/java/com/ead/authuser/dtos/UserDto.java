package com.ead.authuser.dtos;

import java.util.UUID;

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
	
	@JsonView(UserView.RegistrationPost.class)
	private String username;
	
	@JsonView(UserView.RegistrationPost.class)
	private String email;
	
	@JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class})
	private String password;
	
	@JsonView(UserView.PasswordPut.class)
	private String oldPassword;
	
	@JsonView({UserView.RegistrationPost.class, UserView.Userput.class})
	private String fullName;
	
	@JsonView({UserView.RegistrationPost.class, UserView.Userput.class})
	private String phoneNumber;
	
	@JsonView({UserView.RegistrationPost.class, UserView.Userput.class})
	private String cpf;
	
	@JsonView(UserView.ImagePut.class)
	private String imageUrl;


}
