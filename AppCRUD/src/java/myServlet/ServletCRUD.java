/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.BukuDao;
import Bean.Buku;
import javax.servlet.RequestDispatcher;
public class ServletCRUD extends HttpServlet {
private static String Insert = "/buku.jsp";
private static String Edit = "/edit.jsp";
private static String ListBuku = "/listBuku.jsp";
private BukuDao bukuDao;
public ServletCRUD (){
super();
bukuDao = new BukuDao();
}
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String redirectURL="";
String id_buku = request.getParameter("id_buku");
System.out.println("ID Buku"+id_buku);
String act=request.getParameter("action");
if(id_buku != null && act.equalsIgnoreCase("insert")){
int id = Integer.parseInt(id_buku);
Buku buku = new Buku();
buku.setBukuID(id);

buku.setJudul(request.getParameter("judul"));
buku.setPengarang(request.getParameter("pengarang"));
buku.setPenerbit(request.getParameter("penerbit"));
buku.setJumlah(Integer.parseInt(request.getParameter("jumlah")));
bukuDao.addBuku(buku);
redirectURL = ListBuku;
request.setAttribute("bukus", bukuDao.retrieveBuku());
System.out.println("Record Added Successfully");
} else if(act.equalsIgnoreCase("delete")) {
int id = Integer.parseInt(id_buku);
bukuDao.deleteBukuById(id);
redirectURL = ListBuku;
request.setAttribute("bukus", bukuDao.retrieveBuku());
System.out.println("Record Deleted Successfully");
} else if(act.equalsIgnoreCase("retrieve")){
redirectURL = ListBuku;
request.setAttribute("bukus", bukuDao.retrieveBuku());
}else if (act.equalsIgnoreCase("editform")){
redirectURL = Edit;
} else if(act.equalsIgnoreCase("update")){
System.out.println("Im Here" +id_buku);
int id = Integer.parseInt(id_buku);
Buku buku = new Buku();
buku.setBukuID(id);
buku.setJudul(request.getParameter("judul"));
buku.setPengarang(request.getParameter("pengarang"));
buku.setPenerbit(request.getParameter("penerbit"));
buku.setJumlah(Integer.parseInt(request.getParameter("jumlah")));
bukuDao.editBuku(buku);
request.setAttribute("buku", buku);
redirectURL = ListBuku;
System.out.println("Record updated Successfully");
} else {
redirectURL= Insert;
}
RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
rd.forward(request, response);
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}
@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>
}