package com.douzone.mysite.web.mvc.board;

import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		//이 안에 지금 파라미터 a에 지정된 actionName이 들어오고 있다.
		if("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else if ("view".equals(actionName)) {
			action = new ViewAction();
		} else {
			action = new IndexAction();
		}
		
		return action;
	}
}