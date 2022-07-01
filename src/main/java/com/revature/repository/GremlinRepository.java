package com.revature.repository;

import com.revature.model.Color;
import com.revature.model.Gremlin;
import com.revature.utlis.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GremlinRepository implements DAO<Gremlin> {

    @Override
    public Gremlin create(Gremlin gremlin) {
        String sql = "insert into gremlins(name, age, color_id, is_evil) values(?,?,?,?)";

        // try with resources to auto close connection
        try(Connection connection = ConnectionUtility.getInstance()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gremlin.getName());
            statement.setInt(2, gremlin.getAge());
            statement.setInt(3, gremlin.getColor().ordinal());
            statement.setBoolean(4, gremlin.isEvil());

            if(statement.executeUpdate() == 1) {
                return gremlin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Gremlin> getAll() {
        List<Gremlin> gremlins = new ArrayList<>();

        String sql = "select * from gremlins";

        try(Connection connection = ConnectionUtility.getInstance()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                gremlins.add(new Gremlin()
                        .setId(rs.getInt("gremlin_id"))
                        .setName(rs.getString("name"))
                        .setAge(rs.getInt("age"))
                        .setColor(Color.values()[rs.getInt("color_id")])
                        .setEvil(rs.getBoolean("is_evil")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gremlins;
    }
}
