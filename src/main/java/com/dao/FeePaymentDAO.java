package com.dao;

import java.sql.*;
import java.util.*;
import com.model.FeePayment;

public class FeePaymentDAO {

    // ✅ DATABASE CONNECTION
    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/college_fee_db?useSSL=false&serverTimezone=UTC",
                "root",
                "password"
            );

        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    // ✅ ADD PAYMENT
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

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ✅ UPDATE PAYMENT
    public int updatePayment(FeePayment p) {
        int status = 0;

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE FeePayments SET StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? WHERE PaymentID=?"
            );

            ps.setString(1, p.getStudentId());
            ps.setString(2, p.getStudentName());
            ps.setDate(3, p.getPaymentDate());
            ps.setDouble(4, p.getAmount());
            ps.setString(5, p.getStatus());
            ps.setInt(6, p.getPaymentId());

            status = ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ✅ DELETE PAYMENT
    public int deletePayment(int id) {
        int status = 0;

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM FeePayments WHERE PaymentID=?"
            );

            ps.setInt(1, id);

            status = ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ✅ GET ALL PAYMENTS (VERY IMPORTANT — fixes your error)
    public List<FeePayment> getAllPayments() {

        List<FeePayment> list = new ArrayList<>();

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM FeePayments"
            );

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                FeePayment p = new FeePayment();

                p.setPaymentId(rs.getInt("PaymentID"));
                p.setStudentId(rs.getString("StudentID"));
                p.setStudentName(rs.getString("StudentName"));
                p.setPaymentDate(rs.getDate("PaymentDate"));
                p.setAmount(rs.getDouble("Amount"));
                p.setStatus(rs.getString("Status"));

                list.add(p);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ GET PAYMENTS BY STATUS (FOR TABS)
    public List<FeePayment> getPaymentsByStatus(String statusValue) {

        List<FeePayment> list = new ArrayList<>();

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM FeePayments WHERE Status=?"
            );

            ps.setString(1, statusValue);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                FeePayment p = new FeePayment();

                p.setPaymentId(rs.getInt("PaymentID"));
                p.setStudentId(rs.getString("StudentID"));
                p.setStudentName(rs.getString("StudentName"));
                p.setPaymentDate(rs.getDate("PaymentDate"));
                p.setAmount(rs.getDouble("Amount"));
                p.setStatus(rs.getString("Status"));

                list.add(p);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ TOTAL COLLECTION (FOR REPORTS)
    public double getTotalCollection(String from, String to) {

        double total = 0;

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT SUM(Amount) FROM FeePayments WHERE PaymentDate BETWEEN ? AND ?"
            );

            ps.setString(1, from);
            ps.setString(2, to);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                total = rs.getDouble(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}