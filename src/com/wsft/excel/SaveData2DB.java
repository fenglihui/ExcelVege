package com.wsft.excel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.wsft.excel.db.DbUtil;
import com.wsft.excel.domain.Vegetable;


public class SaveData2DB {
	public static final String INSERT_SQL = "insert into testtb(testtm, manage, sampname, location, channels, testidx, result, testaddr) values(?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_SQL = "update testtb set testtm = ?, manage = ?, sampname= ?, testaddr = ? where id = ? ";
	public static final String SELECT_ALL_SQL = "select id,testtm,manage,sampname,testaddr from testtb";
	public static final String SELECT_SQL = "select * from testtb where testtm like 'a%' and manage like 'b%' and sampname like 'c%' and location like 'c%' and channels like 'c%' and testaddr like 'c%'";
	@SuppressWarnings({ "rawtypes" })
	public void save() throws IOException, SQLException {
		ReadExcel xlsMain = new ReadExcel();
		Vegetable vegetable = null;
		List<Vegetable> list = xlsMain.readXls();

		for (int i = 0; i < list.size(); i++) {
			vegetable = list.get(i);
			//List l = DbUtil.selectOne(SELECT_SQL + "'%" + vegetable.getManage() + "%'", vegetable);
			//if (!l.contains(1)) {
				DbUtil.insert(INSERT_SQL, vegetable);
			//} else {
			//	System.out.println("The Record was Exist and has been throw away!");
			//}
		}
	}
}
