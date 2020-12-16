package com.javachip.carrotcountry.shMarketBoard.townMarket.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.commit;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;
import static com.javachip.carrotcountry.common.JDBCtemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.model.TownMarketDao;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CommentHY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.PhotoBoardVo;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ReportReason;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo;

public class TownMarketService {
	

	public ArrayList<CategoryHY> CategorySelector() {
		
		Connection conn = getConnection();
		ArrayList<CategoryHY> list = new TownMarketDao().CategorySelector(conn);
		
		close(conn);
		return list;
	}

	public ArrayList<PostBoard> mainArticleSelector(ShmarketPageInfo sp) {
		
		Connection conn = getConnection();
		ArrayList<PostBoard> boardList = new TownMarketDao().mainArticleSelector(conn,sp);
		
		close(conn);
		return boardList;
	}

	public int increaseBoardViews(int bno) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().increaseBoardViews(conn,bno);
		
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public PostBoard PostBoardDetailSelector(int bno) {
		
		Connection conn = getConnection();
		
		PostBoard pb = new TownMarketDao().PostBoardDetailSelector(conn,bno);
		
		close(conn);
		
		
		return pb;
	}

	public ArrayList<CommentHY> marketCommentSelector(int bno) {
		
		Connection conn = getConnection();
		ArrayList<CommentHY> list = new TownMarketDao().marketCommentSelector(conn,bno);
		
		close(conn);
		
		return list;
	}

