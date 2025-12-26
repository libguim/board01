<%@page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8" %>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-content">
    <div class="card">
        <div class="card-body">
            <div class="card-title">게시글 등록</div>
            <form method="post" action="/board/register">
                <div class="mb-3">
                    <label for="bno" class="form-label">Bno</label>
                    <input type="hidden" class="form-control" name="bno" id="bno" value="${board.bno}" readonly>
                </div>
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" name="title" id="title" value="${board.title}" readonly>
                </div>
                <div class="mb-3">
                    <label for="writer" class="form-label">Writer</label>
                    <input type="text" class="form-control" name="writer" id="writer" value="${board.writer}" readonly>
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">Content</label>
                    <textarea class="form-control" name="content" id="content" rows="3" readonly>${board.content}</textarea>
                </div>
                <div class="mb-3">
                    <label for="postdate" class="form-label">PostDate</label>
                    <input type="text" class="form-control" name="postdate" id="postdate" value="${board.postdate}" readonly>
                </div>
                <div class="mb-3">
                    <label for="readcount" class="form-label">ReadCount</label>
                    <input type="text" class="form-control" name="readcount" id="readcount" value="${board.readcount}" readonly>
                </div>
                <button type="button" class="btn btn-outline-primary">Modify</button>
                <button type="button" class="btn btn-outline-secondary">List</button>
            </form>

            <script>
                document.querySelector(".btn-outline-primary").addEventListener("click", function(e){
                    self.location = `/board/modify?bno=${board.bno}`
                },false)

                document.querySelector(".btn-outline-secondary").addEventListener("click", function(e){
                    self.location = "/board/list";
                },false)
            </script>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>

