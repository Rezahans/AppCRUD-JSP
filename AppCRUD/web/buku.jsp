<%-- 
    Document   : buku
    Created on : Jul 5, 2022, 9:53:34 PM
    Author     : Reza Hans 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Buku</title>
</head>
<body>
<form method="POST" action='ServletCRUD' name="frmAddUser">
<input type="hidden" name="action" value="insert" />
<p><b>Add New Record</b></p>
<table>
<tr>
<td>ID Buku</td>
<td><input type="text" name="id_buku" /></td>
</tr>
<tr>
<td>Judul Buku</td>
<td><input type="text" name="judul" /></td>
</tr>
<tr>
<td>Pengarang</td>
<td><input type="text" name="pengarang" /></td>
</tr>
<tr>
<td>Penerbit</td>
<td><input type="text" name="penerbit" /></td>
</tr>
<tr>
<td>Jumlah</td>
<td><input type="text" name="jumlah" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" /></td>
</tr>
</table>
</form>
<p><a href="ServletCRUD?action=retrieve">View-All-Records</a></p>
</body>
</html>
