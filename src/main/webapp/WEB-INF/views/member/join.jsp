<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="../includes/header.jsp" %>

<div class="container">
  <h2>회원가입</h2>
  <form action="#" method="post">
    <div class="row">
      <div class="col">
        <label for="id">아이디:</label>
        <input
          type="text"
          class="form-control"
          id="id"
          placeholder="Enter id"
          name="id"
        />
      </div>
      <div class="col align-self-end">
        <button type="button" class="btn btn-primary" id="btnIdCheck">
          중복확인
        </button>
      </div>
    </div>
    <div class="form-group">
      <label for="pass">비밀번호:</label>
      <input
        type="password"
        class="form-control"
        id="pass"
        placeholder="Enter password"
        name="pass"
      />
    </div>
    <div class="form-group">
      <label for="pass_check">비밀번호확인:</label>
      <input
        type="password"
        class="form-control"
        id="pass_check"
        placeholder="Enter password_check"
        name="pass_check"
      />
    </div>
    <div class="form-group">
      <label for="name">이름:</label>
      <input
        type="text"
        class="form-control"
        id="name"
        placeholder="Enter name"
        name="name"
      />
    </div>
    <div class="form-group">
      <label for="addr">주소:</label>
      <input
        type="text"
        class="form-control"
        id="addr"
        placeholder="Enter addr"
        name="addr"
      />
    </div>
    <button type="button" class="btn btn-primary btn-sm" id="btnJoin">
      회원가입
    </button>
  </form>
</div>
<script type="text/javascript" src="/js/member.js"></script>
<%@ include file="../includes/footer.jsp" %>
