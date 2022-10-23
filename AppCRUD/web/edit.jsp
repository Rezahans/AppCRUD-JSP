<%-- 
    Document   : edit
    Created on : Jul 5, 2022, 9:54:23 PM
    Author     : TUF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Bean.Buku"%>
<%@page import="DAO.BukuDao"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Buku</title>
</head>
<body>
<%
Buku buku = new Buku();
BukuDao bukuDao = new BukuDao();
%>
<form method="POST" action='ServletCRUD' name="frmEditBuku">
<input type="hidden" name="action" value="update" />

<%
String id_buku = request.getParameter("id_buku");
if (!((id_buku) == null)) {
int id = Integer.parseInt(id_buku);
buku = bukuDao.findBukuById(id);
%>
<table>
<tr>
<td>ID Buku</td>
<td><input type="text" name="id_buku" readonly="readonly" value="<%=buku.getBukuID()
%>"></td>
</tr>
<tr>
<td>Judul Buku</td>
<td><input type="text" name="judul" value="<%=buku.getJudul()%>"></td>
</tr>
<tr>
<td>Pengarang</td>
<td><input type="text" name="pengarang" value="<%=buku.getPengarang()%>"></td>
</tr>
<tr>
<td>Penerbit</td>
<td><input type="text" name="penerbit" value="<%=buku.getPenerbit()%>"></td>
</tr>
<tr>
<td>Jumlah</td>
<td><input type="text" name="jumlah" value="<%=buku.getJumlah()%>"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Update" /></td>
</tr>
</table>
<%
} else
out.println("ID Not Found");
%>
</form>
</body>
</html