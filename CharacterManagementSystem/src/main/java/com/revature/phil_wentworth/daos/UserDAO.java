package com.revature.phil_wentworth.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.phil_wentworth.models.User;
import com.revature.phil_wentworth.util.ConnectionFactory;
import com.revature.phil_wentworth.util.MyArrayList;
import com.revature.phil_wentworth.util.MyList;

public class UserDAO implements CrudDAO<User> {

	@Override
	public User create(User newObj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into users (email, username, password) values (?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newObj.getEmail());
			ps.setString(2, newObj.getUsername());
			ps.setString(3, newObj.getPassword());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newObj;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public MyList<User> findAll() {
		MyList<User> usersList = new MyArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				User user = new User();
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));

				usersList.add(user);
			}

			return usersList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User findById(String id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet resultSet = ps.executeQuery(sql);

			while (resultSet.next()) {
				User user = new User();
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findByUsername(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet resultSet = ps.executeQuery(sql);

			while (resultSet.next()) {
				User user = new User();
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet resultSet = ps.executeQuery(sql);

			while (resultSet.next()) {
				User user = new User();
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(User updatedObj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update users set email = ?, username = ?, password = ? where email = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, updatedObj.getEmail());
			ps.setString(2, updatedObj.getUsername());
			ps.setString(3, updatedObj.getPassword());
			ps.setString(4, updatedObj.getEmail());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated != 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(String id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "delete from users where email = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, id);

			int rowsDeleted = ps.executeUpdate();

			if (rowsDeleted != 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
