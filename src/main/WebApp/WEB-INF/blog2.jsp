<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>USER</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
  </head>

  <body>
  	<div class="page-header">
  		<div class="pull-left">
  			Welcome ${logged_user}! This is your blog!
  			<a href="/logout" class="btn btn-primary">Logout</a>
  			<div><a href="/addNewBlog" class="btn btn-primary">Add New Text!</a><div>
  		</div>
  		<div class="clearfix"></div>
  	</div>
  	<form class="form-horizontal" role="form" method="post" action="addBlog">
    			<div class="form-group">
    <div>
    				 <table class="table table-striped">
                                <tr>
                                    <th>Text</th>
                                    <th>Actions</th>

                                </tr>
                                <c:forEach items="${blog}" var="blog">
                                    <tr>
                                        <td><c:out value="${blog.text}" /></td>

                                        <td>
                                            <a href="<c:url value="/blog/${blog.id}/edit"/> " class="btn btn-info">Edit</a>
                                            <a href="<c:url value="/blog/${blog.id}/delete"/> " class="btn btn-danger">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                        </table>




    			</div>

    		</form>

  </body>
</html>
