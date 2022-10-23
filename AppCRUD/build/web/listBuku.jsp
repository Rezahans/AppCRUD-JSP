<%-- 
    Document   : listBuku
    Created on : Jul 5, 2022, 9:55:42 PM
    Author     : TUF
--%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Bean.Buku"%>
<%@page import="DAO.BukuDao"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Buku</title>
</head>
<body>
<%
BukuDao bukuDao = new BukuDao();
List <Buku> listBuku = bukuDao.retrieveBuku();
%>
<table border="1">
<tr>
<th>ID Buku</th>
<th>Judul Buku</th>
<th>Pengarang Buku</th>
<th>Penerbit</th>
<th>Jumlah Buku</th>

<th colspan="2"> Action </th>
</tr>
<tr>
<%
    for (Buku buku : listBuku) {
%>
<td><%=buku.getBukuID() %></td>
<td><%=buku.getJudul() %></td>
<td><%= buku.getPengarang() %></td>
<td><%= buku.getPenerbit() %></td>
<td><%= buku.getJumlah()%></td>
<td><a href="ServletCRUD?action=editform&id_buku=<%=buku.getBukuID() %>">Update</a></td>
<td><a href="ServletCRUD?action=delete&id_buku=<%=buku.getBukuID() %>">Delete</a></td>
</tr>
<%
}
%>
</table>
<p><a href="ServletCRUD?action=insert">Add Buku</a></p>
</body>