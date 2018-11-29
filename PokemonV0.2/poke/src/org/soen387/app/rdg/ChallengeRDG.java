package org.soen387.app.rdg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChallengeRDG extends BaseRDG {

	private String id;

	private String challenger;

	private String challengee;

	private String status;

	private int version;

	public ChallengeRDG() {
		super();
	}



	public ChallengeRDG(String id, String challenger, String challengee) {

		this.id = id;
		this.challenger = challenger;
		this.challengee = challengee;
		
		

	}

	public ChallengeRDG(String id, String challenger, String challengee, String status) {

		this.id = id;
		this.challenger = challenger;
		this.challengee = challengee;
		this.status = status;
	}

	public static int insert(ChallengeRDG challengeRDG) {

		if (challengeRDG == null) {
			return 0;
		}

		int num = excuteInsertSql(
				"INSERT INTO CHALLENGE(CHALLENGE.CHALLENGER,CHALLENGE.CHALLENGEE,"
						+ "CHALLENGE.STATUS) VALUES( ?, ?, ?)",
				challengeRDG.getChallenger(), challengeRDG.getChallengee(), challengeRDG.getStatus());

		return num;
	}

	public static int update(ChallengeRDG challengeRDG) {

		if (challengeRDG == null) {
			return 0;
		}

		int num = excuteInsertSql("UPDATE CHALLENGE SET CHALLENGE.STATUS = ?" + " WHERE CHALLENGE.CHALLENGE_ID = ?",
				challengeRDG.getStatus(), challengeRDG.getId());

		return num;
	}

	public static int delete(String id) {

		if (id == null) {
			return 0;
		}

		int num = excuteInsertSql("DELETE FROM CHALLENGE WHERE " + "CHALLENGE.CHALLENGE_ID = ?", id);

		return num;
	}

	public static ChallengeRDG findPlayers(String id) {

		ChallengeRDG challengeRDG = null;

		try {
			ResultSet resultSet = excuteSelSql(
					"SELECT CHALLENGE.CHALLENGER, CHALLENGE.CHALLENGEE FROM CHALLENGE WHERE CHALLENGE.CHALLENGE_ID = ?\r\n",
					id);
			if (resultSet.next()) {
				challengeRDG = new ChallengeRDG(id, resultSet.getString(1), resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return challengeRDG;
	}

	public static List<ChallengeRDG> findAllById(String userId) {

		List<ChallengeRDG> challengeRDG = new ArrayList<ChallengeRDG>();
		try {
			ResultSet resultSet = excuteSelSql("SELECT CHALLENGE.CHALLENGE_ID,CHALLENGE.CHALLENGER,"
					+ " CHALLENGE.CHALLENGEE,CHALLENGE.STATUS FROM CHALLENGE WHERE CHALLENGE.CHALLENGER = ? OR CHALLENGE.CHALLENGEE = ?",
					userId, userId);

			while (resultSet.next()) {
				challengeRDG.add(new ChallengeRDG(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return challengeRDG;
	}

	public static List<ChallengeRDG> findAllChallenge() {

		List<ChallengeRDG> challengeRDG = new ArrayList<ChallengeRDG>();
		try {
			ResultSet resultSet = excuteSelSql(
					"SELECT CHALLENGE.CHALLENGE_ID,CHALLENGE.CHALLENGER, CHALLENGE.CHALLENGEE,CHALLENGE.STATUS FROM CHALLENGE");

			while (resultSet.next()) {
				challengeRDG.add(new ChallengeRDG(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return challengeRDG;

	}

	public static ChallengeRDG getChallengeAccept(String userId) {

		ChallengeRDG challengeRDG = null;

		ResultSet resultSet = excuteSelSql(
				"SELECT CHALLENGE.CHALLENGE_ID,CHALLENGE.CHALLENGER, CHALLENGE.CHALLENGEE,CHALLENGE.STATUS FROM CHALLENGE "
						+ "WHERE (CHALLENGE.CHALLENGER = ? OR CHALLENGE.CHALLENGEE = ?) AND CHALLENGE.STATUS = 3 ORDER BY CHALLENGE_ID DESC limit 1",
				userId, userId);

		try {
			if (resultSet.next()) {
				challengeRDG = new ChallengeRDG(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return challengeRDG;
	}

	public static ChallengeRDG getChallengeByGameId(String gameId) {

		ChallengeRDG challengeRDG = null;

		ResultSet resultSet = excuteSelSql(
				"SELECT CHALLENGE.CHALLENGE_ID,CHALLENGE.CHALLENGER, CHALLENGE.CHALLENGEE,CHALLENGE.STATUS FROM CHALLENGE "
						+ "WHERE CHALLENGE.CHALLENGE_ID = ?",
				gameId);

		try {
			if (resultSet.next()) {
				challengeRDG = new ChallengeRDG(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return challengeRDG;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChallenger() {
		return challenger;
	}

	public void setChallenger(String challenger) {
		this.challenger = challenger;
	}

	public String getChallengee() {
		return challengee;
	}

	public void setChallengee(String challengee) {
		this.challengee = challengee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
