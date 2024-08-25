package org.example.servlettest.dao;

import org.example.servlettest.model.Role;
import org.example.servlettest.model.User;
import org.example.servlettest.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RoleDaoImpl implements RoleDAO {

    public static  final String Y = "Y";
//    private final Role roleID = ;

    @Override
    public Role findById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Role role = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt = conn.prepareStatement("SELECT id, name, description FROM roles where id = ?");
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if(rs.next()){
                role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

    @Override
    public Role findByUser(User user) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Role role = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt = conn.prepareStatement("SELECT id, name, description FROM roles where id = ?");
            pstmt.setInt(1, user.getId());

            rs = pstmt.executeQuery();
            if(rs.next()){
                role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

//    @Override
//    public Set<User> findAll() {
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        Set<User> users = new HashSet<>();
//
//        try (Connection conn = DBUtils.getConnection()) {
//            pstmt = conn.prepareStatement(String.format("SELECT * FROM users"));
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getInt(1));
//                user.setName(rs.getString(2));
//                user.setEmail(rs.getString(3));
//                user.setPassword(rs.getString(4));
//                user.setActive(rs.getString(5).equals("Y"));
//                user.setCreatedTs(rs.getTimestamp(6));
//                user.setUpdatedTs(rs.getTimestamp(7));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("FindAll Exception", e);
//        } finally {
//            DBUtils.close(null, null, pstmt, rs);
//        }
//
//
//        return users;
//    }


}
