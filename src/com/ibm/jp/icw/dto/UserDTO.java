package com.ibm.jp.icw.dto;

/**
 * ユーザーのDTOです。
 */
public class UserDTO {
	private String userid;
	private String username;

	/**
	 * UserDTOのコンストラクタです。useridとusernameを渡します。<br>
	 * （不要な更新を防ぐため、useridとusernameのセッターをなくしている）
	 * @param userid - ユーザーのID
	 * @param username - ユーザーの名前
	 */
	public UserDTO(String userid, String username) {
		System.out.println("情報：UserDTO#コンストラクタ：userid:" + userid + ",username:" + username);
		this.userid = userid;
		this.username = username;
	}

	/**
	 * usernameのゲッター
	 * @return usernameを返す。
	 */
	public String getUsername() {
		System.out.println("情報：UserDTO#getUsername：" + username);
		return username;
	}

	/**
	 * useridのゲッター
	 * @return useridを返す。
	 */
	public String getUserid() {
		System.out.println("情報：UserDTO#getUserid：" + userid);
		return userid;
	}
}
