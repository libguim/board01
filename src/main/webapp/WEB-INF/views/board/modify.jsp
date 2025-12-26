<%@page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8" %>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-content">
    <div class="card">
        <div class="card-body">
            <div class="card-title">게시글 수정</div>
            <form>
                <div class="mb-3">
                    <label for="bno" class="form-label">Bno</label>
                    <input type="text" class="form-control" name="bno" id="bno" value="${board.bno}" readonly>
                </div>
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" name="title" id="title" value="${board.title}">
                </div>
                <div class="mb-3">
                    <label for="writer" class="form-label">Writer</label>
                    <input type="text" class="form-control" name="writer" id="writer" value="${board.writer}" readonly>
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">Content</label>
                    <textarea class="form-control" name="content" id="content" rows="3">${board.content}</textarea>
                </div>
                <div class="mb-3">
                    <label for="postdate" class="form-label">PostDate</label>
                    <input type="text" class="form-control" value="${board.postdate}">
                </div>
                <div class="mb-3">
                    <label for="readcount" class="form-label">ReadCount</label>
                    <input type="text" class="form-control" name="readcount" id="readcount" value="${board.readcount}" readonly>
                </div>
                <button type="button" class="btn btn-outline-danger">Remove</button>
                <button type="button" class="btn btn-outline-primary">Modify</button>
                <button type="button" class="btn btn-outline-secondary">List</button>
            </form>

            <script>
                const formObj = document.querySelector("form")
                document.querySelector(".btn-outline-danger").addEventListener("click",function(e) {

                    e.preventDefault()
                    e.stopPropagation()

                    if (!confirm("정말 삭제하시겠습니까?")) {
                        // 사용자가 '취소'를 눌렀을 경우 함수 종료 (아무 일도 일어나지 않음)
                        return;
                    }

                    formObj.action ="/board/remove"
                    formObj.method ="get"

                    formObj.submit()

                },false);

                document.querySelector(".btn-outline-primary").addEventListener("click",function(e) {

                    e.preventDefault()
                    e.stopPropagation()

                    formObj.action =`/board/modify?bno=${board.bno}`
                    formObj.method ="post"

                    formObj.submit()

                },false);

                document.querySelector(".btn-outline-secondary").addEventListener("click",function(e) {

                    e.preventDefault()
                    e.stopPropagation()

                    self.location = "/board/list"
                    // formObj.action ="/board/list"
                    // formObj.method ="post"

                },false);

            </script>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>

