package com.sweetzpot.stravazpot.authenticaton.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.athlete.model.Athlete;

public class LoginResult{



	@SerializedName("token_type")
	private String tokenType;

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("athlete") private Athlete athlete;


	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("expires_at")
	private long expiresAt;

	@SerializedName("state")
	private String state;


	public Athlete getAthlete() {
		return athlete;
	}


	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public String formAccessToken(){
		return this.tokenType+" "+this.accessToken;
	}

	public void setRefreshToken(String refreshToken){
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken(){
		return refreshToken;
	}

	public void setExpiresAt(long expiresAt){
		this.expiresAt = expiresAt;
	}

	public long getExpiresAt(){
		return expiresAt;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setTokenType(String tokenType){
		this.tokenType = tokenType;
	}

	public String getTokenType(){
		return tokenType;
	}

	@Override
 	public String toString(){
		return 
			"LoginResult{" + 
			"access_token = '" + accessToken + '\'' + 
			",refresh_token = '" + refreshToken + '\'' + 
			",expires_at = '" + expiresAt + '\'' + 
			",state = '" + state + '\'' + 
			",token_type = '" + tokenType + '\'' + 
			"}";
		}
}