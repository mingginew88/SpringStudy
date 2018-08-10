<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<div class="row">
		<div class="col-sm-8 blog-main">
			<h2 class="sub-header">학생</h2>
			<div class="table-responsive">
				<h3>학생 전체 조회</h3>								
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>학생 ID	</th>
							<th>학생 이름	</th>
							<th>지명 횟수	</th>
							<th>등록 일자(yyyy-mm-dd)	</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${studentList}" var="vo">
					<%--tr태그 클릭시 상세페이지로 이동 --%>
							<tr data-id="${vo.id}" data-name="${vo.name}">
								<td>${vo.id}		</td>
								<td>${vo.name}		</td>
								<td>${vo.call_cnt}	</td>
								<td><fmt:formatDate value="${vo.reg_dt}" pattern="yyyy-MM-dd"/>	</td>
							</tr>		
						</c:forEach>
					</tbody>
				</table>
			</div>

			<a class="btn btn-default pull-right">사용자 등록</a>

			<div class="text-center">
				<ul class="pagination">
					<li>${pageNavi}</li>
				</ul>
			</div>
		</div>
	</div>
	
