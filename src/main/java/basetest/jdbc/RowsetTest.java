/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author sandeepkumar
 */
public class RowsetTest {
    final public static String url = "jdbc:derby://localhost:1527/sample";
    final public static String username = "app";
    final public static String password = "app";
    final public static String query = "select * from myappuser";
    public static BufferedReader br;
    
    static {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //Connected RowSet - JdbcRowset
    public void go() throws SQLException {
        try(JdbcRowSet rs1 = RowSetProvider.newFactory().createJdbcRowSet()) {
            rs1.setUrl(url);
            rs1.setUsername(username);
            rs1.setPassword(password);
            rs1.setCommand(query);
            rs1.addRowSetListener(new RowSetListener() {
                @Override
                public void rowSetChanged(RowSetEvent event) {
                }

                @Override
                public void rowChanged(RowSetEvent event) {
                    try {
                        rs1.execute();
                    }
                    catch(SQLException sqlEx) {sqlEx.printStackTrace();}
                }

                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("------------------------------------------------");
                }
            });
            rs1.execute();
            while(rs1.next()) {
                System.out.println("User Id: " + rs1.getInt(1));
                System.out.println("Enabled: " + rs1.getInt(2));
                System.out.println("Login Name: " + rs1.getString(3));
                System.out.println("Login Password: " + rs1.getString(4));
                System.out.println("Role: " + rs1.getInt(5));
            }
            System.out.println("Is Last: " + rs1.isAfterLast());
            
            //Update a record
            rs1.first();
            rs1.updateInt(2, 1);
            rs1.updateRow();
            int id = 0;
            while(rs1.next()) {
                id = rs1.getInt(1);
                System.out.println("User Id: " + id);
                System.out.println("Enabled: " + rs1.getInt(2));
                System.out.println("Login Name: " + rs1.getString(3));
                System.out.println("Login Password: " + rs1.getString(4));
                System.out.println("Role: " + rs1.getInt(5));
            }
            
            //Insert a new record
            rs1.moveToInsertRow();
            rs1.updateInt(1, (id  + 1));
            rs1.updateInt(2, 1);
            rs1.updateString(3, ("u" + id));
            rs1.updateString(4, "p");
            rs1.updateInt(5, 3);
            rs1.insertRow();
            rs1.moveToCurrentRow();
            
            while(rs1.next()) {
                System.out.println("User Id: " + rs1.getInt(1));
                System.out.println("Enabled: " + rs1.getInt(2));
                System.out.println("Login Name: " + rs1.getString(3));
                System.out.println("Login Password: " + rs1.getString(4));
                System.out.println("Role: " + rs1.getInt(5));
            }
        }
    }
    
