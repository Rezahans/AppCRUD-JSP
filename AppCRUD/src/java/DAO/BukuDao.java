/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import Bean.Buku;
import java.util.logging.Level;
import java.util.logging.Logger;
import myUtil.ConnectionDB;
public class BukuDao {
    
private final Connection conn;
public BukuDao(){
conn = ConnectionDB.getConnectionDB();
}

public void addBuku(Buku buku){

try {
String SQLInsert ="INSERT INTO tbl_buku(id_buku, judul_buku, pengarang, penerbit, jumlah) values (?, ?, ?, ?, ?)";
PreparedStatement prSt = conn.prepareStatement(SQLInsert);
prSt.setInt(1, buku.getBukuID());
prSt.setString(2, buku.getJudul());
prSt.setString(3, buku.getPengarang());
prSt.setString(4, buku.getPenerbit());
prSt.setInt(5, buku.getJumlah());
prSt.executeUpdate();
} catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}
public void deleteBukuById(int bukuID){
try {
String deleteQuery="delete from tbl_buku where id_buku=?";
PreparedStatement prSt = conn.prepareStatement(deleteQuery);
prSt.setInt(1, bukuID);
prSt.executeUpdate();
} catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}
public Buku findBukuById(int bukuID){
Buku buku = new Buku();
try {
String deleteQuery="select * from tbl_buku where id_buku=?";
PreparedStatement prSt = conn.prepareStatement(deleteQuery);
prSt.setInt(1, bukuID);
ResultSet rs = prSt.executeQuery();
while(rs.next()){
buku.setBukuID(bukuID);
buku.setJudul(rs.getString(2));
buku.setPengarang(rs.getString(3));
buku.setPenerbit(rs.getString(4));
buku.setJumlah(rs.getInt(5));

}
} catch (SQLException ex) {
System.out.println(ex.getMessage());
}
return buku;
}

public void editBuku(Buku buku){
try {
String editQuery="update tbl_buku set judul_buku=?, pengarang=?, penerbit=?, jumlah=? where id_buku=?";
PreparedStatement prSt = conn.prepareStatement(editQuery);
prSt.setString(1, buku.getJudul());
prSt.setString(2, buku.getPengarang());
prSt.setString(3, buku.getPenerbit());
prSt.setInt(4, buku.getJumlah());
prSt.setInt(5, buku.getBukuID());
prSt.executeUpdate();
} catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}
public List retrieveBuku(){
List sbuku = new ArrayList();
try {
String retrieveQuery = "select * from tbl_buku";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(retrieveQuery);
while(rs.next()){
Buku buku = new Buku();
buku.setBukuID(rs.getInt(1));
buku.setJudul(rs.getString(2));
buku.setPengarang(rs.getString(3));
buku.setPenerbit(rs.getString(4));
buku.setJumlah(rs.getInt(5));
sbuku.add(buku);

}
} catch (SQLException ex) {
Logger.getLogger(BukuDao.class.getName()).log(Level.SEVERE, null, ex);
}
return sbuku;
}
}
