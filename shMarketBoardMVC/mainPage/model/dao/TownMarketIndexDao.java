package com.javachip.carrotcountry.shMarketBoard.mainPage.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class TownMarketIndexDao {

	private Properties prop = new Properties();
	
	
	public TownMarketIndexDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(TownMarketIndexDao.class.getResource("/sql/shMarket/shMarketIndex.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public ArrayList<PostBoard> shMarketBoardAjaxSelector(Connection conn) {
		
		ArrayList<PostBoard> pList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("shMarketBoardAjaxSelector");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostBoard pb = new PostBoard(rs.getInt("POST_NO")
											,rs.getInt("MEM_NO")
											,rs.getString("LOCATION")
											,rs.getString("POST_NAME")
											,rs.getString("CATEGORY_NAME")
											,rs.getString("THUMBNAIL_PATH")
											,rs.getString("THUMBNAIL_FILENAME")
											,rs.getString("THUMBNAIL_LOADPATH")
											,rs.getInt("POST_VIEWS")
											,rs.getInt("POST_LIKES")
											,rs.getInt("PROD_PRICE"));
				pList.add(pb);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}		
		
		return pList;
	}
	
}