	public CommentHY shBoardInsertComment(CommentHY c) {
		
		Connection conn = getConnection();
		CommentHY reSelect = null;
		
		int result = new TownMarketDao().shBoardInsertComment(conn,c);
		
		if(result>0) {
			commit(conn);
			
			reSelect = new TownMarketDao().shMarketBoardCommentSelector(conn,c);
			
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return reSelect;
	}

	public int shMarketBoardInsert(PostBoard pb, ArrayList<PhotoBoardVo> list,Location l) {
		
		Connection conn = getConnection();
		//보드 인서트 하고옴.
		int result1 = new TownMarketDao().shMarketBoardInsert(conn,pb,list,l);
		//제품 상태 insert
		int result2 = new TownMarketDao().shMarketBordConditionInsert(conn,pb);
		//
		int result3 = new TownMarketDao().shMarketPhotoInsert(conn,list);
		
		if(result1>0 && result2 >0 && result3>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}

	public int townMarketDeleteForm(int bno) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().townMarketDeleteForm(conn,bno);
		
		if(result>0){
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<PhotoBoardVo> shMarketPhotoSelector(int bno) {
		
		Connection conn = getConnection();
		
		ArrayList<PhotoBoardVo> list = new TownMarketDao().shMarketPhotoSelector(bno,conn);	
		
		close(conn);
		
		return list;
	}

	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = 0;
		result = new TownMarketDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}

	public int postStatusUpdate(int bno) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().postStatusUpdate(conn,bno);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int dibsCheck(int bno, int userNo) {
		
		Connection conn = getConnection();
		
		int checking = new TownMarketDao().dibsCheck(conn,bno,userNo);
		
		close(conn);
		
		return checking;
	}

	public int insertLike(int bno, int userNo) {
		Connection conn = getConnection();
		
		int result1 = new TownMarketDao().insertLike(conn,bno,userNo);
		int result2 = new TownMarketDao().insertPostBoardLike(conn,bno,userNo);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1*result2;
	}

	public ArrayList<Integer> likeCountSelector(ShmarketPageInfo sp) {
		
		Connection conn = getConnection();
		ArrayList<Integer> likeCount = new TownMarketDao().likeCountSelector(conn,sp);

		close(conn);
		
		return likeCount;
	}



	public int shMarketcommentDelete(int delCommentNo) {
		
		Connection conn = getConnection();

		int result = new TownMarketDao().shMarketcommentDelete(conn,delCommentNo);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	
		return result;
	}

	public int shMarketBoardModify(PostBoard b, Location l, String pCondition) {
		
		
		
		Connection conn = getConnection();
		
		int result1 = new TownMarketDao().shMarketBoardModify(conn,b,l,pCondition);
		
		int result2 = new TownMarketDao().shMarketUsedProdModify(conn,b,pCondition);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1*result2;
	}

	public int shMarketBoardModifyPlusPhoto(PostBoard b, Location l, String pCondition, ArrayList<PhotoBoardVo> pList) {
		
		Connection conn = getConnection();
		//PostBoard update // 이것도 웬만하면 됨
		int result1 = new TownMarketDao().shMarketBoardAndPhotoModify(b,l,pCondition,pList,conn);
		//UsedProd update  //업데이트 됨
		int result2 = new TownMarketDao().shMarketUsedProdModify(conn,b,pCondition);
		//PhotoBoard 있던거 삭제해줘야함. 한개는 무조건 삭제됨
		int result3 = new TownMarketDao().shMarketPhotoDelete(conn,b);
		//사진 업데이트 해줘야함. 업데이트도 무조건 됨
		int result4 = new TownMarketDao().shMarketPhotoUpdate(conn,b,pList);
		
		
		if(result1>0 && result2>0 && result3>0 && result4>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1*result2*result3*result4;
	}

	public ArrayList<ReportReason> shMarketReportCategorySelector() {
		
		Connection conn = getConnection();
		
		ArrayList<ReportReason> rList = new TownMarketDao().shMarketReportCategorySelector(conn);
		
		close(conn);
		
		return rList;
	}

	public int reportPreCheck(int memNo, int postNo) {
		
		Connection conn = getConnection();
		
		int preCheck = new TownMarketDao().reportPreCheck(conn,memNo,postNo);
				
		close(conn);
		
		return preCheck;
	}

	public int shMarketReportInsert(int memNo, String rReason, int postNo, String rContent) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().shMarketReportInsert(conn,memNo,rReason,postNo,rContent);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Location shMarketLocationSelector(int bno) {

		Connection conn = getConnection();
		
		Location l = new TownMarketDao().shMarketLocationSelector(conn,bno);
		
		close(conn);

		
		
		return l;
	}

	public int shMarketCommentModifier(int commentNo, String userContent) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().shMarketCommentModifier(conn,commentNo,userContent);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int shMarketCommentReportPrecheck(int memNo, int postNo) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().shMarketCommentReportPrecheck(conn,memNo,postNo);
		
		close(conn);
		return result;
	}

	public int shMarketCommentReportInsert(int memNo, String rReason, int postNo, String rContent) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().shMarketCommentReportInsert(conn,memNo,rReason,postNo,rContent);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<PostBoard> townMarketAjaxBoardSelector(ShmarketPageInfo sp) {
		
		Connection conn = getConnection();
		ArrayList<PostBoard> list = new TownMarketDao().townMarketAjaxBoardSelector(conn,sp);
		

		close(conn);
		
		
		return list;
	}

	public ArrayList<PostBoard> TownMarketBoardAjaxCategorySelector(String cName, ShmarketPageInfo sp) {
		
		Connection conn = getConnection();
		
		ArrayList<PostBoard> list = new TownMarketDao().TownMarketBoardAjaxCategorySelector(conn,cName,sp);
		
		close(conn);
		
		return list;
	}

	public ArrayList<PostBoard> townMarketAjaxUserSearchMain(ShmarketPageInfo sp, String userSearch, String userGu,
			String userDong, String userCategory) {
		Connection conn = getConnection();
		ArrayList<PostBoard> bList = new TownMarketDao().townMarketAjaxUserSearchMain(conn,sp,userSearch,userGu,userDong,userCategory);
		
		close(conn);
		
		return bList;
	}

	public ArrayList<PostBoard> shMarketArticleAjaxSortng(ShmarketPageInfo sp, int sortNum) {
		
		Connection conn = getConnection();
		
		ArrayList<PostBoard> pList = new TownMarketDao().townMarketAjaxSorter(conn,sp,sortNum);
		
		close(conn);
		
		return pList;
	}

	
}
