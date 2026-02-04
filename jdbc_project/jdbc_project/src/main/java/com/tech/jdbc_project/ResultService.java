package com.tech.jdbc_project;

import java.sql.*;

public class ResultService {
    String[] rid = new String[100];
    String[] sid = new String[100];
    int[] m1Arr = new int[100];
    int[] m2Arr = new int[100];
    int[] m3Arr = new int[100];
    int[] totalArr = new int[100];
    double[] percArr = new double[100];
    String[] gradeArr = new String[100];

    int rcount = 0;

    private String calc(double p) {
        if (p >= 75) return "A";
        if (p >= 60) return "B";
        if (p >= 50) return "C";
        if (p >= 35) return "D";
        return "F";
    }

    public void loadResults() {
        rcount = 0;
        try {
            Connection conn = DBUtil.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM results");

            while (rs.next()) {
                rid[rcount] = rs.getString(1);
                sid[rcount] = rs.getString(2);
                m1Arr[rcount] = rs.getInt(3);
                m2Arr[rcount] = rs.getInt(4);
                m3Arr[rcount] = rs.getInt(5);
                totalArr[rcount] = rs.getInt(6);
                percArr[rcount] = rs.getDouble(7);
                gradeArr[rcount] = rs.getString(8);
                rcount++;
            }

        } catch (Exception e) { }
    }

    public boolean addResult(String rid1, String sid1, int m1, int m2, int m3) {
        try {
            int t = m1 + m2 + m3;
            double p = t / 300.0 * 100;
            String g = calc(p);

            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO results VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, rid1);
            ps.setString(2, sid1);
            ps.setInt(3, m1);
            ps.setInt(4, m2);
            ps.setInt(5, m3);
            ps.setInt(6, t);
            ps.setDouble(7, p);
            ps.setString(8, g);

            ps.executeUpdate();
            loadResults();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public void viewResults() {
        loadResults();
        if (rcount == 0) {
            System.out.println("No results found.");
            return;
        }
        for (int i = 0; i < rcount; i++) {
            System.out.println(
                rid[i] + " | " + sid[i] + " | " +
                m1Arr[i] + "," + m2Arr[i] + "," + m3Arr[i] +
                " | Total:" + totalArr[i] +
                " | %:" + percArr[i] +
                " | Grade:" + gradeArr[i]
            );
        }
    }

    public boolean updateResult(String rid1, int m1, int m2, int m3) {
        try {
            int t = m1 + m2 + m3;
            double p = t / 300.0 * 100;
            String g = calc(p);

            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE results SET marks1=?, marks2=?, marks3=?, total=?, percentage=?, grade=? WHERE id=?"
            );

            ps.setInt(1, m1);
            ps.setInt(2, m2);
            ps.setInt(3, m3);
            ps.setInt(4, t);
            ps.setDouble(5, p);
            ps.setString(6, g);
            ps.setString(7, rid1);

            ps.executeUpdate();
            loadResults();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteResult(String rid1) {
        try {
            Connection conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM results WHERE id=?"
            );
            ps.setString(1, rid1);
            ps.executeUpdate();
            loadResults();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
