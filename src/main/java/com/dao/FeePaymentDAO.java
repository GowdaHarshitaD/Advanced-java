package com.dao;

import java.sql.*;
import java.util.*;
import com.model.FeePayment;

public class FeePaymentDAO {

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college_fee_db",
                "root",
                "password"
            );
        } catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public int addPayment(FeePayment p) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO FeePayments(StudentID, StudentName, PaymentDate, Amount, Status) VALUES(?,?,?,?,?)"
            );
            ps.setString(1, p.getStudentId());
            ps.setString(2, p.getStudentName());
            ps.setDate(3, p.getPaymentDate());
            ps.setDouble(4, p.getAmount());
            ps.setString(5, p.getStatus());

            status = ps.executeUpdate();
        } catch(Exception e) { e.printStackTrace(); }
        return status;
    }

    public int updatePayment(FeePayment p) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE FeePayments SET StudentID=?,StudentName=?,PaymentDate=?,Amount=?,Status=? WHERE PaymentID=?"
            );
            ps.setString(1, p.getStudentId());
            ps.setString(2, p.getStudentName());
            ps.setDate(3, p.getPaymentDate());
            ps.setDouble(4, p.getAmount());
            ps.setString(5, p.getStatus());
            ps.setInt(6, p.getPaymentId());

            status = ps.executeUpdate();
        } catch(Exception e) { e.printStackTrace(); }
        return status;
    }

    public int deletePayment(int id) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM FeePayments WHERE PaymentID=?"
            );
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch(Exception e) { e.printStackTrace(); }
        return status;
    }

    public List<FeePayment> getAllPayments() {

        List<FeePayment> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM FeePayments");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                FeePayment p = new FeePayment();
                p.setPaymentId(rs.getInt(1));
                p.setStudentId(rs.getString(2));
                p.setStudentName(rs.getString(3));
                p.setPaymentDate(rs.getDate(4));
                p.setAmount(rs.getDouble(5));
                p.setStatus(rs.getString(6));

                list.add(p);
            }
        } catch(Exception e) { e.printStackTrace(); }

        return list;
    }
}