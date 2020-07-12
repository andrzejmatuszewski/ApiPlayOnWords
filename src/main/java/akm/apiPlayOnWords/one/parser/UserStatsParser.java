package akm.apiPlayOnWords.one.parser;

import akm.apiPlayOnWords.one.model.UserStats;

public class UserStatsParser {
 
 	public String createSaveQuery(UserStats userStat) {
 		String query = "INSERT INTO USER_STATS  VALUES ('"+ userStat.getLogin()+ "', '" + userStat.getRequestCount() +"');";
 		return query;
 	}

	public String createUpdateQuery(UserStats userStat) {
		String query = "UPDATE USER_STATS SET REQUEST_COUNT='"+userStat.getRequestCount()+"' WHERE LOGIN='"+userStat.getLogin()+"';";
		return query;
	}


	public String createFindQuery(UserStats userStat) {
		String query = "SELECT LOGIN, REQUEST_COUNT  from USER_STATS  WHERE LOGIN  = '" + userStat.getLogin() +"';";
		return query;
	}

	public String createCreateQuery() {
		String query = "CREATE TABLE USER_STATS (LOGIN  VARCHAR(255), REQUEST_COUNT INT);";
		return query;
	}
 }