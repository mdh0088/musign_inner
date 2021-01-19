<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/inc/date_picker/date_picker.html"/>
<jsp:include page="/WEB-INF/pages/common/header.jsp"/>

<link type="text/css" rel="stylesheet" href="/css/mypage/mypage.css">
<script src="/js/mypage/mypage.js"></script>

<div id="particle-canvas"></div>	

<div id="wrap_all">
	<div id="mypage_wrapper">
		<div class="inner">
		
			<div class="cellbox">
			
				<div class="cell cell1">
					<div class="info_box">
						<div class="ibox">
							<div class="profile_img_wrap">
								<img src="/img/mypage/profile_i.png">
							</div>
							<div class="profile_team_wrap">
								<a href="">Account Executive</a>
							</div>
						</div>
						<div class="cbox">
							<dl>
								<dt>name.</dt>
								<dd>kim min kyu</dd>
							</dl>
							<dl>
								<dt>mail.</dt>
								<dd>rarrit@musign.net</dd>
							</dl>
							<dl>
								<dt>tell.</dt>
								<dd>010.3507.6453</dd>
							</dl>	
						</div>
					</div>
				</div>
				
				<div class="cell cell2">
					<div class="content_box">
						<div class="quick_menu_wrap">
							<p>My Quick Menu</p>
							<ul>
								<li>
									<img src="/img/mypage/quick_i1.png">
									<span>구성원</span>
								</li>
								<li>
									<img src="/img/mypage/quick_i1.png">
									<span>구성원</span>
								</li>
								<li>
									<img src="/img/mypage/quick_i1.png">
									<span>구성원</span>
								</li>	
								<li class="quick_add_btn">
									<div></div>
								</li>
							</ul>
						</div>
						<!-- // quick_menu_wrap  -->
						
						<div class="latest_notice latest_box">
							<p class="myp_latest_tit">Notice</p>
							<ul>
								<li>
									<p class="latest_top">
										<span class="notice_tag">Notice</span>
										2021 뮤자인 KPI를 공지합니다.
									</p>
									<p class="latest_bottom">
										<span>작성자 : 이수린</span>
										<span>등록일 : 2021.01.02</span>
									</p>
								</li>
							</ul>
						</div>
						<!-- // latest_notice  -->
						
						<div class="latest_payment latest_box">
							<p class="myp_latest_tit">결제 현황</p>
							<ul>
								<li>
									<p class="latest_top">
										<span class="payment_num">번호 : 104-201231-2998</span>
										고도몰 솔루션 구매
									</p>
									<p class="latest_bottom">
										<span>종류 : 품의서</span>
										<span>상태 : 팀장승인</span>
									</p>
								</li>
							</ul>							
						</div>
						
					</div>
				</div>
				
			</div>
			<!-- // cell box  -->
			
			
		</div>
		<!-- // inner --> 
	</div>
	<!--// mypage_wrapper -->
</div>		

<jsp:include page="/WEB-INF/pages/common/footer.jsp"/>		