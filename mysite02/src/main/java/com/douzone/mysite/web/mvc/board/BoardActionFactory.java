package com.douzone.mysite.web.mvc.board;

import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		//이 안에 지금 파라미터 a에 지정된 actionName이 들어오고 있다.
		if("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if ("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else if ("viewform".equals(actionName)) {
			action = new ViewFormAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else {
			action = new IndexAction();
		}
		
		return action;
	}
}