<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/inc/date_picker/date_picker.html"/>
<jsp:include page="/WEB-INF/pages/common/header.jsp"/>

<link type="text/css" rel="stylesheet" href="css/main/main.css">
<script src="js/main/main.js"></script>
		

<div id="particle-canvas"></div>	
<div id="wrap_all" class="main_wrap_all">


	<div id="main">

		<h1 class="main-tit mu-f1">
			Musign System
			<svg viewBox="0 0 1320 300" class="title">
			  <text x="50%" y="50%" dy="0" text-anchor="middle">
				Musign System
			  </text>
			</svg>  
			<span class="main-stit">
				<em>Musigner management collaboration system</em>
			</span>
		</h1>



		<div id="main-side">
			<div class="member-wrap">
				<div class="login-box">

					<div class="tab-wrap">
						<div class="on">Login</div>
						<div>Join</div>
					</div>
					<!-- // tab-wrap -->

					<div class="tab-item-wrap">

						<div class="tab-item">
							<h2>Login</h2>
							<form id="loginForm" name="loginForm" method="post" action="login_proc.php">
								<div class="log-line">
									<input type="text" id="login_id" name="login_id" placeholder="Username">
									<input type="password" id="login_pw" name="login_pw" placeholder="Password" onkeydown="javascript:enter_check_login();">
								</div>       	
								<div class="chk-wrap chkbox">
									<input type="checkbox" id="remember_pw" name="remember_pw">        		
									<label for="remember_pw">
										<span></span>
										기억하기
									</label>
								</div>
								<div class="btn-wrap">
									<input type="button" onclick="login()" value="LOGIN" class="login_btn btn_full">
								</div>
							</form>
						</div>
						<!-- // tab-item -->

						<div class="tab-item" style="display:none;">
							<h2>Join</h2>

							<form id="joinForm" name="joinForm" method="post" action="join_proc.php">
							
							<div class="Account">
								<input type="hidden" id="team_eng" name="team_eng" value="development">

									<div id="joinId" class="join-row idInterval">
										<div class="jro-tit">아이디</div>
										<div class="jro-input">
											<input id="join_id" name="join_id" autocomplete="off" placeholder="아이디를 입력해주세요.">
										</div>
									</div>
									<!-- // join ID -->

									<div id="joinPassword" class="join-row">
										<div class="jro-tit">비밀번호</div>
										<div class="jro-input">
											<input id="join_pw" name="join_pw" autocomplete="off" type="password">
										</div>
									</div>
									<!-- // join Password -->

									<div id="joinEmail" class="join-row emailPart">
										<div class="jro-tit">이메일</div>  
										<div class="jro-input">
											<input id="join_email" name="join_email" autocomplete="off">
											<span class="emailText">@&nbsp;musign.net</span>
										</div>
									</div>
									<!-- // join Name email -->

									<div id="joinName" class="join-row">
										<div class="jro-tit">이름</div>  
										<div class="jro-input">
											<input id="join_name" name="join_name" autocomplete="off">
										</div>
									</div>
									<!-- // join Name End --> 
									
									<div id="joinYear" class="join-row joinYear">
										<div class="jro-tit">입사일</div>  
										<div class="jro-input">
											<select id="join_year" name="join_year">
												<option value="2014">2014</option>
												<option value="2015">2015</option>
												<option value="2016">2016</option>
												<option value="2017">2017</option>
												<option value="2018">2018</option>
												<option value="2019">2019</option>
												<option value="2020">2020</option>
												<option value="2021">2021</option>
												<option value="2022">2022</option>
												<option value="2023">2023</option>
												<option value="2024">2024</option>
												<option value="2025">2025</option>
												<option value="2026">2026</option>
												<option value="2027">2027</option>
												<option value="2028">2028</option>
												<option value="2029">2029</option>
											</select>		
											
											<select id="join_month" name="join_month">
												<option value="01">01</option>
												<option value="02">02</option>
												<option value="03">03</option>
												<option value="04">04</option>
												<option value="05">05</option>
												<option value="06">06</option>
												<option value="07">07</option>
												<option value="08">08</option>
												<option value="09">09</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
											</select>
																	
											<select id="join_day" name="join_day">
												<option value="01">01</option>
												<option value="02">02</option>
												<option value="03">03</option>
												<option value="04">04</option>
												<option value="05">05</option>
												<option value="06">06</option>
												<option value="07">07</option>
												<option value="08">08</option>
												<option value="09">09</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
												<option value="26">26</option>
												<option value="27">27</option>
												<option value="28">28</option>
												<option value="29">29</option>
												<option value="30">30</option>
												<option value="31">31</option>
											</select>
					
										</div>
									</div>
									<!-- // join Year End -->


									<div id="joinTeam" class="join-row team">
										<div class="jro-tit">팀</div>  
										<div class="jro-input">
											<select id="join_team" name="join_team" onchange="eng_title(this);">
											<option value="개발팀">Development Team</option>
												 <option value="크리에이티브(AD)_1팀">Creative(AD) 1 Team</option>
												 <option value="크리에이티브(AD)_2팀">Creative(AD) 2 Team</option>
												 <option value="크리에이티브(AE)">Creative(AE)</option>
												 <option value="커뮤니케이션팀">Communication Team</option>
												 <option value="경영지원">Management Support Team</option>	
												 <option value="HQ">HQ</option>	
											</select>
										</div>
									</div>
									<!-- // Team End -->

									<div id="joinPosition" class="join-row position">
										<div class="jro-tit">직급</div> 
										<div class="jro-input">
											<select id="join_level" name="join_level">
												<option value="사원">사원</option>
												<option value="주임">주임</option>
												<option value="선임">선임</option>
												<option value="책임">책임</option>
												<option value="수석">수석</option>
												<option value="본부장">본부장</option>
												<option value="대표이사">대표이사</option>
											</select>
										</div>
									</div>
									<!-- // Position End -->

							</div>
							<!-- // Account -->
						</form>
						<!-- // Form End -->

						</div>
						<!-- // tab-item2 -->

					</div>
					<!-- // tab-item-wrap -->

				</div><!--// login-box -->
			</div><!-- // member_wrap -->
		</div><!-- // main-side -->
	</div>
	<!-- // main -->
</div>

<jsp:include page="/WEB-INF/pages/common/footer.jsp"/>