    //Disconnected RowSet - CachedRowSet
    public void go1() throws SQLException {
        try (CachedRowSet rs = RowSetProvider.newFactory().createCachedRowSet()) {
            rs.setUrl(url);
            rs.setUsername(username);
            rs.setPassword(password);
            rs.setCommand(query);
            rs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            rs.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
            rs.execute();
            rs.addRowSetListener(new RowSetListener() {
                @Override
                public void rowSetChanged(RowSetEvent event) {
                    System.out.println("RowSetChanged");
                }
                @Override
                public void rowChanged(RowSetEvent event) {
                    System.out.println("RowChanged");
                }
                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("-----------------------------------");
                }
            });
            rs.execute();
            int id = -1;
            while(rs.next()) {
                id = rs.getInt(1);
                System.out.println("User Id: " + id);
                System.out.println("Enabled: " + rs.getInt(2));
                System.out.println("Login Name: " + rs.getString(3));
                System.out.println("Login Password: " + rs.getString(4));
                System.out.println("Role: " + rs.getInt(5));
            }
            
            System.out.println("Database is going to be offline");
            try { br.read(); } catch(Exception e) { e.printStackTrace(); }

            rs.moveToInsertRow();
            rs.updateInt(1, (id  + 1));
            rs.updateInt(2, 1);
            rs.updateString(3, ("u" + id));
            rs.updateString(4, "p");
            rs.updateInt(5, 3);
            rs.insertRow();
            rs.moveToCurrentRow();

            System.out.println("Database is going to be online");
            try { br.read(); } catch(Exception e) { e.printStackTrace(); }
            rs.acceptChanges();
            
            rs.execute();
            while(rs.next()) {
                id = rs.getInt(1);
                System.out.println("User Id: " + id);
                System.out.println("Enabled: " + rs.getInt(2));
                System.out.println("Login Name: " + rs.getString(3));
                System.out.println("Login Password: " + rs.getString(4));
                System.out.println("Role: " + rs.getInt(5));
            }
        }
    }
    
    //Disconnected RowSet with XML reading/writing - WebRowSet
    public void go2() throws SQLException {
        try (WebRowSet rs = RowSetProvider.newFactory().createWebRowSet()) {
            rs.setUrl(url);
            rs.setUsername(username);
            rs.setPassword(password);
            rs.setCommand(query);
            rs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            rs.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
            rs.execute();
            rs.addRowSetListener(new RowSetListener() {
                @Override
                public void rowSetChanged(RowSetEvent event) {
                    System.out.println("RowSetChanged");
                }
                @Override
                public void rowChanged(RowSetEvent event) {
                    System.out.println("RowChanged");
                }
                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("-----------------------------------");
                }
            });
            rs.execute();
            int id = -1;
            while(rs.next()) {
                id = rs.getInt(1);
                System.out.println("User Id: " + id);
                System.out.println("Enabled: " + rs.getInt(2));
                System.out.println("Login Name: " + rs.getString(3));
                System.out.println("Login Password: " + rs.getString(4));
                System.out.println("Role: " + rs.getInt(5));
            }
            
            System.out.println("Database is going to be offline");
            try { rs.writeXml(System.out); br.read(); } catch(Exception e) { e.printStackTrace(); }
        }
    }
    
    //Disconnected RowSet with Data filtering using Predicate interface - FilteredRowSet
    public void go3() throws SQLException {
        try (FilteredRowSet rs = RowSetProvider.newFactory().createFilteredRowSet()) {
            rs.setUrl(url);
            rs.setUsername(username);
            rs.setPassword(password);
            rs.setCommand(query);
            rs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            rs.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
            rs.execute();
            rs.addRowSetListener(new RowSetListener() {
                @Override
                public void rowSetChanged(RowSetEvent event) {
                    System.out.println("RowSetChanged");
                }
                @Override
                public void rowChanged(RowSetEvent event) {
                    System.out.println("RowChanged");
                }
                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("-----------------------------------");
                }
            });
            rs.execute();
            
            rs.setFilter(new Predicate() {
                @Override
                public boolean evaluate(RowSet rs) {
                    //select first column and match value between 1-5
                    try {
                        if(rs.getInt(1) >= 5 && rs.getInt(1) <= 10) {
                            return true;
                        }
                    }
                    catch(SQLException ex) {
                        ex.printStackTrace();
                    }
                    return false;
                }

                @Override
                public boolean evaluate(Object value, int column) throws SQLException {
                    //select first column and match value between 1-5
                    boolean retValue = false;
                    //if(column == 1) {
                    //    if(null != value && Long.valueOf(value.toString()) >= 5 && Long.valueOf(value.toString()) <= 10) {
                    //        retValue = true;
                    //    }
                    //}
                    return retValue;
                }

                @Override
                public boolean evaluate(Object value, String columnName) throws SQLException {
                    return false;
                }
            });
            int id = -1;
            while(rs.next()) {
                id = rs.getInt(1);
                System.out.println("User Id: " + id);
                System.out.println("Enabled: " + rs.getInt(2));
                System.out.println("Login Name: " + rs.getString(3));
                System.out.println("Login Password: " + rs.getString(4));
                System.out.println("Role: " + rs.getInt(5));
            }
            
            System.out.println("Database is going to be offline");
            try { br.read(); } catch(Exception e) { e.printStackTrace(); }
        }
    }
    
    //Disconnected RowSet with Joinable - 
    public void go4() throws SQLException {
        try (CachedRowSet crs1 = RowSetProvider.newFactory().createCachedRowSet(); CachedRowSet crs2 = RowSetProvider.newFactory().createCachedRowSet(); JoinRowSet rs = RowSetProvider.newFactory().createJoinRowSet()) {
            crs1.setUrl(url);
            crs1.setUsername(username);
            crs1.setPassword(password);
            crs1.setCommand(query);
            crs1.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            crs1.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
            crs1.execute();

            crs2.setUrl(url);
            crs2.setUsername(username);
            crs2.setPassword(password);
            crs2.setCommand("select * from myapproles");
            crs2.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            crs2.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
            crs2.execute();

            rs.addRowSet(crs1, 5);
            rs.addRowSet(crs2, 1);
            rs.setJoinType(JoinRowSet.INNER_JOIN);

            rs.addRowSetListener(new RowSetListener() {
                @Override
                public void rowSetChanged(RowSetEvent event) {
                    System.out.println("RowSetChanged");
                }
                @Override
                public void rowChanged(RowSetEvent event) {
                    System.out.println("RowChanged");
                }
                @Override
                public void cursorMoved(RowSetEvent event) {
                    System.out.println("-----------------------------------");
                }
            });
            
            int id = -1;
            while(rs.next()) {
                id = rs.getInt(1);
                System.out.println("T1 User Id: " + id);
                System.out.println("T1 Enabled: " + rs.getInt(2));
                System.out.println("T1 Login Name: " + rs.getString(3));
                System.out.println("T1 Login Password: " + rs.getString(4));
                System.out.println("T1 Role: " + rs.getInt(5));
                System.out.println("T2 Role Name: " + rs.getString(6));
            }
            
            System.out.println("Database is going to be offline");
            try { br.read(); } catch(Exception e) { e.printStackTrace(); }
        }
    }
    
    public static void main(String...args) throws SQLException {
        RowsetTest test = new RowsetTest();
        test.go4();
    }
}
