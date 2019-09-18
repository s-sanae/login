package com.internousdev.login.action;
import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String name;
	private String password;

	public String execute() throws SQLException {
		String ret = ERROR;

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		dto = dao.select(name, password);

		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())){
		ret = SUCCESS;
			}
		}
		return ret;
	}
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

/* DAOでDBに接続し、取得した値をDTOに格納する
 * JSP（ユーザが見る画面）で入力を受けた値と、
 * DTOに格納されている値を、Actionに引っ張ってきて、if文で比較する
 * （２つが同じ値かどうか）。
 * JSPから値を持ってくるのは、Actionのsetterさんのお仕事。
 * 変数の文字の色で、どこからの変数か理解しておくこと
 *
 *
 * 成功か失敗かについて（return ret;）については、最初に失敗（ERROR）
 * を入れて初期化しておいて、if文でネストを利用して、
 * もし、nameもpasswordも一緒であれば、retにSUCCESSを
 * 代入して、結果を返し、一致しない場合は、retにすでに代入されている
 * ERRORを返してくれるという仕組み。
 *
 *
 */
