package com.revature.phil_wentworth.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.util.ConnectionFactory;
import com.revature.phil_wentworth.util.MyArrayList;
import com.revature.phil_wentworth.util.MyList;
import com.revature.phil_wentworth.util.logging.Logger;

public class MyCharacterDAO implements CrudDAO<MyCharacter> {
	private Logger logger = Logger.getLogger(false);
	
	@Override
	public MyCharacter create(MyCharacter newObj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into my_characters (character_name, user_email, stat0, stat1, stat2, stat3, stat4, stat5) values (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			int[] stats = newObj.getStatistics();

			ps.setString(1, newObj.getCharacterName());
			ps.setString(2, newObj.getUserEmail());
			ps.setInt(3, stats[0]);
			ps.setInt(4, stats[1]);
			ps.setInt(5, stats[2]);
			ps.setInt(6, stats[3]);
			ps.setInt(7, stats[4]);
			;
			ps.setInt(8, stats[5]);

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				logger.log("MyCharacterDAO Created MyCharacter object ");
				logger.log(newObj.toString());
				return newObj;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log("MyCharacterDAO.create failed due to SQLException: " + e.getStackTrace());
		}

		return null;
	}

	@Override
	public MyList<MyCharacter> findAll() {
		MyList<MyCharacter> charactersList = new MyArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select id, character_name, user_email, stat0, stat1, stat2, stat3, stat4, stat5 from my_characters";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				MyCharacter c = new MyCharacter();
				c.setId(resultSet.getInt("id"));
				c.setCharacterName(resultSet.getString("character_name"));
				c.setUserEmail(resultSet.getString("user_email"));
				c.setStatistic(0, resultSet.getInt("stat0"));
				c.setStatistic(1, resultSet.getInt("stat1"));
				c.setStatistic(2, resultSet.getInt("stat2"));
				c.setStatistic(3, resultSet.getInt("stat3"));
				c.setStatistic(4, resultSet.getInt("stat4"));
				c.setStatistic(5, resultSet.getInt("stat5"));
				charactersList.add(c);
			}

			logger.log("MyCharacterDAO.findAll returning successfully with full list of MyCharacter objects");
			return charactersList;

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log("MyCharacterDAO.findAll failed due to SQLException: " + e.getStackTrace());
		}

		return null;
	}

	public MyList<MyCharacter> getMyCharactersByEmail(String id) {
		MyList<MyCharacter> charactersList = new MyArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select id, character_name, user_email, stat0, stat1, stat2, stat3, stat4, stat5 from my_characters where user_email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				MyCharacter c = new MyCharacter();
				c.setId(resultSet.getInt("id"));
				c.setCharacterName(resultSet.getString("character_name"));
				c.setUserEmail(resultSet.getString("user_email"));
				c.setStatistic(0, resultSet.getInt("stat0"));
				c.setStatistic(1, resultSet.getInt("stat1"));
				c.setStatistic(2, resultSet.getInt("stat2"));
				c.setStatistic(3, resultSet.getInt("stat3"));
				c.setStatistic(4, resultSet.getInt("stat4"));
				c.setStatistic(5, resultSet.getInt("stat5"));
				charactersList.add(c);
			}

			logger.log("MyCharacterDAO.getMyCharactersByEmail returning successfully with approprate list of MyCharacter objects");
			return charactersList;

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log("MyCharacterDAO.getCharacterByEmail failed due to SQLException: " + e.getStackTrace());
		}

		return null;
	}

	@Override
	public MyCharacter findById(String id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select id, character_name, user_email, stat0, stat1, stat2, stat3, stat4, stat5 from my_characters where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				MyCharacter c = new MyCharacter();
				c.setId(resultSet.getInt("id"));
				c.setCharacterName(resultSet.getString("character_name"));
				c.setUserEmail(resultSet.getString("user_email"));
				c.setStatistic(0, resultSet.getInt("stat0"));
				c.setStatistic(1, resultSet.getInt("stat1"));
				c.setStatistic(2, resultSet.getInt("stat2"));
				c.setStatistic(3, resultSet.getInt("stat3"));
				c.setStatistic(4, resultSet.getInt("stat4"));
				c.setStatistic(5, resultSet.getInt("stat5"));
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log("MyCharacterDAO.findById failed due to SQLException: " + e.getStackTrace());
		}
		return null;
	}

	@Override
	public boolean update(MyCharacter updatedObj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update my_characters set character_name = ?, user_email = ?, stat0 = ?, stat1 = ?, stat2 = ?, stat3 = ?, stat4 = ?, stat5 = ? where id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			int[] stats = updatedObj.getStatistics();

			ps.setString(1, updatedObj.getCharacterName());
			ps.setString(2, updatedObj.getUserEmail());
			ps.setInt(3, stats[0]);
			ps.setInt(4, stats[1]);
			ps.setInt(5, stats[2]);
			ps.setInt(6, stats[3]);
			ps.setInt(7, stats[4]);
			ps.setInt(8, stats[5]);
			ps.setInt(9, updatedObj.getId());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				logger.log("MyCharacterDAO Updated MyCharacter object ");
				logger.log(updatedObj.toString());
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log("MyCharacterDAO.update failed due to SQLException: " + e.getStackTrace());
		}

		return false;
	}

	@Override
	public boolean delete(String id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "delete from my_characters where id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, Integer.parseInt(id));

			int rowsDeleted = ps.executeUpdate();

			if (rowsDeleted != 0) {
				logger.log("MyCharacterDAO Deleted MyCharacter object id " + id);
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.log("MyCharacterDAO.delete failed due to SQLException: " + e.getStackTrace());
		}

		return false;
	}

}
