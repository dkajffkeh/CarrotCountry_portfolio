package com.javachip.carrotcountry.shMarketBoard.mainPage.model.service;
import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.dao.TownMarketIndexDao;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;

public class TownMarketIndexService {

	public ArrayList<PostBoard> shMarketBoardAjaxSelector() {

		Connection conn = getConnection();
		
		ArrayList<PostBoard> pList = new TownMarketIndexDao().shMarketBoardAjaxSelector(conn);
		
		close(conn);
		
		return pList;
	}


}
