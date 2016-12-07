package net.board.action;

import javax.servlet.http.*;


public interface Action {
public ActionForward execute(HttpServletRequest Request, HttpServletResponse responds)
		throws Exception;

}
